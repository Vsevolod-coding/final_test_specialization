package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class CreateAnimal extends Option{
    public CreateAnimal(ConsoleUI consoleUI) {
        super("Добавить новое животное.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().createAnimal();
    }
}
