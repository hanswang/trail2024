package me.hansw.fy24.solver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FinderSolverTest {

    private final FinderSolver finderSolver = new FinderSolver();

    @Test
    void testCountIslands_success() {
        char[][] M = {
                {'1', '1'},
                {'0', '1'},
        };
        assertEquals(1, finderSolver.countIslands(M), "Failed as expected");
    }

    @Test
    void testBoundingBox_outside() {
        char[][] M = {
                {'1', '1'},
                {'0', '1'},
        };
        assertEquals(false, finderSolver.isPartOfIsland(M, 1, 2));
    }

    @Test
    void testBoundingBox_success() {
        char[][] M = {
                {'1', '1'},
                {'0', '1'},
        };
        assertEquals(true, finderSolver.isPartOfIsland(M, 1, 1));
    }

    @Test
    void testBoundingBox_unvisited() {
        char[][] M = {
                {'1', '1'},
                {'0', '1'},
        };
        assertEquals(false, finderSolver.isPartOfIsland(M, 1, 0));
    }
}