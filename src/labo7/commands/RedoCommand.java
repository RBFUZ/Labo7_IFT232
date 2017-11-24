package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class RedoCommand extends EditDocumentCommand
{

    public RedoCommand(EditableDocument model, EditorTextArea textArea, CommandLog log)
    {
        super(model, textArea, log);
    }

    @Override
    public void execute()
    {
        EditDocumentCommand command = log.retirerRedo();

        if (command != null)
            command.redo();
    }

    @Override
    public void undo()
    {
        // Impossible
    }

    @Override
    public void redo()
    {
        // Impossible
    }

    @Override
    public void saveState()
    {
    }
}
