package ru.netology.QaCollections;

import java.util.HashMap;

public class Game {

    //List<Player> players = new ArrayList<>();

    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String key : players.keySet()) {
            Player player = players.get(key);
            if (player.getName().equals(playerName1)) {
                player1 = player;
            } else if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Player: " + playerName1 + " is not found");
        } else if (player2 == null) {
            throw new NotRegisteredException("Player: " + playerName2 + " is not found");
        }
        {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            }
            if (player2.getStrength() > player1.getStrength()) {
                return 2;
            } else {
                return 0;
            }
        }
    }
}