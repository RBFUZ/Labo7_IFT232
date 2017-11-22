package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande couper
 */
public class CutCommand extends EditDocumentCommand
{
    public CutCommand(EditableDocument model, EditorTextArea textArea, CommandLog commandLog)
    {
        super(model, textArea, commandLog);
    }

    @Override
    public void execute()
    {
        // Sauvegarde du texte
        text = model.getText();
        
        model.cut(textArea.getSelectionStart(), textArea.getSelectionEnd());

        // Journalisation
        log.ajouter(this.clone());
    }

    @Override
    public void undo()
    {
        model.setText(text);
    }
}
