package com.hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PlayerComparatorTest {
    @Test
    public void shouldReturnNegativeWhenFirstPlayerScoreIsLesserThanSecondPlayer() {
        Player player1 = new Player("", 1);
        Player player2 = new Player("", 2);

        int result = new PlayerComparator().compare(player1, player2);

        assertTrue(result < 0);
    }

    @Test
    public void shouldReturnPositiveWhenFirstPlayerScoreIsGreaterThanSecondPlayer() {
        Player player1 = new Player("", 2);
        Player player2 = new Player("", 1);

        int result = new PlayerComparator().compare(player1, player2);

        assertTrue(result > 0);
    }

    @Test
    public void shouldReturnZeroWhenFirstPlayerScoreAndNameIsEqualToSecondPlayer() {
        Player player1 = new Player("abc", 1);
        Player player2 = new Player("abc", 1);

        int result = new PlayerComparator().compare(player1, player2);

        assertTrue(result == 0);
    }

    @Test
    public void shouldReturnPositiveWhenFirstPlayerScoreIsEqualToSecondPlayerAndFirstPlayerNameIsAlphabeticallyLesserThanSecondPlayerName() {
        Player player1 = new Player("abc", 1);
        Player player2 = new Player("bcd", 1);

        int result = new PlayerComparator().compare(player1, player2);

        assertTrue(result > 0);
    }

    @Test
    public void shouldReturnNegativeWhenFirstPlayerScoreIsEqualToSecondPlayerAndFirstPlayerNameIsAlphabeticallyGreaterThanSecondPlayerName() {
        Player player1 = new Player("dcn", 1);
        Player player2 = new Player("bcd", 1);

        int result = new PlayerComparator().compare(player1, player2);

        assertTrue(result < 0);
    }
}

