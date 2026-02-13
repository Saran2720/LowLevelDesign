package com.example.Core;

import java.util.Scanner;

import com.example.Enum.GameStatus;
import com.example.Enum.Symbol;
import com.example.Model.Player;

public class Game {
    private Board board;
    private Player[] players;
    private int currPlayerIdx;
    private GameStatus gameStatus;
    private int n;

    public Game(int size, Player[] players) {
        this.board = new Board(size);
        this.n = players.length;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.players = new Player[n];

        for (int i = 0; i < n; i++) {
            this.players[i] = players[i];
        }

        this.currPlayerIdx = 0;
    }

    public void beginGame() {
        while (true) {
            Player currPlayer = players[currPlayerIdx];

            Scanner scanner = new Scanner(System.in);
            System.out.println(currPlayer.getName() + "'s turn");

            System.out.println("Enter the row: ");
            int row = scanner.nextInt();

            System.out.println("Enter the col: ");
            int col = scanner.nextInt();


            boolean moveValid = board.makeMove(row, col, currPlayer);

            boolean win = false;
            if (!moveValid) {
                System.out.println(currPlayer.getName() + " enter the position again");
                continue;
            } else {
                win = board.checkWin(row, col, currPlayer);
            }

            // if win announce the winner
            if (win) {
                gameStatus = currPlayer.getSymbol() == Symbol.O ? GameStatus.WINNER_O : GameStatus.WINNER_X;
                board.printBoard();
                announceWinner(gameStatus,currPlayer);
                break;
            }

            // check the board is full or not
            boolean isFull = board.checkBoardisFull();
            if (isFull) {
                gameStatus = GameStatus.DRAW;
                board.printBoard();
                break;
            }

            currPlayerIdx = (currPlayerIdx + 1) % 2;
            board.printBoard();
        }
    }

    private void announceWinner(GameStatus status, Player player){
        System.out.println("The game winner is "+ player.getName());
    }

    public void sample(){
        System.out.println("sample");
    }
    
}
