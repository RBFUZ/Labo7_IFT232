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
        text = model.getText();

        model.cut(textArea.getSelectionStart(), textArea.getSelectionEnd());

        // Journalisation
        log.ajouterCommande(this.clone());
    }

    @Override
    public void saveState()
    {
        textSelected = textArea.getSelectedText();
        cursorPosition = textArea.getCaretPosition();
    }

    @Override
    public void redo()
    {
        StringBuilder str = new StringBuilder(text);

        // Remplacement de la chaine selectionnée par une chaine vide
        str.replace(cursorPosition - textSelected.length(), cursorPosition, "");

        model.setText(str.toString());
    }
}