package model.writer;

import model.animalRegistry.AnimalRegistry;

import java.io.*;

public class FileHandler implements Writer {

    private final String pathToFile = "src/AnimalRegistry.out";
    private File file = new File(pathToFile);

    @Override
    public void save(Serializable serializable) {
        // Используем try-with-resources для автоматического закрытия потока
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        Object readObject;
        if (fileIsEmpty(file)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
                objectOutputStream.writeObject(new AnimalRegistry());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFile))) {
            readObject = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return readObject;
    }

    @Override
    public String getPath() {
        return pathToFile;
    }

    private boolean fileIsEmpty(File file) {
        return file.length() == 0;
    }
}
