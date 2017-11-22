package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande maj
 */
public class MajCommand extends EditDocumentCommand
{

    public MajCommand(EditableDocument model, EditorTextArea textArea)
    {
        super(model, textArea);
    }

    @Override
    public void execute()
    {
        model.capitalize(textArea.getSelectionStart(), textArea.getSelectionEnd());
    }
}