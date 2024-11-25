package me.hansw;


import java.util.*;
import java.util.stream.Collectors;

public class LongestString {

    static boolean isPredecessor(String word_a, String word_b) {
        if (word_a.length() != word_b.length() - 1) {
            return false;
        }
        for (int i = 0; i < word_b.length(); i++) {
            String subWordB = word_b.substring(0, i) + word_b.substring(i+1);
            if (word_a.equals(subWordB)) {
                return true;
            }
        }

        return false;
    }

    static int stringChain(String[] words) {
        Map<String, Integer> chainCount = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            chainCount.put(word, 1);
        }

        int maxChainLength = 1;
        for (String word : words) {
            List<String> wordCandidates = Arrays.stream(words).filter(w -> w.length() == word.length() + 1).collect(Collectors.toList());
            for (String wc : wordCandidates) {
                if (isPredecessor(word, wc)) {
                    chainCount.put(wc, Math.max(chainCount.get(word) +1, chainCount.get(wc)));
                }
            }

            if (maxChainLength < chainCount.get(word)) {
                maxChainLength = chainCount.get(word);
            }
        }

        return maxChainLength;
    }

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};

        System.out.println("Result: " + stringChain(words));
    }
}
