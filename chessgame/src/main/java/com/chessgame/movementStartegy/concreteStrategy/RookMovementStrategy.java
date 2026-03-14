package com.chessgame.movementStartegy.concreteStrategy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;

public class RookMovementStrategy implements MovementStrategy {

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        // Rook moves only in straight lines
        if (startRow != endRow && startCol != endCol) {
            return false;
        }

        // Determine direction
        int rowStep = Integer.compare(endRow, startRow);
        int colStep = Integer.compare(endCol, startCol);

        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        // Check path is clear (ignore final cell; capture rules handled elsewhere)
        while (currentRow != endRow || currentCol != endCol) {
            Cell pathCell = board.getCell(currentRow, currentCol);
            if (pathCell != null && pathCell.getPiece() != null) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }

        return true;
    }
}
