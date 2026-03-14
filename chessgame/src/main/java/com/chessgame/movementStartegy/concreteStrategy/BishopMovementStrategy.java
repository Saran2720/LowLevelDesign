package com.chessgame.movementStartegy.concreteStrategy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;

public class BishopMovementStrategy implements MovementStrategy {

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Must move diagonally
        if (rowDiff != colDiff) {
            return false;
        }

        int rowStep = (endRow > startRow) ? 1 : -1;
        int colStep = (endCol > startCol) ? 1 : -1;

        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        // Check path is clear
        while (currentRow != endRow && currentCol != endCol) {
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
