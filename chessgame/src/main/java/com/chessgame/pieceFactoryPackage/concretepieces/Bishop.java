package com.chessgame.pieceFactoryPackage.concretepieces;
import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;

import com.chessgame.movementStartegy.concreteStrategy.BishopMovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;


public class Bishop extends Piece {

    public Bishop(boolean isWhitePiece){
        super(isWhitePiece, new BishopMovementStrategy());
    }

    
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }

}
