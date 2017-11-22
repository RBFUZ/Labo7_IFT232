package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande minuscule
 */
public class MinCommand extends Command
{

    public MinCommand(EditableDocument model, EditorTextArea textArea)
    {
        super(model, textArea);
    }

    @Override
    public void execute()
    {
        model.minimize(textArea.getSelectionStart(), textArea.getSelectionEnd());
    }
}