import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private static final String TXT_FILE_PATH = "expenses.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        loadExpensesFromTxt();
    }

    public void createExpense(Expense expense) {
        expenses.add(expense);
        saveExpensesToTxt();
    }

    public List<Expense> searchExpensesByDate(String dateString) {
        // Implement your search logic here
        return null;
    }

    public Expense readExpense(int index) {
        // Implement your read logic here
        return null;
    }

    public void updateExpense(int index, Expense updatedExpense) {
        // Implement your update logic here
    }

    private void saveExpensesToTxt() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TXT_FILE_PATH))) {
            for (Expense expense : expenses) {
                writer.println(
                        DATE_FORMAT.format(expense.getTimestamp()) + " | " +
                                expense.getAmount() + " | " +
                                expense.getSubject() + " | " +
                                expense.getAdditionalNote());
            }

            System.out.println("Write to text file successful.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the text file.");
            e.printStackTrace();
        }
    }

    private void loadExpensesFromTxt() {
        File file = new File(TXT_FILE_PATH);

        if (!file.exists()) {
            // If the file doesn't exist, create a new empty list
            expenses = new ArrayList<>();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(TXT_FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\s*\\|\\s*");

                    Date timestamp = DATE_FORMAT.parse(parts[0].trim());
                    double amount = Double.parseDouble(parts[1].trim());
                    String subject = parts[2].trim();
                    String additionalNote = parts[3].trim();

                    Expense expense = new Expense(timestamp, amount, subject, additionalNote);
                    expenses.add(expense);
                }

            } catch (IOException | ParseException e) {
                System.out.println("An error occurred while loading expenses from the text file.");
                e.printStackTrace();
            }
        }
    }
}
