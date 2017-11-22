package labo7.ui.shortcuts;

import java.awt.event.KeyEvent;

import labo7.commands.Command;
import labo7.invoker.Invoker;

/*
 * Classe d�finissant un raccourci clavier. Pr�voit une m�thode � �tre appel�e
 * lorsque le raccourci est d�clench�.
 */

public class KeyboardShortcut implements Invoker
{

    private boolean control;
    private int keyCode;
    private Command command;

    public KeyboardShortcut(int code, boolean ctrl)
    {
        control = ctrl;
        keyCode = code;
    }

    public boolean match(KeyEvent evt)
    {
        if (evt.getID() == KeyEvent.KEY_PRESSED)
        {
            if (evt.getKeyCode() == keyCode && evt.isControlDown() == control)
            {
                return true;
            }
        }
        return false;
    }

    public void activateShortcut()
    {
        command.execute();
    }

    @Override
    public void storeCommand(Command command)
    {
        this.command = command;
    }
}