package me.hansw.fy25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T39CombineSum2 {

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        recursiveCheck(Arrays.stream(candidates).boxed().sorted().toList(), target, 0, new ArrayList<>(), combination);

        return combination;
    }

    static void recursiveCheck(List<Integer> candidates, int target, int index, List<Integer> currentStack, List<List<Integer>> combination) {
        if (target == 0) {
            combination.add(currentStack);
            return;
        }

        if (target < 0 || index >= candidates.size()) {
            return;
        }

        List<Integer> trialStack = new ArrayList<>(currentStack);
        trialStack.add(candidates.get(index));
        recursiveCheck(candidates, target - candidates.get(index), index, trialStack, combination);

        recursiveCheck(candidates, target, index + 1, currentStack, combination);
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
