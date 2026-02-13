package com.example.Strategy;

import com.example.Enum.Symbol;
import com.example.Model.Cell;

public interface WinStrategy {
    public boolean checkWin(int row, int col, Symbol symbol, Cell[][] board);
}
