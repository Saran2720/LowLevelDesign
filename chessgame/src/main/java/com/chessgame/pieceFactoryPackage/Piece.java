package com.chessgame.pieceFactoryPackage;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;

public abstract class Piece {
    private boolean isWhitePiece;
    private boolean killed;
    protected MovementStrategy strategy;

    public Piece(boolean isWhitePiece, MovementStrategy strategy) {
        this.isWhitePiece = isWhitePiece;
        this.strategy = strategy;
        this.killed = false;
    }

    public boolean isWhite() {
        return isWhitePiece;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled() {
        killed = true;
    }

    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        if (killed || startCell == null || endCell == null) {
            return false;
        }
        if (startCell == endCell) {
            return false;
        }
        return strategy != null && strategy.canMove(board, startCell, endCell);
    }
}
