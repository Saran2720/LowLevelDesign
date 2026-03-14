package com.chessgame.pieceFactoryPackage.concretepieces;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.concreteStrategy.KingMovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;

public class King extends Piece {

    public King(boolean isWhitePiece) {
        super(isWhitePiece, new KingMovementStrategy());
    }

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }


}
