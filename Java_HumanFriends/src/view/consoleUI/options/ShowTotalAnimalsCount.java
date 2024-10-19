package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class ShowTotalAnimalsCount extends Option{
    public ShowTotalAnimalsCount(ConsoleUI consoleUI) {
        super("Показать количество всех животных.", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println(getConsoleUI().showTotalAnimalCount());
    }
}
