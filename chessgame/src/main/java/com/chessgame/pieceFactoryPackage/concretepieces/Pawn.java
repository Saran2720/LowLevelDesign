package com.chessgame.pieceFactoryPackage.concretepieces;
import com.chessgame.movementStartegy.concreteStrategy.PawnMovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;

public class Pawn extends Piece {

    public Pawn(boolean isWhitePiece){
        super(isWhitePiece, new PawnMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }



}