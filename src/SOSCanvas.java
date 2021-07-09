/**
 * Lab04b Instructions found on moodle
 * 
 * Style guidlines URL:-
 * http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 * 
 * 
 * @author Mostafa Higazy
 * @version 09/07/2021
 */

import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;

public class SOSCanvas extends JPanel{

    //Properties
    public static final int edge = 500;
    Graphics gg;
    SOS game;
    double boxNums;
    double FrameEdge;


    //Constructor
    public SOSCanvas(SOS game){
        this.setPreferredSize(new Dimension(edge+1,edge+1));

        this.game = game;
        this.boxNums = game.getDimension();

        this.FrameEdge = edge / (int) boxNums;
        this.setBackground(Color.LIGHT_GRAY);

        repaint();

    }


    /**
     * gets the edge of the frame
     *  @return double
    */
    public double getEdge(){
        
        return FrameEdge;
    }

    /**
     * Paints the cell for the sos game.
     *  @return void
    */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setStroke( new BasicStroke(7.0f));

            g.setFont(new Font("TIMES NEW ROMANS", Font.BOLD, 20));
            g.setColor(Color.BLUE);

            double x = 0;
            double y = 0;

            for(int i = 0; i < (int) boxNums; i++){
                x = 0;

                for(int j = 0; j< (int) boxNums; j++){
                    g2.drawRect((int) x,(int) y, (int) FrameEdge, (int) FrameEdge);
                    x+= (int) FrameEdge;
                }
                y+= FrameEdge;
            }

            x = FrameEdge/2;
            y= FrameEdge/2;

            for(int a = 0; a < (int)boxNums; a++){
                x =FrameEdge/2;
                for (int b =0; b < (int) boxNums; b++){
                    g.drawString(game.getCellContents(a, b) + "", (int) x,(int) y);
                    x+=FrameEdge;
                }
                y+=FrameEdge;
            }
        
    }

    
}
