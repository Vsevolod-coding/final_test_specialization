package view.consoleUI;

import presenter.Presenter;
import view.View;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;
    private ConsoleInputHandler consoleInputHandler;
    private List<String> animalTypes;

    private static final int MIN_AVAILABLE = 1;

    public ConsoleUI() {
        work = true;
        consoleInputHandler = new ConsoleInputHandler(new Scanner(System.in));
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        animalTypes = presenter.getAnimalTypes();
    }

    @Override
    public void startApp(){
        greetings();
        checkAndOrCreateDefaultFile();
        presenter.readAnimalsData();
        showMainMenu();
    }

    private void greetings() {
        System.out.println("Добро пожаловать в программу «Реестр животных»!");
    }


    private void showMainMenu() {
        while (work) {
            System.out.println(mainMenu.showMenu());
            String strChoice = consoleInputHandler.getInput();
            if (consoleInputHandler.isMenuChoiceValid(strChoice, MIN_AVAILABLE, mainMenu.size())) {
                int choice = Integer.parseInt(strChoice);
                mainMenu.execute(choice);
            } else {
                System.out.println("Введен неверный параметр меню.\nВведите допустимое число из меню: от 1 до " + mainMenu.size());
            }
        }
    }

    public void createAnimal() {
        System.out.println("Какое животное вы хотите создать? (Введите одно из списка)");
        for (String animalType : animalTypes) {
            System.out.println("- " + animalType);
        }
		
		// Запрашиваем у пользователя данные (тип, имя, дату)
        String animalType = consoleInputHandler.getAnimalTypeInput(animalTypes);
        String name = getAnimalName();
        LocalDate birthDate = getBirthDate();

        switch (animalType.toLowerCase()) {
            case "camel":
                presenter.createCamel(name, birthDate);
                break;
            case "donkey":
                presenter.createDonkey(name, birthDate);
                break;
            case "horse":
                presenter.createHorse(name, birthDate);
                break;
            case "cat":
                presenter.createCat(name, birthDate);
                break;
            case "dog":
                presenter.createDog(name, birthDate);
                break;
            case "hamster":
                presenter.createHamster(name, birthDate);
                break;
            default:
                System.out.println("Неизвестный тип животного.");
        }

        System.out.println("Животное (" + animalType + ", " + name + ") успешно добавлено в реестр");
    }

    private String getAnimalName() {
        System.out.println("Введите имя животного:");
        return consoleInputHandler.getAnimalName();
    }

    private LocalDate getBirthDate() {
        System.out.println("Введите дату рождения животного (в формате dd-MM-yyyy):");
        return consoleInputHandler.getBirthDateInput();
    }

    public void teachAnimal() {
        System.out.println("Введите имя животного:");
        String name = consoleInputHandler.getInput();
        if (presenter.isAnimalWithNameExists(name)) {
            System.out.println("Введите команду:");
            String command = consoleInputHandler.getInput();
            presenter.teachAnimal(name, command);
            System.out.println("Животное по имени '" + name + "' обучено команде '" + command + "'.");
        } else {
            System.out.println("Животное по имени '" + name + "' не найдено.");
        }
    }

    public void showAnimalCommands() {
        System.out.println("Введите имя животного:");
        String name = consoleInputHandler.getInput();
        System.out.println(presenter.showAnimalCommands(name));
    }

    public String showTotalAnimalCount() {
        return presenter.showTotalAnimalCount();
    }

    public String showAllAnimals() {
        System.out.println("Список всех животных в реестре:");
        return presenter.showAllAnimals();
    }

    public String showAnimalByBirthDate() {
        System.out.println("Сортировка животных по дате рождения:");
        return presenter.showAnimalByBirthDate();
    }

    // Проверка на наличие дефолтного файла для хранения данных о животных и его создание, если он отсутствует
    private void checkAndOrCreateDefaultFile() {
        File defaultFile = new File(presenter.getPath());
        if (!defaultFile.exists()) {
            try {
                // Создаем новый файл
                if (defaultFile.createNewFile()) {
                    System.out.println("\nСоздан файл по умолчанию для хранения данных о животных: " + presenter.getPath());
                } else {
                    System.out.println("\nНе удалось создать файл по умолчанию: " + presenter.getPath());
                }
            } catch (IOException e) {
                System.out.println("\nОшибка при создании файла: " + presenter.getPath());
                e.printStackTrace();
            }
        } else {
            System.out.println("\nФайл по умолчанию с животными уже существует: " + presenter.getPath());
        }
    }

    @Override
    public void stopApp() {
        presenter.saveAnimalsData();
        consoleInputHandler.scanner.close();
        work = false;
        System.out.println("Пока-пока! Программа закрылась.\nДанные о животных сохранилось в файл: " + presenter.getPath());
    }
}
