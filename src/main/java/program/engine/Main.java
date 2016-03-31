package program.engine;

import program.gui.MainFrame;
import program.model.Call;
import program.model.Status;
import program.model.Tariff;
import program.model.Vehicle;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Admin on 23.03.2016.
 */
public class Main {

    public static void main(String[] args)
    {

        DBWorker worker = new DBWorker();

        try
        {
            Statement statement = worker.getConnection().createStatement();
            DBEncapsulator dbEncapsulator = new DBEncapsulator();
            ArrayList<Call> calls = dbEncapsulator.getCallsList();

            for (Call c : calls)
            {
                System.out.println(c);
            }



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
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}
