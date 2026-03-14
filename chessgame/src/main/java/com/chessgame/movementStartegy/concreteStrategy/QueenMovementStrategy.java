package com.chessgame.movementStartegy.concreteStrategy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;

public class QueenMovementStrategy implements MovementStrategy {

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Queen moves like rook or bishop
        boolean isStraight = (startRow == endRow || startCol == endCol);
        boolean isDiagonal = (rowDiff == colDiff);

        if (!isStraight && !isDiagonal) {
            return false;
        }

        int rowStep = Integer.compare(endRow, startRow);
        int colStep = Integer.compare(endCol, startCol);

        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        // If straight move, one of steps will be 0; loop still works
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
