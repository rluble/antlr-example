grammar Expression;            // Define a grammar called Hello

calc
  : e NEWLINE calc          {System.out.println($e.v.print() + "=" + $e.v.eval());}
  | NEWLINE
;

// In ANTlr operation precedence is determined by rule ordering, however associativity needs to be
// specified.
e returns [Expr v]
  : e1=e op=('*'|'/') e2=e {$v = new BinExpr($op.getText(), $e1.v, $e2.v);}
  | e1=e op=('+'|'-') e2=e {$v = new BinExpr($op.getText(), $e1.v, $e2.v);}
  | unaryMinus INT         {$v = new IntValue($unaryMinus.b ? -$INT.int : $INT.int);}
  | '-(' e1=e ')'          {$v = new UnaryExpr("-", $e1.v);}
  | '(' e1=e ')'           {$v = $e1.v;}
;

unaryMinus returns [boolean b]
  : '-' um=unaryMinus   {$b = !$um.b;}
  | '-'                 {$b = true;}
  |                     {$b = false;}
;
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
