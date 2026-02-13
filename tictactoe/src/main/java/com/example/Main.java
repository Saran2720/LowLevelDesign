package com.example;


import java.util.Scanner;

import com.example.Core.Game;
import com.example.Enum.Symbol;
import com.example.Model.Player;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of player1 : ");
        String p1Name = scanner.nextLine();
        Player player1 = new Player(p1Name,Symbol.X);

        System.out.println("Name of player2 : ");
        String p2Name = scanner.nextLine();
        Player player2 = new Player(p2Name, Symbol.O);

        Game game = new Game(3, new Player[]{player1,player2});
        game.beginGame();
    }
}