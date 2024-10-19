package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class ShowAllAnimals extends Option{
    public ShowAllAnimals(ConsoleUI consoleUI) {
        super("Показать всех животных", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println(getConsoleUI().showAllAnimals());
    }
}
