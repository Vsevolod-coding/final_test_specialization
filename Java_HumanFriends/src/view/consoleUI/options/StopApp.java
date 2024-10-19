package view.consoleUI.options;

import view.consoleUI.ConsoleUI;

public class StopApp extends Option{
    public StopApp(ConsoleUI consoleUI) {
        super("Завершить работу.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().stopApp();
    }
}
