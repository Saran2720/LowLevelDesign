package com.chessgame;



import java.util.Scanner;

import com.chessgame.Enums.Status;
import com.chessgame.UtilityClasses.Board;
import com.chessgame.UtilityClasses.Cell;
import com.chessgame.UtilityClasses.Move;
import com.chessgame.UtilityClasses.Player;
import com.chessgame.pieceFactoryPackage.Piece;
import com.chessgame.pieceFactoryPackage.concretepieces.King;

public class ChessGame {
    private Board board;

    private Player player1;
    private Player player2;
    boolean isWhiteTurn;
    private Status status;

    public ChessGame(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = Board.getInstance(8);
        this.isWhiteTurn = true;
        this.status = Status.ACTIVE;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        while(status == Status.ACTIVE){
            Player currPlayer = isWhiteTurn ? player1 : player2;
            System.out.println(currPlayer.getName()+ "turn " + (currPlayer.isWhiteSide()? "White": "Black"));

             // Ask for source coordinates
             System.out.print("Enter source row and column (e.g., 6 4): ");
             int startRow = scanner.nextInt();
             int startCol = scanner.nextInt();

             // Ask for destination coordinates
            System.out.print("Enter destination row and column (e.g., 4 4): ");
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();


            Cell startCell = board.getCell(startRow, startCol);
            Cell endCell = board.getCell(endRow, endCol);

            if(startCell==null || startCell.getPiece()==null){
                System.out.println("Invalid move: No piece at source cell.");
                continue;
            }
            Move move = new Move(startCell, endCell);

            makeMove(move, currPlayer);


        }
    }


    private void makeMove(Move move, Player curPlayer){
        Piece sourcePiece = move.getStartCell().getPiece();

        // Ensure player moves their own color
        if (sourcePiece.isWhite() != curPlayer.isWhiteSide()) {
            System.out.println("Invalid move: You can only move your own pieces.");
            return;
        }

        // Check capture rules (cannot capture own piece)
        if (!move.isMoveValid()) {
            System.out.println("Invalid move: Destination has your own piece.");
            return;
        }

        // Check piece-specific movement
        if (!sourcePiece.canMove(board, move.getStartCell(), move.getEndCell())) {
            System.out.println("Invalid move: Illegal movement for this piece.");
            return;
        }

        Piece destinationPiece = move.getEndCell().getPiece();

        if (destinationPiece != null) {
            // Handle capture
            if (destinationPiece instanceof King) {
                this.status = sourcePiece.isWhite() ? Status.WHITE_WIN : Status.BLACK_WIN;
            }
            destinationPiece.setKilled();
        }

        move.getEndCell().setPiece(sourcePiece);
        move.getStartCell().setPiece(null);

        // Switch turn after any successful move
        this.isWhiteTurn = !isWhiteTurn;
    }

}
