package program.engine;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import program.gui.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.*;

/**
 * Created by Admin on 23.03.2016.
 */
public class Main {

    public static void main(String[] args)
    {

        DBWorker worker = new DBWorker();

//            if (!worker.connection.isClosed())
//            {
//                System.out.println("Connected");
//            }

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JFrame frame = new MainFrame("Taxi Station Manager");
                    frame.setSize(800, 800);

                    String[][] data = {{"01", "Alex", "18", "18", null, null, null, null, null}, {"02", "Brandon", "20", "20", null, null, null, null, null}, {"03", "Cassie", "18", "18", null, null, null, null, null}, {"04", "Steve", "25", "25", null, null, null, null, null}};
                    String[] column = {"ID", "Client", "Phone", "From", "To", "Time", "Driver", "Vehicle",  "Status"};

                    // Create JTable
                    JTable jt = new JTable(data, column);
                    JScrollPane sp = new JScrollPane(jt);

                    frame.add(sp);
                    frame.pack();


                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);


                }
            });
    }
}
