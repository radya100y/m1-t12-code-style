import java.util.Scanner;

public class DepositCalculator {

    static final double RATE = 0.06;
    static final int MONTHS_AMOUNT = 12;
    static final int CALCULATE_SIMPLE_PERCENT = 1;
    static final int CALCULATE_COMPLEX_PERCENT = 2;

    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + RATE / MONTHS_AMOUNT), MONTHS_AMOUNT * depositPeriod);
        return calculate(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return calculate(amount + amount * RATE * depositPeriod);
    }

    double calculate(double value) {
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void calculateContribution() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();

        double result = 0;
        if (action == CALCULATE_SIMPLE_PERCENT) {
            result = calculateSimplePercent(amount, period);
        } else if (action == CALCULATE_COMPLEX_PERCENT) {
            result = calculateComplexPercent(amount, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
}
