package easy;

public class E2706BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {
        int price1 = Integer.MAX_VALUE, price2 = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < price1) {
                price2 = price1;
                price1 = price;
            } else if (price < price2) {
                price2 = price;
            }
        }
        int sum = price1 + price2;
        return sum > money ? money : money - sum;
    }
}
