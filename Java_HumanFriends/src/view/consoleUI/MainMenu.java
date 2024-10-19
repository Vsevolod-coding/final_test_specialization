package view.consoleUI;

import view.consoleUI.options.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Option> options;

    public MainMenu(ConsoleUI consoleUI) {
        options = new ArrayList<>();
        options.add(new CreateAnimal(consoleUI));
        options.add(new ShowAllAnimals(consoleUI));
        options.add(new ShowTotalAnimalsCount(consoleUI));
        options.add(new ShowAnimalCommands(consoleUI));
        options.add(new TeachAnimalCommands(consoleUI));
        options.add(new SortAnimalsByBirthDate(consoleUI));
        options.add(new StopApp(consoleUI));
    }

    public String showMenu() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nВыберите пожалуйста одну из опций меню:\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(options.get(i).getDescription())
                    .append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Option option = options.get(choice - 1);
        option.execute();
    }

    public int size() {
        return options.size();
    }
}
