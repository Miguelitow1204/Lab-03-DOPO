package domain;

import java.util.*;

/*No olviden adicionar la documentacion*/
public class Forest {
    static private int SIZE = 25;
    private Thing[][] places;

    public Forest() {
        places = new Thing[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                places[r][c] = null;
            }
        }
        someThings();
    }

    public int getSize() {
        return SIZE;
    }

    public Thing getThing(int r, int c) {
        return places[r][c];
    }

    public void setThing(int r, int c, Thing e) {
        places[r][c] = e;
    }

    public void someThings() {
        Tree beard = new Tree(this, 10, 10);
        Tree soul = new Tree(this, 15, 15);
        Squirrel scrat = new Squirrel(this, 11, 13);
        Squirrel sandy = new Squirrel(this, 13, 13);
        Shadow thief = new Shadow(this, 12, 10);
        Shadow lass = new Shadow(this, 17, 15);
        CherryTree murillo = new CherryTree(this, 3, 3);
        CherryTree rubiano = new CherryTree(this, 3, 6);
        GlowSpore murillo2 = new GlowSpore(this, 10, 2);
        GlowSpore rubiano2 = new GlowSpore(this, 5, 10);
    }

    public int neighborsEquals(int r, int c) {
        int num = 0;
        if (inForest(r, c) && places[r][c] != null) {
            for (int dr = -1; dr < 2; dr++) {
                for (int dc = -1; dc < 2; dc++) {
                    if ((dr != 0 || dc != 0) && inForest(r + dr, c + dc) &&
                            (places[r + dr][c + dc] != null)
                            && (places[r][c].getClass() == places[r + dr][c + dc].getClass()))
                        num++;
                }
            }
        }
        return num;
    }

    public boolean isEmpty(int r, int c) {
        return (inForest(r, c) && places[r][c] == null);
    }

    private boolean inForest(int r, int c) {
        return ((0 <= r) && (r < SIZE) && (0 <= c) && (c < SIZE));
    }

    /**
     * Executes one simulation step in the forest
     * Iterates over all cells, calling ticTac() on each non-null element found.
     */
    public void ticTac() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (places[r][c] instanceof Squirrel) {
                    ((Squirrel) places[r][c]).acted = false;
                }
            }
        }
        Thing[][] copy = new Thing[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                copy[r][c] = places[r][c];
            }
        }
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (places[r][c] != null) {
                    places[r][c].ticTac();
                }
            }
        }

    }

}
