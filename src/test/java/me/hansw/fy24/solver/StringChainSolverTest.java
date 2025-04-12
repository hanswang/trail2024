package me.hansw.fy24.solver;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringChainSolverTest {

    private final StringChainSolver stringChainSolver = new StringChainSolver();

    private static Stream<Arguments> providerParameters() {
        return Stream.of(
                Arguments.of("ab", "abc"),
                Arguments.of("b", "ab"),
                Arguments.of("b", "ba"),
                Arguments.of("aa", "aac")
        );
    }

    @ParameterizedTest
    @MethodSource("providerParameters")
    public void testIsPredecessor_success(String word_a, String word_b) {
        assertTrue(stringChainSolver.isPredecessor(word_a, word_b));
    }
}
