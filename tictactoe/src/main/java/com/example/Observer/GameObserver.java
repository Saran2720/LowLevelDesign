package com.example.Observer;

import com.example.Model.Player;

public interface GameObserver {
    public void update(Player winner);
}
