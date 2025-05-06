import React, { useState } from 'react';
import Swal from 'sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

const ApiInputForm = () => {
    const [inputValue, setInputValue] = useState('identifier=int(input())');
    const [parseTree, setParseTree] = useState(null);
    const [errors, setErrors] = useState(null);
    const [loading, setLoading] = useState(false);

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
                setParseTree(data.parseTree);
                setErrors(data.errors);
            } catch (e) {
                // Si no es un JSON válido, simplemente mostrarlo tal cual
                setParseTree(text);
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

    return (
        <div className="max-w-xl mx-auto mt-10 p-6 bg-white dark:bg-gray-800 shadow-xl rounded-2xl">
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
                <div className={`mt-6 p-4 border rounded-xl ${
                    !errors || errors.length === 0
                        ? "bg-green-50 dark:bg-green-900 border-green-200 dark:border-green-700 text-green-800 dark:text-green-100"
                        : "bg-red-50 dark:bg-red-900 border-red-200 dark:border-red-700 text-red-800 dark:text-red-100"
                }`}>
                    <div className="flex items-center mb-3">
                        {!errors || errors.length === 0 ? (
                            <>
                                <svg className="w-6 h-6 mr-2 text-green-600 dark:text-green-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7"></path>
                                </svg>
                                <strong>Sintaxis Válida</strong>
                            </>
                        ) : (
                            <>
                                <svg className="w-6 h-6 mr-2 text-red-600 dark:text-red-400" fill="none " stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12"></path>
                                </svg>
                                <strong>Sintaxis Inválida</strong>
                            </>
                        )}
                    </div>

                    <strong>Árbol de Análisis:</strong>
                    <pre className="mt-2 whitespace-pre-wrap break-words text-sm overflow-auto max-h-96">
                        {parseTree}
                    </pre>

                    {errors && errors.length > 0 && (
                        <div className="mt-4 pt-4 border-t border-red-200 dark:border-red-700">
                            <strong>Errores del Analizador:</strong>
                            <pre className="mt-2 whitespace-pre-wrap break-words text-sm overflow-auto max-h-96">
                                {errors}
                            </pre>
                        </div>
                    )}
                </div>
            )}
        </div>
    );
};

export default ApiInputForm;