## Создание базы данных
```sh
sudo mysql
```
```sh
CREATE DATABASE Human_Friends;
USE Human_Friends;
```

## Создание таблиц
__*Pets*__
```sh
CREATE TABLE Pets (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    type VARCHAR(40),
    dateOfBirth DATE,
    commands TEXT
);
```
__*PackAnimals*__
```sh
CREATE TABLE PackAnimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    type VARCHAR(40),
    dateOfBirth DATE,
    commands TEXT
);
```

## Заполнение таблиц данными
_Добавляем данные в **Pets**_
```sh
INSERT INTO Pets (name, type, dateOfBirth, commands) VALUES
('Sima', 'Cat', '2014-06-21', 'Paw, Sit, Meow'),
('Barsik', 'Dog', '2018-10-29', 'Sit, Bark'),
('Vaska', 'Cat', '2020-01-14', 'Come, Lie down, Jump'),
('Marshmallow', 'Hamster', '2023-11-11', 'Spin in a Circle, Go to a Specific Spot'),
('Peanut', 'Hamster', '2022-08-01', 'Roll, Spin'),
('Brock', 'Dog', '2022-12-20', 'Bark');
```

_Добавляем данные в **PackAnimals**_
```sh
INSERT INTO PackAnimals (name, type, dateOfBirth, commands) VALUES
('Bruno', 'Donkey', '2018-02-18', 'Kick, Walk'),
('Blaze', 'Horse', '2015-03-15', 'Gallop'),
('Sandy', 'Camel', '2019-10-16', 'Sit, Walk, Carry Load'),
('Oazis', 'Camel', '2010-04-20', 'Sit, Lie down, Carry Load');
```

## Удаление записи о верблюдах и объединение таблицы лошадей и ослов
_Удаление верблюдов_
```sh
DELETE FROM PackAnimals WHERE type = 'Camel';
```

_Создание новой таблицы_
```sh
CREATE TABLE Horses_And_Donkeys AS
    SELECT ID, name, type, dateOfBirth, commands 
    FROM PackAnimals WHERE type IN ('Horse', 'Donkey');
```

## Создание таблицы для животных в возрасте от 1 до 3 лет
```sh
CREATE TABLE YoungAnimals AS
SELECT ID, name, type, dateOfBirth, commands, TIMESTAMPDIFF(MONTH, dateOfBirth, CURDATE()) AS AgeInMonths
FROM Pets
WHERE TIMESTAMPDIFF(YEAR, dateOfBirth, CURDATE())
BETWEEN 1 AND 3;
```

## Объединение всех таблиц в одну
```sh
REATE TABLE AllAnimalsTogether AS
SELECT ID, name, type, dateOfBirth, commands, 'Pets' AS Origin
FROM Pets
UNION ALL
SELECT ID, name, type, dateOfBirth, commands, 'PackAnimals' AS Origin
FROM PackAnimals
WHERE type IN ('Horse', 'Donkey');
```

## Выход из MySQL
```sh
exit
```
