import java.util.Scanner;

public class UserInterface implements IUserInterface{
    private ICurrencyCollection currencyCollection;
    private ICurrencyConverter currencyConverter;
    private Scanner scanner;
    public UserInterface(ICurrencyCollection currencyCollection, ICurrencyConverter currencyConverter) {
        this.currencyCollection = currencyCollection;
        this.currencyConverter = currencyConverter;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void getUserInput() {
        String inputCode = "";
        String outputCode = "";
        double value = 0;

        boolean validValue = false;
        while (!validValue) {
            System.out.println("Enter the source currency code:");
            inputCode = scanner.nextLine();
            System.out.println("Enter the target currency code:");
            outputCode = scanner.nextLine();

            if (currencyCollection.getCurrencies().containsKey(inputCode) && currencyCollection.getCurrencies().containsKey(outputCode)) {
                validValue = true;
            } else {
                System.out.println("At least one of the codes you provided is incorrect. Try again.");
            }
        }

        ICurrency inputCurrency = currencyCollection.getCurrencyByCode(inputCode);
        ICurrency outputCurrency = currencyCollection.getCurrencyByCode(outputCode);

        validValue = false;
        while (!validValue) {
            System.out.println("Enter the amount of cash:");
            while (!scanner.hasNextDouble()) {
                System.out.println("The value you provided isn't a number.\nEnter the amount of cash:");
                scanner.nextLine();
            }
            value = scanner.nextDouble();
            scanner.nextLine();

            if (value >= 0) {
                validValue = true;
            } else {
                System.out.println("A negative number was given.");
            }
        }
        currencyConverter.setInputCurrency(inputCurrency);
        currencyConverter.setOutputCurrency(outputCurrency);
        currencyConverter.setValue(value);
        System.out.printf(value + " " + inputCode + " = " + "%.2f" + " " + outputCode + "\n", currencyConverter.convert());
    }

    @Override
    public void start() {
        int choice = 0;
        while (choice != 3) {
            System.out.println("1 - show currencies list");
            System.out.println("2 - exchange");
            System.out.println("3 - exit");

            while(!scanner.hasNextInt()){
                System.out.println("The value you provided isn't a number.");
                System.out.println("1 - show currencies list");
                System.out.println("2 - exchange");
                System.out.println("3 - exit");
                scanner.nextLine();
            }

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    currencyCollection.showCurrencies();
                    break;
                case 2:
                    getUserInput();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("The option with the given number doesn't exist");
            }
        }
    }

}
