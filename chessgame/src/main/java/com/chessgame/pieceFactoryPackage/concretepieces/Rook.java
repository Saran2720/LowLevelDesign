package com.chessgame.pieceFactoryPackage.concretepieces;
import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.concreteStrategy.RookMovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;

public class Rook extends Piece {

    public Rook(boolean isWhitePiece){
        super(isWhitePiece, new RookMovementStrategy());
    }


    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        return super.canMove(board, startCell, endCell);
    }


}
