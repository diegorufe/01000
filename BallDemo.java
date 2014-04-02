import java.awt.Color;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     * @param numBalls is the number of bolas.
     */
    public void bounce(int numBalls)
    {
        int ground = 400;   // position of the ground line
        ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>();// ArrayList de bolas 

        //Creacion de color al alzar 
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B= (int)(Math.random()*256);
        Color color = new Color(R, G, B);

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int i=0;i<numBalls;i++){
            balls.add(new BouncingBall(50, 50, 16, color, ground, myCanvas));
            balls.get(i).draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);
            for(int i =0;i<balls.size();i++){// small delay
                balls.get(i).move();
            }
            // stop once ball has travelled a certain distance on x axis
            for(int i=0;i<balls.size();i++){
                if(balls.get(i).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
