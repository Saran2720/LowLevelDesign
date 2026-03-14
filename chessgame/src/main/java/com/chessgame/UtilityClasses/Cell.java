package com.chessgame.UtilityClasses;

import com.chessgame.pieceFactoryPackage.Piece;

public class Cell {
   private  int row;
    private int col;
    private Piece piece;

    public Cell(int row, int col, Piece piece){
        this.col =col;
        this.row=row;
        this.piece=piece;
    }


    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece(){
        return piece;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}
