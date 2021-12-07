package com.cursor;

import com.cursor.gameobjects.Food;
import com.cursor.gameobjects.ObjectOnScreen;
import com.cursor.gameobjects.Snake;
import com.cursor.gameobjects.Wall;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameController {
    private Snake snake;
    private List<ObjectOnScreen> gameObjects;
    private GameScreen gameScreen;
    private final Scanner scanner = new Scanner(System.in);

    private void init() {
        snake = new Snake(5, 5);

        gameObjects = new CopyOnWriteArrayList<>();
        gameObjects.add(new Food(1, 2));
        gameObjects.add(new Food(6, 5));
        gameObjects.add(new Food(9, 2));

        gameObjects.add(new Wall(3, 8));
        gameObjects.add(new Wall(8, 3));

        gameScreen = new GameScreen();


    }

    public void startGame() {
        init();
        mainLoop();
    }

    private void mainLoop() {
        while (true) {
            refreshScreen();
            userInput();
            updataGameState();
        }
    }

    private void updataGameState() {
        for (ObjectOnScreen obj : gameObjects) {
            if (snake.intersectsWith(obj)) {
                System.out.println("Collide!");
                snake.collideWith(obj);
                gameObjects.remove(obj);
                generateFood();
            }

        }
    }

    private void generateFood() {
        boolean newFoodGeneration = false;
        int counter = 0;
        while (!newFoodGeneration && counter < 3) {
            counter++;
            int newX = (int) (Math.random() * gameScreen.screenSize);
            int newY = (int) (Math.random() * gameScreen.screenSize);
            boolean intersectionFound = false;
            for (ObjectOnScreen coll : gameObjects) {
                if (coll.intersectsWith(newX, newY) || snake.intersectsWith(newX, newY)) {
                    intersectionFound = true;
                }
            }
            if (!intersectionFound) {
                gameObjects.add(new Food(newX, newY));
                newFoodGeneration = true;
            }

        }
    }

    private void userInput() {
        char input;
        switch (input = scanner.nextLine().charAt(0)) {
            case 'a':
                snake.x = snake.x - 1;
                break;
            case 'd':
                snake.x = snake.x + 1;
                break;
            case 'w':
                snake.y = snake.y - 1;
                break;
            case 's':
                snake.y = snake.y + 1;
                break;


        }
    }

    private void refreshScreen() {
        gameScreen.fillScreenEmptyCell();
        gameScreen.setObjectOnScreen(snake);
        for (ObjectOnScreen drawable : gameObjects) {
            gameScreen.setObjectOnScreen(drawable);
        }
        gameScreen.printScreen();
    }
}


