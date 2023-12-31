package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static String WRONG_VALUE = "Invalid value entered";
    private Presenter presenter;
    private final Menu mainMenu;
    private final Scanner scanner;
    private boolean run;


    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.run = true;
        mainMenu = new Menu(this);
    }

    private void printWelcome() {
        print("Welcome");
    }
    @Override
    public void addToys(){
        presenter.addToys();
    }
    @Override
    public void start() throws IOException, ClassNotFoundException {
        printWelcome();
        while (run) {
            this.printMenu();
            this.execute();
        }
    }

    @Override
    public void loadShop() {
        int count = inputInt("Enter the number of toys:");
        boolean fillRun = true;
        int[] ids = new int[count];
        String[] names = new String[count];
        double[] frequencies = new double[count];
        print("Drop toys");
        for (int i = 0; i < count; i++) {
            print(String.format("Enter the details of the toy:", i + 1));
            fillRun = true;
            while (fillRun) {
                String line = inputString("separated by space: 'id' 'Name' 'Chance  drop' (0,01 - 0,99)");
                try (Scanner toyScanner = new Scanner(line)) {
                    ids[i] = toyScanner.nextInt();
                    names[i] = toyScanner.next();
                    frequencies[i] = toyScanner.nextDouble();
                    if (frequencies[i] <= 0.99 && frequencies[i] >= 0.01) {
                        fillRun = false;
                    } else {
                        print(WRONG_VALUE );
                    }
                } catch (InputMismatchException | IllegalStateException | NullPointerException e) {
                    print(WRONG_VALUE );
                }
            }
        }
        presenter.fillToyList(ids, names, frequencies);
    }

    @Override
    public void getToy() {
        presenter.getToy();
    }

    @Override
    public void saveToysQueue() {
        String path = inputString("Input name") + ".txt";
        presenter.saveToysQueue(path);
    }


    @Override
    public void execute() throws IOException, ClassNotFoundException {
        System.out.print("Input command :");
        String userInput = scanner.nextLine();
        if (checkTextForInt(userInput)){
            int numCommand = Integer.parseInt(userInput);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private String inputString(String message) {
        print(message);
        return scanner.nextLine();
    }

    private int inputInt(String message) {
        int number = 0;
        boolean inputRun = true;
        while (inputRun) {
            try {
                number = Integer.parseInt(inputString(message).trim());
                inputRun = false;
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_VALUE + "\n");
            }
        }
        return number;
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            this.print(WRONG_VALUE + "\n");
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            this.print(WRONG_VALUE + "\n");
            return false;
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printMenu() {
        print(mainMenu.print());
    }

    @Override
    public void exit() {
        run = false;
        print("Exit.");
    }
}