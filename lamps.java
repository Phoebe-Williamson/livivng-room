import ecs100.*;
import java.awt.Color;
/**
 * driver class for the lamp support class
 *
 * @author (Phoeeb williamosn)
 * @version (20/3/23)
 */
public class lamps
{
    // fiesl
    private static int STARTX = 75;
    private static int YPOS = 100;
    private static int MAXLAMPS = 5;
    
    // male an array of lamps
    private lamp[] livingRoom = new lamp[MAXLAMPS]; // initaialise array
    
    /**
     * Constructor for objects of class lamps
     */
    public lamps()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        // set up the lamps
        for (int i = 0; i < MAXLAMPS; i++) {
            // draw each lamp
            Color col = Color.black;
            livingRoom[i] = new lamp(STARTX*(i+1), YPOS, 20, 50, col);
        }
        
        // draw each lamp
        for (lamp lamp : livingRoom) {
            lamp.draw();
        }
        
        UI.setMouseListener(this::doMouse);
    }

    /**
     * set the object based on where the user clicks
     */
    private void doMouse(String action, double x, double y) {
        if(action.equals("clicked")) {
            // check the lot of x and y again and the lot of theobj
            for (lamp lamp : livingRoom) {
                if (lamp.onBulb(x,y)) {
                    lamp.changeColour();
                    lamp.draw();
                }
            }
        }
    }

}
