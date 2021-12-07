package com.cursor.gameobjects;

public class Snake extends ObjectOnScreen {
    int currentLength;
    float speed;

    public Snake(int x, int y) {
        super(x, y, '#');
    }

    public void collideWith(ObjectOnScreen collision) {
        if (collision instanceof Wall){
            System.out.println("Game Over!");
            System.exit(0);
        }
        else if (collision instanceof Food){
            System.out.println("Level Up!");
        }

    }

}
