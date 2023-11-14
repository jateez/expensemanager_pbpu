
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ExpenseManagerCLI {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
            System.out.println("5. Delete an item on an existing record");
            System.out.println("6. Clear all expenses");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createExpense(scanner, expenseManager);
                    break;
                case 2:
                    searchExpenses(scanner, expenseManager);
                    break;
                case 3:
                    readExpenses(scanner, expenseManager);
                    break;
                case 4:
                    updateExpense(scanner, expenseManager);
                    break;
                case 5:
                    deleteExpense(scanner, expenseManager);
                    break;
                case 6:
                    clearAllExpenses(expenseManager);
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
        System.out.print("Input date (yyyy-mm-dd): ");
        String subject = scanner.nextLine();

        List<Expense> searchResults = expenseManager.searchExpensesByDate(subject);
        if (searchResults.isEmpty()) {
            System.out.println("Expense not found");
        } else {
            System.out.println();
            System.out.println("   Expense Search Result");
            System.out.println("===========================");
            for (Expense expense : searchResults) {
                System.out.printf("%20s | %7.0f | %-20s | %s \n", DATE_FORMAT.format(expense.getTimestamp()),
                        expense.getAmount(), expense.getSubject(), expense.getAdditionalNote());
            }
        }
    }

    private static void readExpenses(Scanner scanner, ExpenseManager expenseManager) {
        System.out.print("Enter the index of the expense you want to read: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        Expense expense = expenseManager.readExpense(index);
        if (expense != null) {
            System.out.println("Expense found:");
            System.out.println(expense.toString());
        } else {
            System.out.println("Expense not found at index " + index);
        }
    }

    private static void updateExpense(Scanner scanner, ExpenseManager expenseManager) {
        System.out.print("Enter the index of the expense you want to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        Expense existingExpense = expenseManager.readExpense(index);

        if (existingExpense != null) {
            System.out.println("Current expense details:");
            System.out.println(existingExpense.toString());
            System.out.println("Enter updated expense details:");

            // Get user input
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Subject: ");
            String subject = scanner.nextLine();

            System.out.print("Additional Note: ");
            String additionalNote = scanner.nextLine();

            // Set timestamp to the current date and time
            Expense updatedExpense = new Expense();
            updatedExpense.setTimestamp(new java.util.Date());
            updatedExpense.setAmount(amount);
            updatedExpense.setSubject(subject);
            updatedExpense.setAdditionalNote(additionalNote);

            expenseManager.updateExpense(index, updatedExpense);
        } else {
            System.out.println("Expense not found at index " + index);
        }
    }

    private static void deleteExpense(Scanner scanner, ExpenseManager expenseManager) {
        System.out.print("Enter the index of the expense you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Expense expenseToDelete = expenseManager.readExpense(index);
        if (expenseToDelete != null) {
            System.out.println("Expense found:");
            System.out.println(expenseToDelete.toString());

            System.out.print("Do you really want to delete this expense? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                expenseManager.deleteExpense(index);
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Deletion process canceled.");

            }

        } else
            System.out.println("Expense not found at index " + index);
    }

    private static void clearAllExpenses(ExpenseManager expenseManager) {
        expenseManager.clearAllExpenses();
    }
}
