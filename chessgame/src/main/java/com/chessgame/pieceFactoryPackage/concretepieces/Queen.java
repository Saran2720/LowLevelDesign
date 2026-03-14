package com.chessgame.pieceFactoryPackage.concretepieces;

import com.chessgame.movementStartegy.concreteStrategy.QueenMovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
public class Queen extends Piece {

    public Queen(boolean isWhitePiece){
        super(isWhitePiece, new QueenMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }



}
