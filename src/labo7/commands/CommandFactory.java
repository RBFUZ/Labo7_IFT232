package labo7.commands;

import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.EditorCheckBox;
import labo7.ui.EditorTextArea;

public class CommandFactory
{
    private static CommandFactory INSTANCE = null;
    private CommandLog log = new CommandLog();

    public static synchronized CommandFactory getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new CommandFactory();

        return INSTANCE;
    }

    public CopyCommand createCopyCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new CopyCommand(model, textArea, log);
    }

    public PasteCommand createPasteCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new PasteCommand(model, textArea, log);
    }

    public CutCommand createCutCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new CutCommand(model, textArea, log);
    }

    public MajCommand createMajCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new MajCommand(model, textArea, log);
    }

    public MinCommand createMinCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new MinCommand(model, textArea, log);
    }

    public TwitCommand createTwitCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new TwitCommand(model, textArea, log);
    }

    public UndoCommand createUndoCommand(EditableDocument model, EditorTextArea textArea)
    {
        return new UndoCommand(model, textArea, log);
    }

    public ToggleInsertCommand createToggleInsertCommand(EditableDocument model, EditorCheckBox insert)
    {
        return new ToggleInsertCommand(model, insert);
    }
}