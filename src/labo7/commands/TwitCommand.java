package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Commande qui coupe le texte a plus de 140 caractères
 */
public class TwitCommand extends EditDocumentCommand
{
    public TwitCommand(EditableDocument model, EditorTextArea textArea, CommandLog commandLog)
    {
        super(model, textArea, commandLog);
    }

    @Override
    public void execute()
    {
        // Sauvegarde du texte
        text = model.getText();
        
        if (model.getText().length() > 140)
        {
            model.setText(model.getText().substring(0, 140));
        }

        // Journalisation
        log.ajouterCommande(this.clone());
    }
  
    @Override
    public void saveState()
    {
    }
    
    @Override
    public void redo()
    {
        model.setText(model.getText().substring(0, 140));
    }
}