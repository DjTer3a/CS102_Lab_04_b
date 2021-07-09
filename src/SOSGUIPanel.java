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
import java.awt.event.*;

public class SOSGUIPanel extends JPanel{

    //Properties
    SOSCanvas canvas;
    JPanel panel;
    JLabel p1;
    JLabel p2;
    String[] SO = new String[] {"S", "O"};
    JComboBox<String> comboBox = new JComboBox<>(SO);
    SOS game;
    String p1_name;
    String p2_name;
    Boolean bool;
    String endGame;

    //Constructor
    public SOSGUIPanel(SOS game, String p1_name, String p2_name){
        this.game = game;
        this.p1_name = p1_name;
        this.p2_name = p2_name;
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,100));
        setBackground(Color.CYAN);
        panel.setBackground(Color.CYAN);


        //setting p1 and p2
        p1 = new JLabel(p1_name +" scored : "+ game.getPlayerScore1());
        p2 = new JLabel(p2_name +" scored : "+ game.getPlayerScore2());
        p1.setOpaque(true);
        p2.setOpaque(true);
        p1.setBackground(Color.RED);
        p2.setBackground(Color.CYAN);
        p1.setForeground(Color.BLUE);
        p2.setForeground(Color.BLUE);
        p1.setFont(new Font("TIMES NEW ROMANS", Font.BOLD, 20));
        p2.setFont(new Font("TIMES NEW ROMANS", Font.BOLD, 20));
        

        //adding p1 and p2 and combo box to the panel
        panel.add(p1);
        panel.add(p2);
        panel.add(comboBox);


        //adding action listeners and layout changes
        canvas = new SOSCanvas(game);
        canvas.addMouseListener(new CanvasListener());
        comboBox.addActionListener(new comboBoxListener());
        canvas.setBackground(Color.CYAN);
        add(canvas, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(800,800));
    }


    /**
     * Canvas listener to check for mouse clicks in the program
     *  @category class
    */
    private class CanvasListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){

            //properties 
            Point point = e.getPoint();
            double x = point.getX();
            double y = point.getY(); // 5 hours wasted because of getX() :'(
            double edge = canvas.getEdge();
            int rows = ((int) y / (int) edge) +1;
            int cols = ((int) x / (int) edge) +1;


            //comditionals to get and set checkbox values
            if(bool){
                game.play('s',rows,cols);
                p1.setText(p1_name + " scored :" + game.getPlayerScore1());
                p2.setText(p2_name + " scored :" + game.getPlayerScore2());
                
            }
            else{
                game.play('o',rows,cols);
                p1.setText(p1_name + " scored :" + game.getPlayerScore1());
                p2.setText(p2_name + " scored :" + game.getPlayerScore2());
                
            }


            //managing player turns
            int turn = game.getTurn();
            if (turn == 1){
                p1.setBackground(Color.RED);
                p2.setBackground(Color.CYAN);
            }
            else if(turn == 2){
                p2.setBackground(Color.RED);
                p1.setBackground(Color.CYAN);
            }
            repaint();


            //checking if game is over
            if(game.isGameOver()){
                String endGame ="";
                if(game.getPlayerScore1() > game.getPlayerScore2()){
                    endGame = p1_name +" finsihed you ";
                }
                else if(game.getPlayerScore2() > game.getPlayerScore1()){
                    endGame = p2_name +" finsihed you ";
                }
                else{
                    endGame = "It is a draw, you have met your match ";
                }

                int end =JOptionPane.showConfirmDialog(canvas, endGame, "Game over, Try again soon ", JOptionPane.DEFAULT_OPTION );
                if(end == 0){
                    System.exit(0);
                }
            }
        }
    }
    
    
    /**
     * Combo box listener for selected choice clicks in the program
     *  @category class
    */
    public class comboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            String selected = (String) comboBox.getSelectedItem();
     
            if (selected.equals("S")) {
                bool = true;
                
            } else if (selected.equals("O")) {
                bool = false;
            }
        }
    }
}
 