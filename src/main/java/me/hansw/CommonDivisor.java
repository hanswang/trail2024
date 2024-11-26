package me.hansw;

public class CommonDivisor {
    static boolean isDivisible(String divisor, String candidate) {
        if (divisor.length() >= candidate.length()) {
            return divisor.equals(candidate);
        }

        return divisor.equals(candidate.substring(0, divisor.length())) && isDivisible(divisor, candidate.substring(divisor.length()));
    }

    static String gcd(String str1, String str2) {
        String commonDivisor = "";

        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() >= str2.length() ? str1 : str2;

        for (int i = 0; i < shorter.length(); i++) {
            String pref = shorter.substring(0, i+1);
            if (isDivisible(pref, shorter) && isDivisible(pref, longer)) {
                if (commonDivisor.length() < pref.length()) {
                    commonDivisor = pref;
                }
            }
        }
        
        return commonDivisor;
    }

    public static void main(String[] args) {
        System.out.println("Initialising ...");

        String str1 = "EFGABC";
        String str2 = "ABC";

        System.out.println("Result: " + gcd(str1, str2));
    }
}
