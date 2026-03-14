package com.chessgame.pieceFactoryPackage.concretepieces;
import com.chessgame.movementStartegy.concreteStrategy.KnightMovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
public class Knight extends Piece {

    public Knight(boolean isWhitePiece){
        super(isWhitePiece,new KnightMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }



}