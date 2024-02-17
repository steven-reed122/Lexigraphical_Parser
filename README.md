# Basic Language Lexical Analyzer
Takes a string of characters and parses it lexigraphically into a stream of tokens which it prints as the output. This could be used as the first step in the compilation of a simple programming language.

The valid characters that can be parsed are as follows (it is case sensitive and "qoutations" are should be not present in real code, they are for formatting and readability purposes in this document):

- "if"          -> [IF]
- "for"         -> [FOR]
- "while"       -> [WHILE]
- "procedure"   -> [PROCEDURE]
- "return"      -> [RETURN]
- "int"         -> [INT]
- "else"        -> [ELSE]
- "do"          -> [DO]
- "break"       -> [BREAK]
- "end"         -> [END]
- "="           -> [ASSIGN]
- "+"           -> [ADD_OP]
- "-"           -> [SUB_OP]
- "*"           -> [MUL_OP]
- "/"           -> [DIV_OP]
- "%"           -> [MOD_OP]
- ">"           -> [GT]
- "<"           -> [LT]
- ">="          -> [GE]
- "<="          -> [LE]
- "++"          -> [INC]
- "("           -> [LP]
- ")"           -> [RP]
- "{"           -> [LB]
- "}"           -> [RB]
- "|"           -> [OR]
- "&"           -> [AND]
- "=="          -> [EE]
- "!"           -> [NEG]
- ","           -> [COMMA]
- ";"           -> [SEMI]
- "integer*"    -> [INT_CONST]
- "identifiers*"-> [IDENT]

* integer is any uniterrupted string of digits
* identifier is any uninterrupted string of alphanumeric characters, they must begin with a letter
