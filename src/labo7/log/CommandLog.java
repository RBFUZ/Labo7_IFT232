package labo7.log;

import java.util.Stack;

import labo7.commands.EditDocumentCommand;

public class CommandLog
{
    private Stack<EditDocumentCommand> st;

    public CommandLog()
    {
        st = new Stack<EditDocumentCommand>();
    }

    public void ajouter(EditDocumentCommand command)
    {
        st.push(command);
    }

    public EditDocumentCommand retirer()
    {
        if (!isEmpty())
        {
            return (EditDocumentCommand) st.pop();
        }
        else
            return null;

    }

    public EditDocumentCommand voir()
    {
        return (EditDocumentCommand) st.peek();
    }

    public boolean isEmpty()
    {
        return st.isEmpty();
    }
}