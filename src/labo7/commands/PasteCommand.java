package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande coller
 */
public class PasteCommand extends EditDocumentCommand
{

    public PasteCommand(EditableDocument model, EditorTextArea textArea)
    {
        super(model, textArea);
    }

    @Override
    public void execute()
    {
        model.paste(textArea.getSelectionStart());
    }
}