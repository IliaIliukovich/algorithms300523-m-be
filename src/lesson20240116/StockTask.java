package lesson20240116;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StockTask {

// Task: Максимальное количество акций
// На фондовом рынке есть продукт с его бесконечными запасами.
//Цены акций даны за N дней, где dayPrices[i] обозначает цену акции в i -й день.
//Существует правило, согласно которому клиент может купить не более i акций в i -й день.
//Если у клиента первоначально есть k сумма денег, узнайте максимальное количество акций, которое клиент может купить.
//
//Например, на 3 дня цена акции равна 7, 10, 4.
//Вы можете купить 1 акцию по 7$ в первый день, 2 акции по 10$ каждая во второй день
//и 3 акции по 4$ каждая в третий день.

    public static void main(String[] args) {
        int[] dayPrices = {20 , 15, 10 , 8, 20};
        int[] possibleAmount = {1, 2, 3, 4, 5};
        int k = 50;

        int max = findMaxCount(dayPrices, possibleAmount, k);
        System.out.println("Max number of stocks possible to buy: " + max);
    }

    public static int findMaxCount(int[] dayPrices, int[] possibleAmount, int k) {
        List<Stock> stockList = new ArrayList<>();
        for (int i = 0; i < dayPrices.length; i++) {
          stockList.add(new Stock(dayPrices[i], possibleAmount[i]));
        }

        stockList.sort(Comparator.comparingInt(o -> o.price));

        int leftAmount = k;
        int maxCount = 0;
        for (Stock stock : stockList) {
            if (leftAmount >= stock.price * stock.amount) {
                leftAmount = leftAmount - stock.price * stock.amount;
                maxCount += stock.amount;
            } else {
                int count = leftAmount / stock.price;
                leftAmount = leftAmount - stock.price * count;
                System.out.println("Money left: " + leftAmount);
                maxCount += count;
                break;
            }
        }
        return maxCount;
    }

    static class Stock {
        int price;
        int amount;

        public Stock(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "price=" + price +
                    ", amount=" + amount +
                    '}';
        }
    }

}
