package test;

import domain.*;

import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ForestTest.
 *
 * @author (Murillo-Rubiano)
 */
public class ForestTest {
    // Pruebas método ticTac() de Forest
    @Test
    public void testTicTacChangeColor() {
        Forest forest = new Forest();
        Tree beard = new Tree(forest, 10, 10);
        Color colorBefore = beard.getColor();
        forest.ticTac();
        assertNotEquals(colorBefore, beard.getColor());
    }

    @Test
    public void testTicTacMultipleTrees() {
        Forest forest = new Forest();
        Tree beard = new Tree(forest, 10, 10);
        Tree soul = new Tree(forest, 15, 15);
        forest.ticTac();
        assertEquals(Color.GREEN, beard.getColor());
        assertEquals(Color.GREEN, soul.getColor());
    }

    // Pruebas Squirrel
    @Test
    public void testSquirrelInitialColor() {
        Forest forest = new Forest();
        Squirrel alvin = new Squirrel(forest, 5, 5);
        // deberia crear una nueva squirrel de 0 años, café
        assertEquals(new Color(139, 69, 19), alvin.getColor());
    }

    @Test
    public void testSquirrelDiesAfter10Years() {
        Forest forest = new Forest();
        Squirrel alvin = new Squirrel(forest, 5, 5);
        // deberia morir despues de 10ticTac
        for (int i = 0; i < 10; i++) {
            forest.ticTac();
        }
        assertNull(forest.getThing(5, 5));
    }

    // Pruebas Shadow
    @Test
    public void testShadowColor() {
        Forest forest = new Forest();
        Shadow shadowTest = new Shadow(forest, 5, 5);
        assertEquals(Color.BLACK, shadowTest.getColor());
    }

    @Test
    public void thestShadowMovesToNorth() {
        Forest forest = new Forest();
        Shadow shadowTest = new Shadow(forest, 5, 5);
        forest.ticTac();
        assertNotNull(forest.getThing(4, 5));
        assertNull(forest.getThing(5, 5));
    }

    // Ciclo 4 pruebas cherryTree
    @Test
    public void testCherryTreeInitialColor() {
        Forest forest = new Forest();
        CherryTree cherry = new CherryTree(forest, 5, 5);
        assertEquals(Color.GREEN, cherry.getColor());
    }

    @Test
    public void testCherryTreeBlooms() {
        Forest forest = new Forest();
        CherryTree cherry = new CherryTree(forest, 3, 3);
        // After 4 tic-tacs it should bloom to pink
        for (int i = 0; i < 4; i++) {
            forest.ticTac();
        }
        assertEquals(new Color(205, 105, 180), cherry.getColor());
    }

    @Test
    public void testCherryTreeReturnsToGreen() {
        Forest forest = new Forest();
        CherryTree cherry = new CherryTree(forest, 3, 3);
        for (int i = 0; i < 8; i++) {
            forest.ticTac();
        }
        assertEquals(Color.GREEN, cherry.getColor());
    }

    // Pruebas GlowSpore - Ciclo 5

    @Test
    public void testGlowSporeInitialColor() {
        Forest forest = new Forest();
        GlowSpore murillo2 = new GlowSpore(forest, 7, 7);
        // Debe iniciar en fase morada oscura (purplePhase = true)
        assertEquals(new Color(148, 0, 211), murillo2.getColor());
    }

    @Test
    public void testGlowSporeDiesAfter5TicTacs() {
        Forest forest = new Forest();
        GlowSpore rubiano2 = new GlowSpore(forest, 7, 7);
        for (int i = 0; i < 5; i++) {
            forest.ticTac();
        }
        // Después de 5 tic-tacs debe haber muerto
        assertNull(forest.getThing(7, 7));
    }

    @Test
    public void testGlowSporeSpread() {
        // Intencion: verificar que después de 3 tic-tacs la GlowSpore
        // dispersa una espora y existe al menos una nueva en el bosque
        Forest forest = new Forest();
        GlowSpore murillo2 = new GlowSpore(forest, 7, 7);
        for (int i = 0; i < 3; i++) {
            forest.ticTac();
        }
        int count = 0;
        for (int r = 0; r < forest.getSize(); r++) {
            for (int c = 0; c < forest.getSize(); c++) {
                if (forest.getThing(r, c) instanceof GlowSpore) {
                    count++;
                }
            }
        }
        // Debe haber al menos 2 GlowSpores: la original + 1 espora
        assertTrue(count >= 2);
    }
}
