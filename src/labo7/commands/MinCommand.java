package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande minuscule
 */
public class MinCommand extends EditDocumentCommand
{

    public MinCommand(EditableDocument model, EditorTextArea textArea, CommandLog commandLog)
    {
        super(model, textArea, commandLog);
    }

    @Override
    public void execute()
    {
        saveState();
        
        // Sauvegarde du texte
        textBefore = model.getText();
        
        model.minimize(textArea.getSelectionStart(), textArea.getSelectionEnd());
        
        // Sauvegarde du texte avant la modification
        textAfter = model.getText();

        // Journalisation
        log.ajouterCommande(this.clone());
    }
    
    @Override
    public void saveState()
    {
        textSelected = textArea.getSelectedText();
        cursorPosition = textArea.getCaretPosition();
    }
}