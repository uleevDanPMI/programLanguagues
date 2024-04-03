import java.math.BigDecimal;

public class Money {
    private long rubles;
    private short kopecks;

    public Money(long rubles, short kopecks) {
        this.rubles = rubles;
        this.kopecks = kopecks;
    }

    public Money addition(Money other) {
        long sumRubles = this.rubles + other.rubles;
        short sumKopecks = (short) (this.kopecks + other.kopecks);
        if (sumKopecks >= 100) {
            sumRubles++;
            sumKopecks -= 100;
        }
        return new Money(sumRubles, sumKopecks);
    }

    public Money difference(Money other) {
        long diffRubles = this.rubles - other.rubles;
        short diffKopecks = (short)(this.kopecks - other.kopecks);
        if (diffKopecks < 0) {
            diffRubles--;
            diffKopecks += 100;
        }
        return new Money(diffRubles, diffKopecks);
    }

    public Money division(int divisor) {
        if (divisor != 0) {
            BigDecimal totalAmount = BigDecimal.valueOf(this.rubles * 100 + this.kopecks);
            BigDecimal divisorDecimal = BigDecimal.valueOf(divisor);
            BigDecimal result = totalAmount.divide(divisorDecimal, 2, BigDecimal.ROUND_HALF_EVEN);

            return new Money(result.longValue() / 100, (short) (result.longValue() % 100));
        } else {
            throw new ArithmeticException("Деление на ноль недопустимо");
        }
    }

    public Money multiply(double multiplier) {
        BigDecimal totalAmount = BigDecimal.valueOf(this.rubles * 100 + this.kopecks);
        BigDecimal multiplierDecimal = BigDecimal.valueOf(multiplier);
        BigDecimal result = totalAmount.multiply(multiplierDecimal).divide(BigDecimal.valueOf(100), 0, BigDecimal.ROUND_HALF_EVEN);

        return new Money(result.longValue() / 100, (short) (result.longValue() % 100));
    }

    public boolean lessThan(Money other) {
        return this.rubles < other.rubles || (this.rubles == other.rubles && this.kopecks < other.kopecks);
    }

    public void printAmount() {
        System.out.printf("%d,%02d руб.\n", rubles, kopecks);
    }
}

