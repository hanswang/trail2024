package me.hansw.fy25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class T39CombineSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        recursiveCheck(Arrays.stream(candidates).boxed().sorted().toList(), target, new ArrayList<>(), combination);

        return combination.stream().collect(Collectors.toMap(
                i -> i.stream().sorted().toList(),
                i -> 1,
                (a, b) -> a + b
        )).keySet().stream().toList();
    }

    static void recursiveCheck(List<Integer> candidates, int target, List<Integer> currentStack, List<List<Integer>> combination) {
        if (target == 0) {
            combination.add(currentStack);
        }

        List<Integer> availableCandidates = candidates.stream().filter(c -> c <= target).toList();

        if (availableCandidates.isEmpty() || target < 0) {
            return;
        }

        candidates.forEach(c -> {
            List<Integer> trialStack = new ArrayList<>(currentStack);
            trialStack.add(c);
            recursiveCheck(candidates, target - c, trialStack, combination);
        });
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println("combinationSum(candidates, target) = " + combinationSum(candidates, target));

        int[] candidates1 = {2,3,5};
        int target1 = 8;
        System.out.println("combinationSum(candidates1, target1) = " + combinationSum(candidates1, target1));
    }
}
