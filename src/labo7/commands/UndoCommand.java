package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class UndoCommand extends EditDocumentCommand
{

    public UndoCommand(EditableDocument model, EditorTextArea textArea, CommandLog commandLog)
    {
        super(model, textArea, commandLog);
    }

    @Override
    public void execute()
    {
        EditDocumentCommand command = log.retirer();
        
        if (command != null)
            command.undo();
    }

    @Override
    public void undo()
    {
        // Impossible
    }
}