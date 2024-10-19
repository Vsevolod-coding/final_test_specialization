package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class TeachAnimalCommands extends Option{
    public TeachAnimalCommands(ConsoleUI consoleUI) {
        super("Обучить животное команде.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().teachAnimal();
    }
}
