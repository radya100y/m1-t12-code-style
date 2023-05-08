import java.util.Scanner;

public class DepositCalculator
{
    double calculateComplexPercentFunction(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);

        return getRoundValue(pay, 2);
    }
    double calculateSimplePercentFunction(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return getRoundValue(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }
    double getRoundValue(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void printMenu() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountWithPercent = 0;
        if (action == 1) {
            amountWithPercent = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            amountWithPercent = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountWithPercent);
    }
    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }
}
