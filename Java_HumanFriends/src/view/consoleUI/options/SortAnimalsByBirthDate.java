package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class SortAnimalsByBirthDate extends Option{
    public SortAnimalsByBirthDate(ConsoleUI consoleUI) {
        super("Отсортировать животных по дате рождения.", consoleUI);
    }

    @Override
    public void execute() {
        System.out.println(getConsoleUI().showAnimalByBirthDate());
    }
}
