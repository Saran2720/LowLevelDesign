package com.chessgame.movementStartegy;

import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;

public interface MovementStrategy {
    public boolean canMove(Board board, Cell startCell , Cell endCell);
}
