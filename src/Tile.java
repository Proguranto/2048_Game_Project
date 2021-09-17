/**
 * contains properties of each tile
 */
import java.awt.*;

public class Tile {

    private int value;

    private Color tileColor;

    /**
     * creates number
     */
    public Tile() {
        value = 0;
        this.setColor();
    }

    /**
     * creates tile and sets value to the number
     * @param number
     */
    public Tile(int number) {
        value = number;
        this.setColor();
    }

    // return tile's value
    public int getValue() {
        return value;
    }

    // sets the tiles value
    public void setValue(int value) {
        this.value = value;
        this.setColor();
    }

    public String toString() {
        return "" + value;
    }
    
    // sets the tile color
    public void setColor() {
        if (this.getValue() == 2) {
            tileColor = new Color(238, 228, 218);
        } else if (this.getValue() == 4) {
            tileColor = new Color(237, 224, 200);
        } else if (this.getValue() == 8) {
            tileColor = new Color(242, 177, 121);
        } else if (this.getValue() == 16) {
            tileColor = new Color(246, 149, 99);
        } else if (this.getValue() == 32) {
            tileColor = new Color(246, 124, 95);
        } else if (this.getValue() == 64) {
            tileColor = new Color(244, 96, 66);
        } else if (this.getValue() == 128) {
            tileColor = new Color(237, 207, 150);
        } else if (this.getValue() == 256) {
            tileColor = new Color(237, 204, 110);
        } else if (this.getValue() == 512) {
            tileColor = new Color(237, 200, 80);
        } else if (this.getValue() == 1024) {
            tileColor = new Color(237, 197, 50);
        } else if (this.getValue() == 2048) {
            tileColor = new Color(237, 194, 5);
        } else {
            tileColor = new Color(205, 193, 180);
        }
    }

    public Color getColor() {
        return tileColor;
    }
}
