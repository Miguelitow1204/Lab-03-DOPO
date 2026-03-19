package test;

  
import domain.*;
import domain.Forest;
import domain.Tree;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ForestTest.
 *
 * @author  (Murillo-Rubiano)
 */
public class ForestTest
{
    @Test
    public void testTicTacChangeColor(){
        Forest forest = new Forest();
        Tree beard = new Tree(forest, 10, 10);
        Color colorBefore = beard.getColor();
        forest.ticTac();
        assertNotEquals(colorBefore, beard.getColor());
    }
    
    @Test
    public void testTicTacMultipleTrees(){
        Forest forest = new Forest();
        Tree beard = new Tree(forest, 10, 10);
        Tree soul = new Tree(forest, 15, 15);
        forest.ticTac();
        assertEquals(Color.GREEN, beard.getColor());
        assertEquals(Color.GREEN, soul.getColor());
    }
}
