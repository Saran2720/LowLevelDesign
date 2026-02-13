package com.example.Core;

import com.example.Enum.Symbol;
import com.example.Exception.InvalidPositionException;
import com.example.Model.Cell;
import com.example.Model.Player;
import com.example.Strategy.ColWinStrategy;
import com.example.Strategy.DiagonalWinStrategy;
import com.example.Strategy.RowWinStrategy;
import com.example.Strategy.WinStrategy;
import java.util.List;
import java.util.ArrayList;

public class Board {
    private final int size;
    public Cell[][] board;
    List<WinStrategy> strategies;

    Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        this.strategies = new ArrayList<>();
        initializeBoard();
        initializeStrategies();
    }

    public boolean makeMove(int row, int col, Player player){

         try{
            validPosition( row, col);
         }catch(InvalidPositionException e){
            System.err.println(e.getMessage());
            return false;
         }

        if(!chechCellisEpmty(row, col)){
            System.out.println("This is Postion has already occupied");
            return false;
        }

        Symbol pSymbol = player.getSymbol();

        board[row][col].placeSymbol(pSymbol);
        return true;
    }

    public boolean checkWin(int row, int col, Player player){
        Symbol pSymbol = player.getSymbol();
        for(WinStrategy strategy:strategies){
            boolean win= strategy.checkWin(row, col, pSymbol, board);
            if(win){
               return true;
            }
       }
       return false;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public boolean checkBoardisFull() {
        boolean isFull = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getSymbol() == Symbol.EMPTY) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public void printBoard() {
        System.out.println();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol currSymbol = board[i][j].getSymbol();
                if (currSymbol != Symbol.EMPTY) {
                    System.out.print(currSymbol.getDisplayChar());
                } else {
                    System.out.print(' ');
                }

                if (j < size - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < size - 1) {
                int count = size * 2 - 1;
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < count; c++) {
                    sb.append("--");
                }
                System.out.print(sb.toString());
            }
            System.out.println();
        }
    }

    private boolean chechCellisEpmty(int row, int col) {
        return board[row][col].getSymbol() == Symbol.EMPTY;
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    private void initializeStrategies() {
        WinStrategy rowStrategy = new RowWinStrategy();
        WinStrategy colStrategy = new ColWinStrategy();
        WinStrategy diagonalStrategy = new DiagonalWinStrategy();

        strategies.add(rowStrategy);
        strategies.add(colStrategy);
        strategies.add(diagonalStrategy);
    }

    private void validPosition(int row, int col) throws InvalidPositionException {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new InvalidPositionException("Postion " + row + "," + col + "is out of bound");
        }
    }

}
