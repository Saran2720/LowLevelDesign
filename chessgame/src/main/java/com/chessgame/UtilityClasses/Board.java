package com.chessgame.UtilityClasses;

import com.chessgame.pieceFactoryPackage.PieceFactory;

public class Board {
    private static Board instance;
    private Cell[][] board;

    private Board(int rows){
        initializeBoard(rows);
    }

    public static Board getInstance(int rows){
        if(instance==null){
            instance = new Board(rows);
        }
        return instance;
    }

    private void initializeBoard(int rows){
        board = new Cell[rows][rows];

        //white pieces
        setPieceRow(0,true);
        setPawnPieceRow(1,true);

        //blackPieces
        setPieceRow(rows-1, false);
        setPawnPieceRow(rows-2, false);
    }


    private void setPieceRow(int row, boolean isWhite){
        board[row][0]= new Cell(row, 0, PieceFactory.creatPiece(
            "rook", isWhite));

        board[row][1] = new Cell(row, 1, PieceFactory.creatPiece("knight", isWhite));

        board[row][2] = new Cell(row, 2, PieceFactory.creatPiece("bishop", isWhite));

        board[row][3] = new Cell(row, 3, PieceFactory.creatPiece("king", isWhite));

        board[row][4] = new Cell(row, 4, PieceFactory.creatPiece("queen", isWhite));

        board[row][5] = new Cell(row, 5, PieceFactory.creatPiece("bishop", isWhite));

        board[row][6] = new Cell(row, 6, PieceFactory.creatPiece("knight", isWhite));

        board[row][7]= new Cell(row, 7, PieceFactory.creatPiece(
            "rook", isWhite));
    }

    private void setPawnPieceRow(int row, boolean isWhite){
        for(int i=0;i<8;i++){
            board[row][i] = new Cell(row, i, PieceFactory.creatPiece("pawn", isWhite));
        }
    }

    public Cell getCell(int row , int col){
        if(row>=0 && row< board.length && col>=0 && col< board.length){
            return board[row][col];
        }
        return null;
    }
}

