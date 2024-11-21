package me.hansw;

import me.hansw.solver.AnagramSolver;
import me.hansw.solver.MergerSolver;

import java.util.Arrays;

public class GroupAnagram {

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        AnagramSolver anagramSolver = new AnagramSolver();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Groups: " + Arrays.deepToString(anagramSolver.group(strs)));
    }
}
