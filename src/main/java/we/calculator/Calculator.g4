grammar Calculator;

calculate: expression;

expression: number                               #simple
          | '(' expression ')'                   #paren
          | left=expression op=('*'|'/') right=expression   #highOrder
          | left=expression op=('+'|'-') right=expression   #lowOrder;

number: INTEGER;

INTEGER: DIGIT+;

fragment DIGIT: [0-9];

WS: [ \r\n\t]+ -> channel(HIDDEN);