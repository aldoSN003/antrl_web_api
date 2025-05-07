import React, { useState } from 'react';
import Swal from 'sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

const ApiInputForm = () => {
    const [inputValue, setInputValue] = useState('');
    const [parseTree, setParseTree] = useState(null);
    const [tokens, setTokens] = useState([]);
    const [errors, setErrors] = useState(null);
    const [loading, setLoading] = useState(false);
    const [activeTab, setActiveTab] = useState('parseTree');

    const isDarkMode = document.documentElement.classList.contains('dark');

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!inputValue.trim()) {
            Swal.fire({
                icon: 'warning',
                title: 'Entrada Requerida',
                text: 'Por favor, ingresa un valor antes de enviar.',
                background: isDarkMode ? '#1f2937' : '#fff',
                color: isDarkMode ? '#f3f4f6' : '#111827',
            });
            return;
        }

        setLoading(true);
        try {
            console.log('Enviando entrada:', inputValue);
            const response = await fetch('http://localhost:8080/parse', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ expression: inputValue }),
            });

            if (!response.ok) {
                throw new Error(`El servidor respondió con ${response.status}`);
            }

            // Manejar la respuesta como texto primero
            const text = await response.text();
            console.log('Respuesta cruda:', text);

            // Analizar la respuesta
            let data;
            try {
                data = JSON.parse(text);
                console.log('Parsed data:', data);

                // Set parse tree
                setParseTree(data.parseTree);

                // Debug token information
                console.log(`Token count from API: ${data.tokenCount || 'unknown'}`);
                console.log('Tokens from API:', data.tokens);

                // Ensure tokens is always an array and not null or undefined
                if (Array.isArray(data.tokens)) {
                    console.log(`Setting ${data.tokens.length} tokens`);
                    setTokens(data.tokens);
                } else {
                    console.warn('No tokens array in response:', data);
                    setTokens([]);
                }

                setErrors(data.errors);
            } catch (e) {
                console.error('Error parsing JSON response:', e);
                // Si no es un JSON válido, simplemente mostrarlo tal cual
                setParseTree(text);
                setTokens([]);
                setErrors(null);
            }
        } catch (error) {
            console.error('Error de API:', error);
            Swal.fire({
                icon: 'error',
                title: 'Error de API',
                text: error.message,
                background: isDarkMode ? '#1f2937' : '#fff',
                color: isDarkMode ? '#f3f4f6' : '#111827',
            });
        } finally {
            setLoading(false);
        }
    };

    const renderTokensTable = () => {
        console.log('Current tokens:', tokens);

        if (!tokens || tokens.length === 0) {
            return (
                <div className="p-4 bg-yellow-50 dark:bg-yellow-900/30 border border-yellow-200 dark:border-yellow-700/50 rounded-lg">
                    <div className="flex items-center">
                        <svg className="w-5 h-5 mr-2 text-yellow-600 dark:text-yellow-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                        </svg>
                        <p className="text-yellow-800 dark:text-yellow-200 font-medium">No hay tokens disponibles.</p>
                    </div>
                    <p className="mt-2 text-sm text-yellow-700 dark:text-yellow-300">
                        Asegúrate de que la expresión contiene caracteres válidos para el analizador léxico.
                    </p>
                </div>
            );
        }

        return (
            <div className="overflow-x-auto mt-2">
                <table className="min-w-full divide-y divide-gray-200 dark:divide-gray-700">
                    <thead className="bg-gray-50 dark:bg-gray-800">
                    <tr>
                        <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Token</th>
                        <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Valor</th>
                    </tr>
                    </thead>
                    <tbody className="bg-white dark:bg-gray-900 divide-y divide-gray-200 dark:divide-gray-800">
                    {tokens.map((token, index) => (
                        <tr key={index} className={index % 2 === 0 ? 'bg-gray-50 dark:bg-gray-800' : 'bg-white dark:bg-gray-900'}>
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900 dark:text-gray-100">{token.type || 'UNKNOWN'}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500 dark:text-gray-400">{token.text || ''}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        );
    };

    return (
        <div className="max-w-2xl mx-auto mt-10 p-6 bg-white dark:bg-gray-800 shadow-xl rounded-2xl">
            <h2 className="text-2xl font-semibold mb-4 text-gray-800 dark:text-gray-100">Analizar Expresión</h2>
            <form onSubmit={handleSubmit} className="space-y-4">
                <input
                    type="text"
                    placeholder="Ingresa la expresión a analizar..."
                    value={inputValue}
                    onChange={(e) => setInputValue(e.target.value)}
                    className="w-full px-4 py-3 border border-gray-300 dark:border-gray-600 rounded-xl bg-white dark:bg-gray-700 text-gray-900 dark:text-gray-100 focus:outline-none focus:ring-2 focus:ring-blue-500"
                    required
                />
                <button
                    type="submit"
                    disabled={loading}
                    className="w-full py-3 bg-blue-600 text-white font-semibold rounded-xl hover:bg-blue-700 transition disabled:opacity-50"
                >
                    {loading ? 'Analizando...' : 'Analizar Expresión'}
                </button>
            </form>

            {parseTree && (
                <div className="mt-6 border rounded-xl bg-white dark:bg-gray-800 border-gray-200 dark:border-gray-700">
                    <div className="flex items-center mb-3 p-4 border-b border-gray-200 dark:border-gray-700">
                        {!errors || errors.length === 0 ? (
                            <div className="flex items-center px-3 py-1 bg-green-100 dark:bg-green-900 text-green-800 dark:text-green-100 rounded-full">
                                <svg className="w-5 h-5 mr-1 text-green-600 dark:text-green-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7"></path>
                                </svg>
                                <span className="font-medium text-sm">Sintaxis Válida</span>
                            </div>
                        ) : (
                            <div className="flex items-center px-3 py-1 bg-red-100 dark:bg-red-900 text-red-800 dark:text-red-100 rounded-full">
                                <svg className="w-5 h-5 mr-1 text-red-600 dark:text-red-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12"></path>
                                </svg>
                                <span className="font-medium text-sm">Sintaxis Inválida</span>
                            </div>
                        )}
                    </div>

                    <div className="border-b border-gray-200 dark:border-gray-700">
                        <nav className="flex -mb-px">
                            <button
                                onClick={() => setActiveTab('parseTree')}
                                className={`px-4 py-2 font-medium text-sm ${
                                    activeTab === 'parseTree'
                                        ? 'border-b-2 border-blue-500 text-blue-600 dark:text-blue-400'
                                        : 'text-gray-500 dark:text-gray-400 hover:text-gray-700 dark:hover:text-gray-300'
                                }`}
                            >
                                Árbol de Análisis
                            </button>
                            <button
                                onClick={() => setActiveTab('tokens')}
                                className={`px-4 py-2 font-medium text-sm ${
                                    activeTab === 'tokens'
                                        ? 'border-b-2 border-blue-500 text-blue-600 dark:text-blue-400'
                                        : 'text-gray-500 dark:text-gray-400 hover:text-gray-700 dark:hover:text-gray-300'
                                }`}
                            >
                                Tokens
                            </button>
                        </nav>
                    </div>

                    <div className="p-4">
                        {activeTab === 'parseTree' && (
                            <div>
                                <pre className="whitespace-pre-wrap break-words text-sm overflow-auto max-h-96 p-3 bg-gray-50 dark:bg-gray-900 rounded border border-gray-200 dark:border-gray-700 text-gray-800 dark:text-gray-200">
                                    {parseTree}
                                </pre>
                            </div>
                        )}

                        {activeTab === 'tokens' && renderTokensTable()}

                        {errors && errors.length > 0 && (
                            <div className="mt-4 pt-4 border-t border-red-200 dark:border-red-700">
                                <strong className="text-red-800 dark:text-red-400">Errores del Analizador:</strong>
                                <pre className="mt-2 whitespace-pre-wrap break-words text-sm overflow-auto max-h-96 p-3 bg-red-50 dark:bg-red-900/30 rounded border border-red-200 dark:border-red-700/50 text-red-800 dark:text-red-200">
                                    {errors}
                                </pre>
                            </div>
                        )}
                    </div>
                </div>
            )}
        </div>
    );
};

export default ApiInputForm;