package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

/**
 * Classe abstraite des commandes
 */
public abstract class EditDocumentCommand extends Command implements Cloneable
{
    protected static EditableDocument model;
    protected static EditorTextArea textArea;
    protected static CommandLog log;
    protected String textBefore;
    protected String textAfter;
    protected Integer selectionStart;
    protected Integer selectionEnd;
    protected Integer cursorPosition;

    /**
     * Constructeur de confort
     * 
     * @param model
     * @param textArea
     */
    public EditDocumentCommand(EditableDocument model, EditorTextArea textArea, CommandLog log)
    {
        EditDocumentCommand.model = model;
        EditDocumentCommand.textArea = textArea;
        EditDocumentCommand.log = log;
    }

    /**
     * Code de la commande
     */
    public abstract void execute();

    public abstract void saveState();

    public EditDocumentCommand clone()
    {
        try
        {
            return (EditDocumentCommand) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void undo()
    {
        model.setText(textBefore);
    }

    public void redo()
    {
        model.setText(textAfter);
        textArea.setCaretPosition(cursorPosition);
        textArea.setSelectionStart(selectionStart);
        textArea.setSelectionEnd(selectionEnd);
    }
}