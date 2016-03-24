package program.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 23.03.2016.
 */
public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;

    public MainFrame(String title)
    {
        super(title);

        //Set layout manager
        setLayout(new BorderLayout());

        //Create swing component
        final JTextArea textArea = new JTextArea();
        JButton button = new JButton("Click me!");

        detailsPanel = new DetailsPanel();

        //Add swing components to content pane
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.WEST);

        //Add behaviour
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello\n");
            }
        });
    }
}
