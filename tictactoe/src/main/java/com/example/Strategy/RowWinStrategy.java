package com.example.Strategy;

import com.example.Enum.Symbol;
import com.example.Model.Cell;

public class RowWinStrategy implements WinStrategy{

    @Override
    public boolean checkWin(int row, int col, Symbol symbol,Cell[][] board){
        int n = board.length;
        for(int i=0;i<n;i++){
            if(board[row][i].getSymbol()!=symbol){
                return false;
            }
        }
        return  true;
    }
}
