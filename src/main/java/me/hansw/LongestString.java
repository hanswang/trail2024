package me.hansw;


import me.hansw.solver.StringChainSolver;


public class LongestString {


    public static void main(String[] args) {

        System.out.println("Initialising ...");

        StringChainSolver stringChainSolver = new StringChainSolver();

        String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};

        System.out.println("Result: " + stringChainSolver.stringChain(words));
    }
}
