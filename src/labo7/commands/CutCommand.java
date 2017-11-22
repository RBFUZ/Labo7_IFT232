package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande couper
 */
public class CutCommand extends EditDocumentCommand
{
    public CutCommand(EditableDocument model, EditorTextArea textArea)
    {
        super(model, textArea);
    }

    @Override
    public void execute()
    {
        model.cut(textArea.getSelectionStart(), textArea.getSelectionEnd());
    }
}
