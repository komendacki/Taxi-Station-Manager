package program.engine;

import program.gui.MainFrame;

import javax.swing.*;

/**
 * Created by Admin on 23.03.2016.
 */
public class Main {

    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new MainFrame("Taxi Station Manager");
                frame.setSize(600, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}
