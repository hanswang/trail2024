package me.hansw.solver;

import java.util.*;

public class AnagramSolver {

    private String stringFormatter(String in) {
        char[] chars = in.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars);
    }

    public String[][] group(String[] strs) {

        Map<String, List<String>> dictGroups = new HashMap<>();

        for (String str : strs) {
            String keyStr = stringFormatter(str);
            List<String> existingGroup = dictGroups.get(keyStr);

            if (existingGroup == null) {
                existingGroup = new ArrayList<>();
            }
            existingGroup.add(str);
            dictGroups.put(keyStr, existingGroup);
        }

        String[][] groups = dictGroups.values().stream()
                .map(g -> g.stream().toArray(String[]::new))
                .toArray(String[][]::new);

        return groups;
    }
}
