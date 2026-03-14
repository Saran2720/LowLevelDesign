package com.chessgame.movementStartegy.concreteStrategy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;

public class KingMovementStrategy implements MovementStrategy {

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // King moves one square in any direction (no castling here)
        return rowDiff <= 1 && colDiff <= 1 && (rowDiff + colDiff > 0);
    }
}
