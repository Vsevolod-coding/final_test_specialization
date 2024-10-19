package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public abstract class Option {
    private final String description;
    private ConsoleUI consoleUI;

    public Option(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    protected ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
