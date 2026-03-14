package com.example.Model;

// import com.example.Enum.GameStatus;
import com.example.Enum.Symbol;
import com.example.Observer.GameObserver;

public class Match implements GameObserver{
    private Player xPlayer;
    private Player oPlayer;
    private Symbol winnerPSymbol;
    private Player winnerPlayer;

    public Match(Player xPlayer, Player oPlayer){
        this.xPlayer= xPlayer;
        this.oPlayer=oPlayer;
    }

    public void update(Player winner){
        this.winnerPlayer = winner;
        
        if (winner != null) {
            this.winnerPSymbol = winner.getSymbol();
        } else {
            this.winnerPSymbol = null; // Draw case
        }
    }

    @Override
    public String toString() {
        return "Match [xPlayer=" + xPlayer + ", oPlayer=" + oPlayer + ", winnerPSymbol=" + winnerPSymbol
                + ", winnerPlayer=" + winnerPlayer + ", toString()=" + super.toString() + "]";
    }

    
}
