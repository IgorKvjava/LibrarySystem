package ua.kvelinskiy.commands;

public interface Command {
    String execute(IRequestWrapper wrapper);
}
