package labo7.log;

import java.util.Stack;

import labo7.commands.EditDocumentCommand;

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
        stUndo.push(command);
        stRedo.clear();
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
}