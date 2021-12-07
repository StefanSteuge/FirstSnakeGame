package com.cursor.gameobjects;

public abstract class ObjectOnScreen {
    public int x, y;
    public char printableCharacter;

    public ObjectOnScreen(int x, int y, char printableCharacter) {
        this.x = x;
        this.y = y;
        this.printableCharacter = printableCharacter;
    }

    public boolean intersectsWith(ObjectOnScreen other) {
        return this.x == other.x && this.y == other.y;
    }
    public boolean intersectsWith(int x, int y) {
        return this.x == x && this.y == y;
    }

}
