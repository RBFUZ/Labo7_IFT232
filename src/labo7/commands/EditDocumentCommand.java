package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Classe abstraite des commandes
 */
public abstract class EditDocumentCommand extends Command
{
    protected static EditableDocument model;
    protected static EditorTextArea textArea;

    /**
     * Constructeur de confort
     * 
     * @param model
     * @param textArea
     */
    public EditDocumentCommand(EditableDocument model, EditorTextArea textArea)
    {
        EditDocumentCommand.model = model;
        EditDocumentCommand.textArea = textArea;
    }

    /**
     * Code de la commande
     */
    public abstract void execute();
}