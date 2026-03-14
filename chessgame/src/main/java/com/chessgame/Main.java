package com.chessgame;

import com.chessgame.UtilityClasses.Player;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("player1", true);

        Player p2 = new Player("Player2", false);

        ChessGame game = new ChessGame(p1, p2);

        game.start();

    }
}