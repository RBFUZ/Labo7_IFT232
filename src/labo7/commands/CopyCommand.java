package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande de copy
 */
public class CopyCommand extends EditDocumentCommand
{
    public CopyCommand(EditableDocument model, EditorTextArea textArea, CommandLog commandLog)
    {
        super(model, textArea, commandLog);
    }

    @Override
    public void execute()
    {
        model.copy(textArea.getSelectionStart(), textArea.getSelectionEnd());
    }

    @Override
    public void undo()
    {
        model.setText(text);
    }
}