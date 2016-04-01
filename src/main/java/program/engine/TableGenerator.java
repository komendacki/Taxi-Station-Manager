package program.engine;

import program.model.Call;

import java.util.ArrayList;

/**
 * Created by Admin on 01.04.2016.
 */
public class TableGenerator {

    DBWorker worker = new DBWorker();
    DBEncapsulator dbEncapsulator = new DBEncapsulator();

    public String[][] getTable()
    {
        ArrayList<Call> calls = dbEncapsulator.getCallsList();
        String[][] array = new String[calls.size()][];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = getArray(calls.get(i));
        }

        return array;
    }

    private String[] getArray(Call call)
    {
        String[] array = new String[10];
        array[0] = call.getId() + "";
        array[1] = call.getClient();
        array[2] = call.getPhone();
        array[3] = call.getFrom();
        if (call.getTo() != null) array[4] = call.getTo();
        else array[4] = null;
        array[5] = call.getTime();
        if(call.getDriver() != null) array[6] = call.getDriver().toString();
        else array[6] = null;
        if(call.getVehicle() != null) array[7] = call.getVehicle().toString();
        else array[7] = null;
        if(call.getTariff() != null) array[8] = call.getTariff().toString();
        else array[8] = null;
        array[9] = call.getStatus().toString();

        return array;
    }
}
