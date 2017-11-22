package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande de copy
 */
public class CopyCommand extends Command
{
    public CopyCommand(EditableDocument model, EditorTextArea textArea)
    {
        super(model, textArea);
    }

    @Override
    public void execute()
    {
        model.copy(textArea.getSelectionStart(), textArea.getSelectionEnd());
    }
}