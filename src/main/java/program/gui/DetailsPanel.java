package program.gui;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.xml.soap.Detail;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 23.03.2016.
 */
public class DetailsPanel extends JPanel {

    private static final long serialVersionUID = 654635463546351531L;

    private EventListenerList eventListenerList = new EventListenerList();

    public DetailsPanel()
    {
        Dimension size = getPreferredSize();
        size.width = 250;
        size.height = 100;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Personal Details"));

        JLabel nameLabel = new JLabel("Name: ");
        JLabel occupationLabel = new JLabel("Occupation: ");

        final JTextField nameField = new JTextField(10);
        final JTextField occupationField = new JTextField(10);

        JButton addBtn = new JButton("Add open call");
        JButton actvBtn = new JButton("Activate call");
        JButton clsBtn = new JButton("Close call");
        JButton cnclBtn = new JButton("Cancel call");

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();

                String text = name + " : " + occupation + "\n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // First column ///

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        //add(nameLabel, gc);
        add(addBtn, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        //add(occupationLabel, gc);
        add(actvBtn, gc);





        //Sercond column

        gc.gridx = 1;
        gc.gridy = 0;
        add(clsBtn, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(cnclBtn, gc);

    }

    public void fireDetailEvent(DetailEvent event)
    {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2)
        {
            if (listeners[i] == DetailListener.class)
            {
                ((DetailListener) listeners[i + 1]).detailEventOccured(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener)
    {
        listenerList.add(DetailListener.class, listener);
    }

    public void removeDetailListener(DetailListener listener)
    {
        listenerList.remove(DetailListener.class, listener);
    }
}
