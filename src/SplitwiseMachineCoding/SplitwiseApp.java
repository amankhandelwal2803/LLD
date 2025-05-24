package SplitwiseMachineCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitwiseApp {
    public static void main(String[] args) {
        ExpenseManager expenseManager = ExpenseManager.getInstance();

        expenseManager.addUser(new User("u1", "User1", "user1@email.com", "1111111111"));
        expenseManager.addUser(new User("u2", "User2", "user2@email.com", "2222222222"));
        expenseManager.addUser(new User("u3", "User3", "user3@email.com", "3333333333"));
        expenseManager.addUser(new User("u4", "User4", "user4@email.com", "4444444444"));

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split(" ");
            String command = tokens[0].toUpperCase();
            switch (command) {
                case "SHOW":
                    if (tokens.length == 1) expenseManager.showBalances();
                    else expenseManager.showUserBalance(tokens[1]);
                    break;
                case "EXPENSE":
                    try {
                        String paidBy = tokens[1];
                        double amount = Double.parseDouble(tokens[2]);
                        int noOfUsers = Integer.parseInt(tokens[3]);
                        List<String> participants = new ArrayList<>();
                        int idx = 4;
                        for (int i = 0; i < noOfUsers; i++) participants.add(tokens[idx++]);
                        ExpenseType type = ExpenseType.valueOf(tokens[idx++].toUpperCase());
                        List<Double> values = new ArrayList<>();
                        for (; idx < tokens.length; idx++) values.add(Double.parseDouble(tokens[idx]));
                        expenseManager.addExpense(paidBy, amount, participants, type, values);
                    } catch (Exception e) {
                        System.out.println("Invalid EXPENSE command format");
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
        scanner.close();
    }
}
