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
        saveState();

        // Sauvegarde du texte
        text = model.getText();

        model.paste(textArea.getSelectionStart());

        // Journalisation
        log.ajouterCommande(this.clone());
    }

    @Override
    public void saveState()
    {
        cursorPosition = textArea.getCaretPosition();
    }

    @Override
    public void redo()
    {
        StringBuilder str = new StringBuilder(text);

        // Remplacement de la chaine selectionnée par une chaine vide
        str.insert(cursorPosition, model.getClipBoard());

        model.setText(str.toString());
    }
}