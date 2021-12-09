package com.cursor.gameobjects;

public abstract class ObjectOnScreen {
    public int x, y;
    public char printableCharacter1;



    public ObjectOnScreen(int x, int y, char d) {
        this.x = x;
        this.y = y;
        this.printableCharacter1 = d;
    }

    public boolean intersectsWith(ObjectOnScreen other) {
        return this.x == other.x && this.y == other.y;
    }
    public boolean intersectsWith(int x, int y) {
        return this.x == x && this.y == y;
    }

}
