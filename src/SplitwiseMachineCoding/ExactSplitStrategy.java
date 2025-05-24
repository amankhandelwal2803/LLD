package SplitwiseMachineCoding;

import java.util.List;

public class ExactSplitStrategy implements SplitStrategy {
    @Override
    public List<Double> calculateSplits(double totalAmount, List<Double> shares, int numUsers) {
        return shares;
    }

    @Override
    public boolean validate(double totalAmount, List<Double> shares) {
        double sum = 0;
        for (double val : shares) sum += val;
        return Math.round(sum * 100.0) / 100.0 == Math.round(totalAmount * 100.0) / 100.0;
    }
}
