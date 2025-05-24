package SplitwiseMachineCoding;

import java.util.ArrayList;
import java.util.List;

public class PercentSplitStrategy implements SplitStrategy {
    @Override
    public List<Double> calculateSplits(double totalAmount, List<Double> shares, int numUsers) {
        List<Double> splits = new ArrayList<>();
        for (double percent : shares) {
            splits.add(Math.round((percent * totalAmount / 100.0) * 100.0) / 100.0);
        }
        return splits;
    }

    @Override
    public boolean validate(double totalAmount, List<Double> shares) {
        double sum = 0;
        for (double val : shares) sum += val;
        return Math.round(sum * 100.0) / 100.0 == 100.0;
    }
}