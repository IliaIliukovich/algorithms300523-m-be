package lesson20231010;

public class HanoiTower {

    /* Имеется три стержня — левый, средний и правый.
    На левом стержне находятся n дисков, диаметры которых различны.
    Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший.
    Требуется перенести диски с левого стержня на правый, используя средний стержень как вспомогательный.

    Головоломка имеет следующие два правила:
      1. Вы не можете поместить больший диск на меньший диск.
      2. За один раз можно перемещать только один диск.
*/

    public static void main(String[] args) {
        hanoi(3);
    }

    public static void hanoi(int n) {
        hanoiRecursive(n, 'A', 'B', 'C');
    }

    /*
    Рекурсионный алгоритм
    1. Переместить «n-1» диск с «start» на «middle», используя end.
    2. Переместить последний диск с «start» на «end».
    3. Переместить «n-1» диск с «middle» на «end», используя start.
     */
    private static void hanoiRecursive(int n, char start, char middle, char end) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + start + " to " + end); // base condition;
            return;
        }
        hanoiRecursive(n - 1, start, end, middle);
        System.out.println("Move disk " + n + " from " + start + " to " + end);
        hanoiRecursive(n - 1, middle, start, end);
    }


}
