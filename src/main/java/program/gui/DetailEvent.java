package program.gui;

import java.util.EventObject;

/**
 * Created by Admin on 29.03.2016.
 */
public class DetailEvent extends EventObject{

    private String text;

    public DetailEvent(Object source, String text)
    {
        super(source);

        this.text = text;

    }

    public String getText()
    {
        return this.text;
    }
}
