grammar ejercicio1;
A:'a';
B:'b';
prule:((A|B)(a|b))*;
a:A;
b:B;
WS : [ \n\r\t]+ -> skip;