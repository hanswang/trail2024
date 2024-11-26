package me.hansw;

public class LemonadeChangeGreedy {
    static boolean change(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill: bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        int[] bills = {5,5,5,10,20};

        System.out.println("Result: " + change(bills));
    }
}
