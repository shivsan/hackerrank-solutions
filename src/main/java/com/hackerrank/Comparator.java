package com.hackerrank;

public class Comparator {
}

class Checker implements java.util.Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        return 0;
    }

}

class PlayerComparator implements java.util.Comparator<Player> {
    private final int GREATER = 1;
    private final int LESSER = -1;

    @Override
    public int compare(Player player1, Player player2) {
        if (player1.score < player2.score)
            return LESSER;
        if (player1.score > player2.score)
            return GREATER;

        return -1 * (player1.name.compareTo(player2.name));
    }
}

class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
