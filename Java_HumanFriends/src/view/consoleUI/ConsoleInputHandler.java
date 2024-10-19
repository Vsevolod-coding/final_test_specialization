package view.consoleUI;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleInputHandler {
    Scanner scanner;

    public ConsoleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public String getAnimalName() {
        return getInput();
    }

    public String getAnimalTypeInput(List<String> animalTypes) {
        Set<String> animalSet = new HashSet<>();
        for (String animal : animalTypes) {
            animalSet.add(animal.toLowerCase());
        }
        while (true) {
            String animalType = getInput().toLowerCase();
            if (animalSet.contains(animalType)) {
                return toOrdinaryText(animalType);
            }
            System.out.println("Неверный выбор. Пожалуйста выберите тип животного из списка:");
            for (String animal : animalTypes) {
                System.out.println("- " + animal);
            }
        }
    }

    private String toOrdinaryText(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        } else {
            return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
        }
    }

    public LocalDate getBirthDateInput() {
        while (true) {
            String dateInput = getInput();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate today = LocalDate.now();
            try {
                LocalDate birthDate = LocalDate.parse(dateInput, dateFormat);
                if (birthDate.isAfter(today)) {
                    System.out.println("Дата рождения не может быть позже текущей даты. Введите допустимую дату:");
                } else {
                    System.out.println("Дата рождения животного успешно сохранилась.");
                    return birthDate;
                }
            } catch (DateTimeException | NumberFormatException e) {
                System.out.println("Ошибка формата даты: " + e.getMessage());
            }
        }
    }

    public boolean isMenuChoiceValid(String strChoice, int min, int max) {
        try {
            int intMenuChoice = Integer.parseInt(strChoice);
            return (intMenuChoice >= min) && (intMenuChoice <= max);
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
