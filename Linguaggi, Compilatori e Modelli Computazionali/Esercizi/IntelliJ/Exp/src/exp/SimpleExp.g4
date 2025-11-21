grammar SimpleExp;

@lexer::members {
    int lexicalErrors=0;
}

// PARSER RULES

prog: exp EOF {
    System.out.println("End of Parsing");
};

exp     : <assoc=right> exp TIMES exp #expProd1 // default:<assoc=left>
        | <assoc=right> exp MINUS exp #expProd2
        | <assoc=right> LPAR exp RPAR #expProd3
        | <assoc=right> NUM           #expProd4;

// LEXER RULES

MINUS   : '-';
TIMES   : '*';
LPAR    : '(';
RPAR    : ')';
NUM     : '0' | ('1'..'9') ('0'..'9')* ;

WHITESP : (' ' | '\t' | '\n' | '\r')+ -> channel(HIDDEN); // roba inutile da nuclearizzare prima del parser
COMMENT : ('/*' .*? '/*') -> channel(HIDDEN); // uso la stella di Kleene non greedy (disabilito maximal match)

ERR     : . {
    System.out.println("Invalid char: "+ getText());
    lexicalErrors++;
} -> channel(HIDDEN);

