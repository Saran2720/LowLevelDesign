package com.chessgame.pieceFactoryPackage;

import com.chessgame.pieceFactoryPackage.concretepieces.Bishop;
import com.chessgame.pieceFactoryPackage.concretepieces.King;
import com.chessgame.pieceFactoryPackage.concretepieces.Knight;
import com.chessgame.pieceFactoryPackage.concretepieces.Pawn;
import com.chessgame.pieceFactoryPackage.concretepieces.Queen;
import com.chessgame.pieceFactoryPackage.concretepieces.Rook;

public class PieceFactory {
    public static Piece creatPiece(String pieceType,boolean isWhitePiece){
        switch (pieceType) {
            case "king":
                return new King(isWhitePiece);
            case "queen":
                return new Queen(isWhitePiece);
            case "rook":
                return new Rook(isWhitePiece);
            case "bishop":
                return new Bishop(isWhitePiece);
            case "pawn":
                return new Pawn(isWhitePiece);
            case "knight":
                return new Knight(isWhitePiece);
        
            default:
                throw new IllegalArgumentException("Unknown piece type: " + pieceType);
        }
    }
}
