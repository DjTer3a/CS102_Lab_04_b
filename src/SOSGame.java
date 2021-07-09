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
import cs101.sosgame.SOS;

//testing class
public class SOSGame extends JFrame{
    public static void main(String[] args){
        SOS game = new SOS(7);
        String p1 = "Scorpion";
        String p2 = "Sub Zero";


        
        SOSGUIPanel guiPanel = new SOSGUIPanel(game, p1, p2);
        JFrame frame = new JFrame ("SOS       (...---...) ");



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(guiPanel);



        frame.pack();
        frame.setVisible(true);
    }    
}
