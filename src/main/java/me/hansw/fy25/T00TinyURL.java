package me.hansw.fy25;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T00TinyURL {
    static String randomString(int length, String base) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(base.charAt(random.nextInt(62)));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        UUID random = UUID.randomUUID();
        System.out.println("random.toString().replace(\"-\", \"\") = " + random.toString().replace("-", ""));
        System.out.println("random = " + random.toString());
        System.out.println("random.getLeastSignificantBits() = " + random.getLeastSignificantBits());
        System.out.println("random.getMostSignificantBits() = " + random.getMostSignificantBits());

        String lower = IntStream.range(0, 26).boxed().map(i -> Character.toString('a' + i)).collect(Collectors.joining());
        String upper = IntStream.range(0, 26).boxed().map(i -> Character.toString('A' + i)).collect(Collectors.joining());
        String digits = IntStream.range(0, 10).boxed().map(String::valueOf).collect(Collectors.joining());

        System.out.println("lower = " + lower);
        System.out.println("upper = " + upper);
        System.out.println("digits = " + digits);
        
        String base = lower+upper+digits;
        System.out.println("base = " + base);
        
        String hardcode = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        System.out.println("hardcode = " + hardcode);

        System.out.println("randomString(7) = " + randomString(7, base));

        RandomStringUtils randomStringUtils = new RandomStringUtils();
        System.out.println("randomStringUtils.nextAlphanumeric(10) = " + randomStringUtils.nextAlphanumeric(10));

        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z').filteredBy(Character::isLetterOrDigit).get();

        System.out.println("randomStringGenerator = " + randomStringGenerator);
        System.out.println("randomStringGenerator.generate(10) = " + randomStringGenerator.generate(10));
    }
}
