package me.hansw.fy25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + ":" + this.y;
    }
}

class SnakeGame {
    List<List<Integer>> board;

    int height;
    int width;

    int[][] chain;
    int consumeIndex;

    List<Position> snake;

    public SnakeGame(int w, int h, int[][] food) {
        this.height = h;
        this.width = w;

        this.board = IntStream.range(0, this.width).boxed().map(
                i -> IntStream.generate(() -> 0).limit(this.height).boxed().collect(Collectors.toCollection(ArrayList::new))
        ).collect(Collectors.toList());

        this.chain = food;
        this.consumeIndex = 0;

        this.board.get(food[this.consumeIndex][0]).set(food[this.consumeIndex][1], 1);

        this.snake = new ArrayList<>();
        this.snake.add(new Position(0, 0));
    }

    public int move(String direction) throws Exception {
        // validation direction
        String[] validDirections = {"U", "D", "L", "R"};
        if (!Arrays.asList(validDirections).contains(direction)) {
            throw new Exception("Invalid Direction" + direction);
        }
        Position head = this.snake.getFirst();
        Position newHead;
        switch (direction) {
            case "U":
                newHead = new Position(head.x, head.y-1);
                break;
            case "D":
                newHead = new Position(head.x, head.y+1);
                break;
            case "L":
                newHead = new Position(head.x-1, head.y);
                break;
            case "R":
                newHead = new Position(head.x+1, head.y);
                break;
            default:
                return -1;
        }

        // check border
        if (newHead.x < 0 || newHead.x >= this.width || newHead.y < 0 || newHead.y >= this.height) {
            return -1;
        }

        // check food
        if (this.board.get(newHead.x).get(newHead.y) != 1) {
            this.snake.removeLast();
        } else {
            // clearing the old food board
            int[] currentFood = this.chain[this.consumeIndex];
            this.board.get(currentFood[0]).set(currentFood[1], 0);

            // presenting next food if any
            this.consumeIndex += 1;
            if (this.chain.length > this.consumeIndex) {
                int[] food = this.chain[this.consumeIndex];
                this.board.get(food[0]).set(food[1], 1);
            }
        }
        this.snake.addFirst(newHead);

        return this.snake.size() - 1;
    }
}


public class T353Snake {
    public static void main(String[] args) throws Exception {
        int[][] food = {{2, 1}, {1, 0}};
        SnakeGame snakeGame = new SnakeGame(3, 2, food);

        System.out.println("snakeGame.move(\"R\") = " + snakeGame.move("R"));
        System.out.println("snakeGame.move(\"D\") = " + snakeGame.move("D"));
        System.out.println("snakeGame.move(\"R\") = " + snakeGame.move("R"));
        System.out.println("snakeGame.move(\"U\") = " + snakeGame.move("U"));
        System.out.println("snakeGame.move(\"L\") = " + snakeGame.move("L"));
        System.out.println("snakeGame.move(\"U\") = " + snakeGame.move("U"));

    }
}
