package SplitwiseMachineCoding;

import java.util.List;

public interface SplitStrategy {

    List<Double> calculateSplits(double totalAmount, List<Double> shares, int numUsers);

    boolean validate(double totalAmount, List<Double> shares);
}
