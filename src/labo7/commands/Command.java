package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Classe abstraite des commandes
 */
public abstract class Command
{
    protected static EditableDocument model;
    protected static EditorTextArea textArea;

    /**
     * Constructeur de confort
     * 
     * @param model
     * @param textArea
     */
    public Command(EditableDocument model, EditorTextArea textArea)
    {
        Command.model = model;
        Command.textArea = textArea;
    }

    /**
     * Code de la commande
     */
    public abstract void execute();
}