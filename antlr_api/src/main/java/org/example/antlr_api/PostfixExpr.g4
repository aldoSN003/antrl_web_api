grammar PostfixExpr;

expr: validExpr EOF;

validExpr
    : operand                        # singleOperand
    | validExpr validExpr operator   # binaryOperation
    ;

operand: NUMBER;

operator: PLUS | MINUS | TIMES | DIV;

PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';

NUMBER: [0-9]+;

WS: [ \t\r\n]+ -> skip;
