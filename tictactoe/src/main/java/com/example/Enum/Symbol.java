package com.example.Enum;

public enum Symbol {
    X('X'),
    O('O'),
    EMPTY('_');

    private final char displayChar;
    Symbol(char var){
        this.displayChar = var;
    }

    public char getDisplayChar(){
        return this.displayChar;
    }
}
