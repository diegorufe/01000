import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
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
        myCanvas.setVisible(true);
        Random aleatorio = new Random();
        
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int i=0;i<numBalls;i++){
            balls.add(new BouncingBall(aleatorio.nextInt(200),aleatorio.nextInt(500), aleatorio.nextInt(150), new Color(aleatorio.nextInt(256), aleatorio.nextInt(256), aleatorio.nextInt(256)), 400, myCanvas));
            balls.get(i).draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);
            for(int i =0;i<balls.size();i++){// small delay
                balls.get(i).move();
                   if(balls.get(i).getXPosition() >= 550) {
                    finished = true;
                    i = balls.size();
                }
            }
        }
        myCanvas.setVisible(false);
    }
}
