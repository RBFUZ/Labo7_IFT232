package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande coller
 */
public class PasteCommand extends EditDocumentCommand
{

    public PasteCommand(EditableDocument model, EditorTextArea textArea, CommandLog commandLog)
    {
        super(model, textArea, commandLog);
    }

    @Override
    public void execute()
    {
        // Sauvegarde du texte
        text = model.getText();
        
        model.paste(textArea.getSelectionStart());

        // Journalisation
        log.ajouter(this.clone());
    }

    @Override
    public void undo()
    {
        model.setText(text);
    }
}