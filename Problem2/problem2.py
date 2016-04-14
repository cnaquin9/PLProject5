tokens = ('MY', 'WORD', 'ORDINAL', 'NUMBER', 'PARTRIDGE', 'AND')
literals = ['.', ':', ','  ]

# Tokens
ordinals = ['first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eighth','ninth', 'tenth', 'eleventh', 'twelfth']

numbers = {'A': 1, 'Two': 2,'Three': 3,'Four': 4,'Five': 5,'Six': 6,'Seven': 7,'Eight': 8,'Nine': 9,'Ten': 10,'Eleven': 11,'Twelve': 12}


def t_MY(t):
    r'^My.*$'
    return t


def t_PARTRIDGE(t):
    r'partridge.*tree'
    return t

def t_AND(t):
    r'\band\b'
    return t

def t_WORD(t):
    r'\b[\w-]+\b'
    # check that the value is in the ordinal
    if t.value in ordinals:
        t.value = t.value.capitalize()
        t.type = "ORDINAL"
    elif t.value in numbers:
        t.value = numbers[t.value]
        t.type = "NUMBER"
    return t


# Ignored characters
t_ignore = " \r"


def t_newline(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)

# Build the lexer
import ply.lex as lex   # ply.lex comes from the ply folder in the PLY download.
lexer = lex.lex()

# Parsing rules

global time_step
time_step = 0

def p_start(t):
    '''start : MY
             | WORD
             | ORDINAL
             | NUMBER
             | day
             | partridge
             | gift
             | empty
    '''

def p_day(t):
    'day : WORD WORD ORDINAL WORD WORD WORD ","'
    print "\nGifts given on the", t[3],t[4] ,"of Christmas: "

def p_partridge(t):
    'partridge : NUMBER PARTRIDGE "."'
    print (t[1], t[2])

def p_gift(t):
    'gift : NUMBER WORD WORD'
    print (t[1], t[2], t[3])

def p_gift_and(t):
    'gift : NUMBER WORD WORD AND'
    print (t[1], t[2], t[3])

def p_empty(t):
    'empty : '
    pass

def p_error(t):
    if t == None:
        print("Syntax error at '%s'" % t)
    else:
        print("Syntax error at '%s'" % t.value)

import ply.yacc as yacc
parser = yacc.yacc()

while True:
    try:
        s = raw_input('')
    except EOFError:
        break
    parser.parse(s)