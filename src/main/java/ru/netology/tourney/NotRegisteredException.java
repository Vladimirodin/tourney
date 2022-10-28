package ru.netology.tourney;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {
        super("Player with that name is not registered");
    }
}
