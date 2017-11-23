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
        saveState();

        // Sauvegarde du texte avant la modification
        textBefore = model.getText();

        model.cut(textArea.getSelectionStart(), textArea.getSelectionEnd());
        
        // Sauvegarde du texte avant la modification
        textAfter = model.getText();

        // Journalisation
        log.ajouterCommande(this.clone());
    }

    @Override
    public void saveState()
    {
        selectionStart = textArea.getSelectionStart();
        selectionEnd = textArea.getSelectionEnd();

        cursorPosition = textArea.getCaretPosition();
    }
}
