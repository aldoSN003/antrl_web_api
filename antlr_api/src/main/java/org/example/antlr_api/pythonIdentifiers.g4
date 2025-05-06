grammar pythonIdentifiers;

Letter : [a-zA-Z];
Digit  : [0-9];



OpenParenthesis : '(';
ClosingParenthesis : ')';
EqualSign : '=';
InputWord : 'input';
DataType : 'int';

WS : [ \n\r\t]+ -> skip;
identifier : Letter (Letter | Digit)* ;
right:  DataType OpenParenthesis InputWord OpenParenthesis ClosingParenthesis ClosingParenthesis;
sentence : identifier EqualSign right;

test : sentence;
