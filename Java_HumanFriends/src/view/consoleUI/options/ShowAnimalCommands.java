package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class ShowAnimalCommands extends Option{
    public ShowAnimalCommands(ConsoleUI consoleUI) {
        super("Показать команды конкретного животного.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showAnimalCommands();
    }
}
