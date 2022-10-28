package ru.netology.tourney;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void firstPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Denis", 10);
        Player player2 = new Player(2, "Vitya", 5);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Denis", "Vitya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Denis", 5);
        Player player2 = new Player(2, "Vitya", 10);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Denis", "Vitya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalForces() {
        Game game = new Game();
        Player player1 = new Player(1, "Denis", 10);
        Player player2 = new Player(2, "Vitya", 10);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Denis", "Vitya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player1IsNotRegistered() {
        Game game = new Game();

        Player player1 = new Player(1, "Denis", 10);
        Player player2 = new Player(2, "Vitya", 10);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Dima", "Vitya");
                });
    }

    @Test
    public void player2IsNotRegistered() {
        Game game = new Game();

        Player player1 = new Player(1, "Denis", 10);
        Player player2 = new Player(2, "Vitya", 10);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Denis", "Dima");
                });
    }
}