import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    public static final int SPEED = 1;
    public static final int MIN_SIZE_PANEL = 0;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int xDir;
    private int yDir;
    private int panelWidth;
    private int panelHeigth;
    private int boxXPosition;
    private int boxYPosition;
    private int boxWeigthPosition;
    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int groundPos, Canvas drawingCanvas,int panelWidth,int panelHeigth,int boxXPosition,int boxYPosition,int boxWeigthPosition)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        xDir = 2;
        yDir = SPEED;
        this.panelWidth= panelWidth;
        this.panelHeigth = panelHeigth;
        this.boxXPosition = boxXPosition;
        this.boxYPosition = boxYPosition;
        this.boxWeigthPosition = boxWeigthPosition;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        yPosition += yDir;
        xPosition +=xDir;

        if(xPosition > panelWidth-diameter || xPosition < MIN_SIZE_PANEL){
            xDir = -xDir;
        }
        if(yPosition > panelHeigth-diameter|| yPosition < MIN_SIZE_PANEL){
            yDir = -yDir;
        }
        if(yPosition >= boxYPosition- diameter && xPosition >= (groundPosition - diameter+49) && xPosition < (boxXPosition+boxWeigthPosition)) {
            xDir = -xDir;
            if(yPosition == boxYPosition- diameter && xPosition > (groundPosition - diameter+49) && xPosition < (boxXPosition+boxWeigthPosition)){
                 yDir = -yDir;
                 xDir = xDir*(-1);
            }
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * return the diameter of this ball
     */
    public int getDiameter(){
        return diameter;
    }
}
