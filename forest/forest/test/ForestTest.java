package test;
import domain.*;
import domain.Forest;
import domain.Tree;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;
import domain.Squirrel;
import domain.Shadow;
import domain.CherryTree;
/**
 * The test class ForestTest.
 *
 * @author  (Murillo-Rubiano)
 */
public class ForestTest
{
    //Pruebas método ticTac() de Forest
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
    
    //Pruebas Squirrel
    @Test
    public void testSquirrelInitialColor(){
        Forest forest = new Forest();
        Squirrel alvin = new Squirrel(forest, 5, 5);
        //deberia crear una nueva squirrel de 0 años, café
        assertEquals(new Color(139, 69, 19), alvin.getColor());
    }
    
    @Test
    public void testSquirrelDiesAfter10Years(){
        Forest forest = new Forest();
        Squirrel alvin = new Squirrel(forest, 5, 5);
        //deberia morir despues de 10ticTac
        for(int i = 0; i < 10; i++){
            forest.ticTac();
        }
        assertNull(forest.getThing(5, 5));
    }
    
    //Pruebas Shadow
    @Test
    public void testShadowColor(){
        Forest forest = new Forest();
        Shadow shadowTest = new Shadow(forest, 5, 5);
        assertEquals(Color.BLACK, shadowTest.getColor());
    }
    
    @Test
    public void thestShadowMovesToNorth(){
        Forest forest = new Forest();
        Shadow shadowTest = new Shadow(forest, 5, 5);
        forest.ticTac();
        assertNotNull(forest.getThing(4, 5));
        assertNull(forest.getThing(5,5));
    }
    
    //Ciclo 4 pruebas cherryTree
    @Test
    public void testCherryTreeInitialColor(){
        Forest forest = new Forest();
        CherryTree cherry = new CherryTree(forest, 5, 5);
        assertEquals(Color.GREEN, cherry.getColor());
    }
    
    @Test
    public void testCherryTreeBlooms(){
        Forest forest = new Forest();
        CherryTree cherry = new CherryTree(forest, 3, 3);
        //After 4 tic-tacs it should bloom to pink
        for(int i = 0; i < 4; i++){
            forest.ticTac();
        }
        assertEquals(new Color(205, 105, 180), cherry.getColor());
    }
    
    @Test
    public void testCherryTreeReturnsToGreen(){
        Forest forest = new Forest();
        CherryTree cherry = new CherryTree(forest, 3, 3);
        for(int i = 0; i < 8; i++){
            forest.ticTac();
        }
        assertEquals(Color.GREEN, cherry.getColor());
    }
}
