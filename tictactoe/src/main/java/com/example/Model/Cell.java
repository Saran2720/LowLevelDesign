package com.example.Model;

import com.example.Enum.Symbol;

public class Cell {
    private Symbol symbol;

    public Cell(){
        this.symbol = Symbol.EMPTY;
    }

    public void placeSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
