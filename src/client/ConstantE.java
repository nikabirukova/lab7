package client;

import compute.Task;

public class ConstantE implements Task<Double> {

    private final int calculationAccuracy;

    public ConstantE(int digits) {
        if (digits > 20 || digits < 1) {
            this.calculationAccuracy = 10;
        } else {
            this.calculationAccuracy = digits;
        }
    }

    @Override
    public Double execute() {
        return computeConstantE(calculationAccuracy);
    }

    private Double computeConstantE(int calculationAccuracy) {

        double result = 0;

        for (int i = 0; i < calculationAccuracy; i++) {
            result += 1.0 / factorial(i);
        }

        return result;
    }

    private int factorial(int number) {
        int result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
