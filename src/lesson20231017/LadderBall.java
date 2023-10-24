package lesson20231017;

public class LadderBall {

    /*
    На вершине лесенки, содержащей N ступенек, находится мячик, который начинает прыгать по ним вниз, к основанию.
    Мячик может прыгнуть на следующую ступеньку, на ступеньку через одну или через 2.
    (То есть, если мячик лежит на 8-ой ступеньке, то он может переместиться на 5-ую, 6-ую или 7-ую.)
    Определить число всевозможных «маршрутов» мячика с вершины на землю.
     */
    public static void main(String[] args) {
        System.out.println(ladderBall(5));
        System.out.println(ladderBallTabulation(5));
    }

    public static int ladderBall(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        // n = 4: 1 + 2 + 4 = 7
        // n = 5: 2 + 4 + 7 = 13
        return ladderBall(n - 1) + ladderBall(n - 2) + ladderBall(n - 3);
    }

    public static int ladderBallTabulation(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        int cache1 = 1;
        int cache2 = 2;
        int cache3 = 4;
        int result = 4;

        for (int i = 4; i <= n; i++) {
            result = cache1 + cache2 + cache3;
            cache1 = cache2;
            cache2 = cache3;
            cache3 = result;
        }
        return result;
    }

}
