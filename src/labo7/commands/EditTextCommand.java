package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Ecriture direct dans le text area
 */
public class EditTextCommand extends EditDocumentCommand
{
    private char caractereInserer; 
    
    /**
     * Constructeur de confort
     * 
     * @param model
     * @param textArea
     * @param log
     */
    public EditTextCommand(EditableDocument model, EditorTextArea textArea, CommandLog log)
    {
        super(model, textArea, log);
    }

    @Override
    public void execute()
    {
        StringBuilder str = new StringBuilder(model.getText());

        // Sauvegarde la position du pointeur
        saveState();
        
        // Garde en mémoire le caractère ajouté pour le redo
        caractereInserer = str.charAt(cursorPosition);

        // Sauvegarde du texte avant la modification
        text = str.deleteCharAt(cursorPosition).toString();

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
        str.insert(cursorPosition, String.valueOf(caractereInserer));

        model.setText(str.toString());
    }
}