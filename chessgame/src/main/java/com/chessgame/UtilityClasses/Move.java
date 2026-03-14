package com.chessgame.UtilityClasses;

public class Move {
    private Cell startCell;
    private Cell endCell;

    public Move(Cell startCell , Cell endCell){
        this.startCell = startCell;
        this.endCell = endCell;
    }

    public boolean isMoveValid(){
        if(endCell.getPiece()==null){
            return true;
        }else{
            return !(startCell.getPiece().isWhite()==endCell.getPiece().isWhite());
        }
    }

    public Cell getStartCell(){
        return startCell;
    }
    public Cell getEndCell(){
        return endCell;
    }


}
