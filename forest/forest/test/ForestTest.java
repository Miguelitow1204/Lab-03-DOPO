package test;

  
import domain.*;
import domain.Forest;
import domain.Tree;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;
import domain.Squirrel;
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
}
