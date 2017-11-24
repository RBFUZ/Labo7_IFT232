package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class EditTextCommand extends EditDocumentCommand
{
    public EditTextCommand(EditableDocument model, EditorTextArea textArea, CommandLog log)
    {
        super(model, textArea, log);
    }

    @Override
    public void execute()
    {   
        //System.out.println("NEW");
        // Sauvegarde du texte avant la modification
        //System.out.println(model.getText());
        text = model.getText();
        
        // Journalisation
        log.ajouterCommande(this.clone());
    }

    @Override
    public void saveState()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void redo()
    {
        // TODO Auto-generated method stub
    }
}