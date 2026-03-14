package com.chessgame.movementStartegy.concreteStrategy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;

public class KnightMovementStrategy implements MovementStrategy {

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Knight moves in L-shape: 2 by 1 or 1 by 2
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
