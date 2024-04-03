public class Main
{
    public static void main(String[] args) {
        Money money1 = new Money(100, (short) 50);
        Money money2 = new Money(50, (short) 30);

        Money sum = money1.addition(money2);
        sum.printAmount();

        Money difference = money1.difference(money2);
        difference.printAmount();

        Money division = money1.division(3);
        division.printAmount();

        Money product = money1.multiply(3.5);
        product.printAmount();

        boolean isLess = money1.lessThan(money2);
        System.out.println("Is money1 less than money2? " + isLess);
    }
}
