package com.chessgame.movementStartegy.concreteStrategy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.movementStartegy.MovementStrategy;
import com.chessgame.pieceFactoryPackage.Piece;

public class PawnMovementStrategy implements MovementStrategy {

    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        Piece pawn = startCell.getPiece();
        if (pawn == null) {
            return false;
        }

        int startRow = startCell.getRow();
        int startCol = startCell.getCol();
        int endRow = endCell.getRow();
        int endCol = endCell.getCol();

        int direction = pawn.isWhite() ? 1 : -1; // white pawns move "down" (increasing row), black "up"
        int rowDiff = endRow - startRow;
        int colDiff = Math.abs(endCol - startCol);

        // Destination occupancy
        boolean isForwardMove = (colDiff == 0);
        boolean isDiagonalMove = (colDiff == 1);

        // One step forward, must be empty
        if (isForwardMove && rowDiff == direction) {
            return endCell.getPiece() == null;
        }

        // Two steps forward from starting rank, must be empty along the way
        if (isForwardMove && rowDiff == 2 * direction) {
            int startRank = pawn.isWhite() ? 1 : (board.getCell(0, 0) != null ? 6 : 6); // assume 8x8: white row 1, black row 6
            if (startRow != startRank || endCell.getPiece() != null) {
                return false;
            }
            int middleRow = startRow + direction;
            Cell middleCell = board.getCell(middleRow, startCol);
            return middleCell != null && middleCell.getPiece() == null;
        }

        // Diagonal capture: must have opponent piece
        if (isDiagonalMove && rowDiff == direction) {
            return endCell.getPiece() != null && endCell.getPiece().isWhite() != pawn.isWhite();
        }

        return false;
    }
}
