package model.animalTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalTypesReader {
    private static final String FILE_PATH = "src/model/animal/animal_types.txt";

	// Метод для чтения типов животных из файла и возвращения их в виде списка
    public List<String> getAnimalTypes() {
        List<String> animalTypes = new ArrayList<>();

        // Чтение файла и вывод содержимого
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                animalTypes.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return animalTypes;
    }
}
