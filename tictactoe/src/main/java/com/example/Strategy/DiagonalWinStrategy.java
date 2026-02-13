package com.example.Strategy;

import com.example.Enum.Symbol;
import com.example.Model.Cell;

public class DiagonalWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(int row, int col, Symbol symbol, Cell[][] board){
        int n = board.length;
        
        //first diagonal check
        boolean firstDiagonal = true;
        for(int i=0;i<n;i++){
            if(board[i][i].getSymbol()!=symbol){
                firstDiagonal= false;
            }
        }

        if(firstDiagonal) return true;

        //second diagoanl check
        for(int i=0;i<n;i++){
            if(board[i][n-i-1].getSymbol()!=symbol){
                return false;
            }
        }
        
        return true;
    }
}
