package SplitwiseMachineCoding;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public List<Double> calculateSplits(double totalAmount, List<Double> shares, int numUsers) {
        List<Double> splits = new ArrayList<>();
        double baseShare = Math.floor((totalAmount / numUsers) * 100) / 100.0;
        double total = baseShare * numUsers;
        double remainder = Math.round((totalAmount - total) * 100.0) / 100.0;
        for (int i = 0; i < numUsers; i++) {
            splits.add(i == 0 ? baseShare + remainder : baseShare);
        }
        return splits;
    }

    @Override
    public boolean validate(double totalAmount, List<Double> shares) {
        return true;
    }
}
