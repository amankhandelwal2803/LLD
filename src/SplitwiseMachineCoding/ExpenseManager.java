package SplitwiseMachineCoding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private static ExpenseManager instance;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Map<String, Double>> balances = new HashMap<>();
    private final Map<ExpenseType, SplitStrategy> strategyMap = new HashMap<>();

    private ExpenseManager() {
        strategyMap.put(ExpenseType.EQUAL, new EqualSplitStrategy());
        strategyMap.put(ExpenseType.EXACT, new ExactSplitStrategy());
        strategyMap.put(ExpenseType.PERCENT, new PercentSplitStrategy());
    }

    public static ExpenseManager getInstance() {
        if (instance == null) {
            instance = new ExpenseManager();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        balances.put(user.getUserId(), new HashMap<>());
    }

    public void addExpense(String paidBy, double amount, List<String> participants, ExpenseType type, List<Double> shares) {
        if (!users.containsKey(paidBy)) return;
        SplitStrategy strategy = strategyMap.get(type);
        if (!strategy.validate(amount, shares)) return;
        List<Double> splitAmounts = strategy.calculateSplits(amount, shares, participants.size());
        for (int i = 0; i < participants.size(); i++) {
            String user = participants.get(i);
            if (user.equals(paidBy)) continue;
            double owed = splitAmounts.get(i);
            if (owed <= 0) continue;
            updateBalance(user, paidBy, owed);
        }
    }

    private void updateBalance(String owesUser, String owedUser, double amount) {
        Map<String, Double> owesMap = balances.get(owesUser);
        Map<String, Double> owedMap = balances.get(owedUser);
        double owesAmount = owesMap.getOrDefault(owedUser, 0.0);
        double owedAmount = owedMap.getOrDefault(owesUser, 0.0);
        if (owedAmount > 0) {
            if (owedAmount >= amount) {
                owedMap.put(owesUser, roundTwoDecimals(owedAmount - amount));
                owesMap.put(owedUser, 0.0);
            } else {
                owesMap.put(owedUser, roundTwoDecimals(amount - owedAmount));
                owedMap.put(owesUser, 0.0);
            }
        } else {
            owesMap.put(owedUser, roundTwoDecimals(owesAmount + amount));
        }
    }

    public void showBalances() {
        boolean found = false;
        for (String owesUser : balances.keySet()) {
            Map<String, Double> owesMap = balances.get(owesUser);
            for (Map.Entry<String, Double> entry : owesMap.entrySet()) {
                if (entry.getValue() > 0.009) {
                    System.out.println(formatUser(owesUser) + " owes " + formatUser(entry.getKey()) + ": " + formatAmount(entry.getValue()));
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No balances");
    }

    public void showUserBalance(String userId) {
        if (!users.containsKey(userId)) {
            System.out.println("No balances");
            return;
        }
        boolean found = false;
        Map<String, Double> owesMap = balances.get(userId);
        for (Map.Entry<String, Double> entry : owesMap.entrySet()) {
            if (entry.getValue() > 0.0) {
                System.out.println(formatUser(userId) + " owes " + formatUser(entry.getKey()) + ": " + formatAmount(entry.getValue()));
                found = true;
            }
        }
        for (String otherUser : balances.keySet()) {
            if (otherUser.equals(userId)) continue;
            Map<String, Double> otherOwes = balances.get(otherUser);
            if (otherOwes.getOrDefault(userId, 0.0) > 0.0) {
                System.out.println(formatUser(otherUser) + " owes " + formatUser(userId) + ": " + formatAmount(otherOwes.get(userId)));
                found = true;
            }
        }
        if (!found) System.out.println("No balances");
    }

    private String formatUser(String userId) {
        return users.get(userId).getName();
    }

    private String formatAmount(double amount) {
        amount = roundTwoDecimals(amount);
        if (amount % 1 == 0) {
            return String.valueOf((long) amount);
        }
        return String.format("%.2f", amount);
    }

    private double roundTwoDecimals(double val) {
        return Math.round(val * 100.0) / 100.0;
    }
}
