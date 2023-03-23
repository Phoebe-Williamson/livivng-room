import ecs100.*;
import java.awt.Color;
/**
 * creates a lamp
 * it can tirn on and off
 * change colour too when on
 *
 * @author (Phoebe WIlliamosno)
 * @version (20/3/23)
 */
public class lamp {
    /// instance variables - replace the example below with your own
    private double lampX ;       // x position of lamp
    private double lampY;        // y position of lamp
    
    private int bulbSize;        // light bulb size
    private int stemHeight;      // stem of lamp height
    
    private double left;          // left of flower
    private double top;            // top of flower
    private double bottom;         // bottom of flower
    
    private Color color;           // Color of flower 
    
    private boolean lampOff = false;
    private boolean lampOn = false;
    private boolean onStem = false;
    
    
    /**
     * Constructor for objects of class lamp
     */
    public lamp(double x, double y, int size, int stem, Color col) {
        // initialise instance variables
        lampX = x;
        lampY = y;
        bulbSize = size;
        stemHeight = stem;
        color = col;
        
        // set the top, left and bottom
        setTop();
        setLeft();
        setBottom();
    }

    /**
     * getter left
     */
    public double getLeft() {
        return this.left;
    }
    
    /**
     * getter right
     */
    public double getRight() {
        return this.left + this.bulbSize;
    }
    
    /**
     * get top
     */
    public double getTop() {
        return this.top;
    }
    
    /**
     * get bottom
     */
    public double getBottom(){
        return this.bottom;
    }
    
    public void setLeft() {
        this.left = this.lampX - this.bulbSize/2.0;
    }
    
    /**
     * set top
     */
    public void setTop() {
        this.top = this.lampY - this.bulbSize/2.0;
    }
    
    /**
     * set bottom
     */
    public void setBottom() {
        this.bottom = this.lampY + this.stemHeight;
    }
    
    /**
     * draw the lamp on the canvas
     */
    public void draw() {
        final int STEMWIDTH = 2;
        
        // draw stem
        UI.setColor(Color.gray);        // set color of the stem
        UI.setLineWidth(STEMWIDTH);     // set width of the stem
        UI.drawLine(lampX, lampY, lampX, bottom);   // draw in stem
        
        // draw lamp
        UI.setColor(this.color);        // set color of the light
        UI.fillOval(left, top, bulbSize, bulbSize);     // draw the lamp
    }
    
    /**
     * returns the boolean
     * depends on whether the x y pos is on the lamp bulb
     */
    public boolean isOnBulb(double x, double y) {
        if((x >= left) && (x <= left+bulbSize) && (y >= top) && (y <= top+bulbSize)){
            return true;
        } else {
            return false;
        }
    }
    
    /** turn on
     * 
     */
    public void turnOn(){
        if(onStem = true){
            lampOn = true;
            
        }
        
    }
    
    /** turn off
     * 
     */
    public void turnOff(){
        
        
    }
   
    /**
     * returns the boolean
     * depends on whether the x y pos is on the lamp stem
     */
    public boolean onStem(double x, double y) {
        if((x >= lampX) && (x <= lampX+5) && (y >= lampY+bulbSize/2.0) && (y <= bottom)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * returns the boolean
     * depends on whether the x y pos is on the lamp stem
     */
    public boolean onBulb(double x, double y) {
        if((x >= left) && (x <= bulbSize) && (y >= top) && (y <= top + bulbSize)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * switch color
     */
    public void changeColour() {
        this.color = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
    }
    
}
