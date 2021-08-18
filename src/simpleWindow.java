import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.util.Random;

import javax.swing.*;

public class simpleWindow 
{
    private JFrame f;
    private JButton b;
    private JButton bPlus;
    private JButton partyButton;
    boolean cycleColor = false;
    Color[] colors = {Color.red, Color.green, Color.blue, Color.cyan, Color.gray, Color.orange, Color.yellow, Color.pink, Color.black, Color.white};
        
    simpleWindow(int frameWidth, int frameHeight)
    {   
        //Toolkit to grab screen dimensions
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dim = t.getScreenSize();

        //vars
        int centerFrameWidth = (dim.width - frameWidth)/2;
        int centerFrameHeight = (dim.height - frameHeight)/2;

        //Frame Operations
            //Frame/Window that our things reside in
            f = new JFrame();//creating instance of JFrame
            f.setSize(frameWidth, frameHeight);//400 width and 500 height
            f.setLocation(centerFrameWidth, centerFrameHeight);
       
            //Button Operations
                //Button that will change the background into different colors when clicked
                b = new JButton("Change Background");//creating instance of JButton
                int buttonWidth = 150;
                int buttonHeight = 50;    
                b.setBounds((frameWidth - buttonWidth)/2, (frameHeight - buttonHeight)/3, buttonWidth, buttonHeight);//x axis, y axis, width, height

                //Creates an action listener for us
                simpleListener ourListener = new simpleListener();
                b.addActionListener(ourListener);

                //Reset the background button
                bPlus = new JButton("Reset");
                bPlus.addActionListener(ourListener);
                bPlus.setBounds(50, 50, 110, 40);
                bPlus.setVisible(false);


                //Party button for Rick Astley
                partyButton = new JButton("Party Button");
                partyButton.addActionListener(ourListener);
                partyButton.setBounds(frameWidth - 200, frameHeight - 100, buttonWidth, buttonHeight);


            //Adding our toys onto the screen
            f.add(partyButton);
            f.add(bPlus);
            f.add(b);
            
            f.setLayout(null);//using no layout managers  
            f.setVisible(true);//making the frame visible
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Our internal class for our actionListener
    private class simpleListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == partyButton)
            {
                try
                {
                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                    desktop.browse(oURL);
                }
                catch(Exception error)
                {
                    error.printStackTrace();
                }
            }
            if(e.getSource() == b)
            {
                Random randomGen = new Random();
                bPlus.setVisible(true);
                f.getContentPane().setBackground(colors[ randomGen.nextInt(9)]);
            }
            if(e.getSource() == bPlus)
            {
                bPlus.setVisible(false);
                f.getContentPane().setBackground(Color.white);
            }
        }
    }
}

//Our super secret message
//https://www.youtube.com/watch?v=dQw4w9WgXcQ