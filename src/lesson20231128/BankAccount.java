package lesson20231128;

import java.util.Objects;

public class BankAccount {

    public String name;

    public int countA;

    public int countB;

    public BankAccount(int countA, int countB, String name) {
        this.countA = countA;
        this.countB = countB;
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || !getClass().equals(o.getClass())) return false;
        BankAccount another = (BankAccount) o;
        return this.countA == another.countA
                && this.countB == another.countB
                && Objects.equals(this.name, another.name);
    }

    @Override
    public int hashCode(){ // 31 = 11111
        return countA * 31 * 31 + countB * 31 + (name == null ? 0 : name.hashCode());
    }


    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(0, 10, "A");
        BankAccount bankAccount2 = new BankAccount(10, 0, "A");
        BankAccount bankAccount3 = new BankAccount(10, 0, "B");

        System.out.println(bankAccount1.hashCode());
        System.out.println(bankAccount2.hashCode());
        System.out.println(bankAccount3.hashCode());

        System.out.println(Objects.hash(10, "", "hello", 99));
        System.out.println(Objects.hash(11, "", "hello", 99));
        System.out.println(Objects.hash(11, "", "hello", 100));
    }

}
