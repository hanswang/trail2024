package me.hansw;

import me.hansw.solver.FinderSolver;

public class FindIsland {

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        FinderSolver finderSolver = new FinderSolver();

        char[][] M = {
                { '1', '1', '0', '0', '0' },
                { '0', '1', '0', '0', '1' },
                { '1', '0', '0', '1', '1' },
                { '0', '0', '0', '0', '0' },
                { '1', '0', '1', '1', '0' }
        };

        System.out.println("Found islands count: " + finderSolver.countIslands(M));
    }
}