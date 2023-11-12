
import java.util.Scanner;

public class ExpenseManagerCLI {

    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===========================");
            System.out.println("   Expense Money Manager");
            System.out.println("===========================");

            System.out.println("1. Create a new expense record");
            System.out.println("2. Search expenses by date");
            System.out.println("3. Read information of an existing expense record");
            System.out.println("4. Update information on an existing expense record");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createExpense(scanner, expenseManager);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    System.out.println("Exiting the Expense Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void createExpense(Scanner scanner, ExpenseManager expenseManager) {
        System.out.println("Enter expense details:");

        // Get user input
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Additional Note: ");
        String additionalNote = scanner.nextLine();

        // Set timestamp to the current date and time
        Expense expense = new Expense();
        expense.setTimestamp(new java.util.Date());
        expense.setAmount(amount);
        expense.setSubject(subject);
        expense.setAdditionalNote(additionalNote);

        // Add the expense
        expenseManager.createExpense(expense);

        System.out.println("Expense record created successfully!");
    }

    private static void searchExpenses(Scanner scanner, ExpenseManager expenseManager) {
    }

    private static void readExpense(Scanner scanner, ExpenseManager expenseManager) {

    }

    private static void updateExpense(Scanner scanner, ExpenseManager expenseManager) {
    }
}
