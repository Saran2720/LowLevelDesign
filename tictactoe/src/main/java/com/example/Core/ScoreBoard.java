package com.example.Core;

import java.util.ArrayList;
import java.util.List;

import com.example.Model.Match;
import com.example.Model.Player;
import com.example.Observer.GameObserver;

public class ScoreBoard implements GameObserver {
    private static ScoreBoard instance;
    private List<Match> matches;
    private Match currentMatch;

    private ScoreBoard(){
        this.matches = new ArrayList<>();
    }

    public static ScoreBoard getInstance(){
        if(instance == null){
            instance = new ScoreBoard();
        }
        return instance;
    }

    public void setCurrentMatch(Match match) {
        this.currentMatch = match;
    }

    @Override
    public void update(Player winner) {
        if (currentMatch != null) {
            matches.add(currentMatch);
            currentMatch = null; // Reset for next match
        }
    }

    public List<Match> getMatches() {
        return new ArrayList<>(matches); // Return a copy to prevent external modification
    }

    public int getMatchCount() {
        return matches.size();
    }

    public void printScoreBoard(){
        System.out.println("=== Score Board ===");
        if (matches.isEmpty()) {
            System.out.println("No matches completed yet.");
        } else {
            System.out.println("Total matches: " + matches.size());
            for(Match match : matches){
                System.out.println(match.toString());
            }
        }
    }
}
