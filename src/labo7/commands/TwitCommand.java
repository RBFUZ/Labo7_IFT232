package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande qui coupe le texte a plus de 140 caractères
 */
public class TwitCommand extends EditDocumentCommand
{

    public TwitCommand(EditableDocument model, EditorTextArea textArea)
    {
        super(model, textArea);
    }

    @Override
    public void execute()
    {
        if (model.getText().length() > 140)
        {
            model.setText(model.getText().substring(0, 140));
        }
    }
}