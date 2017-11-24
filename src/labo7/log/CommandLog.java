package labo7.log;

import java.util.Stack;

import labo7.commands.Command;
import labo7.commands.EditDocumentCommand;
import labo7.commands.EditTextCommand;
import labo7.commands.UndoCommand;

public class CommandLog
{
    private Stack<EditDocumentCommand> stUndo;
    private Stack<EditDocumentCommand> stRedo;

    public CommandLog()
    {
        stUndo = new Stack<EditDocumentCommand>();
        stRedo = new Stack<EditDocumentCommand>();
    }

    public void ajouterCommande(EditDocumentCommand command)
    {
        /*if (stUndo.isEmpty() && command.equals(EditTextCommand.class))
        {
            System.out.println("Vide et insertion");
            stUndo.push(command);
        }
        
        if (!stUndo.isEmpty())
        {
            System.out.println("La pile n'est pas vide");
            if (!stUndo.peek().equals(command))
            {
                System.out.println("La commande est différente");*/
                stUndo.push(command);
                stRedo.clear();
            /*}
        }
        else
            System.out.println("La pile est vide");*/
    }

    public EditDocumentCommand retirerUndo()
    {
        if (!isEmptyUndo())
        {
            stRedo.add(stUndo.peek().clone());
            return (EditDocumentCommand) stUndo.pop();
        }
        else
            return null;
    }

    public boolean isEmptyUndo()
    {
        return stUndo.isEmpty();
    }

    public EditDocumentCommand retirerRedo()
    {
        if (!stRedo.isEmpty())
        {
            stUndo.add(stRedo.peek().clone());
            return (EditDocumentCommand) stRedo.pop();
        }
        return null;
    }

    public boolean isEmptyRedo()
    {
        return stRedo.isEmpty();
    }
    
    public Command getLastCommand()
    {
        return stUndo.peek();
    }
}