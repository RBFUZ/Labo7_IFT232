package labo7.ui.menu;

import javax.swing.JPopupMenu;
import labo7.commands.CommandFactory;
import labo7.model.EditableDocument;
import labo7.ui.EditorTextArea;

public class EditorMenu extends JPopupMenu
{
    private static final long serialVersionUID = 1L;
    private EditableDocument model;
    private EditorTextArea textArea;

    public EditorMenu(EditableDocument model, EditorTextArea textArea)
    {
        this.model = model;
        this.textArea = textArea;
    }

    public void setup()
    {
        EditorMenuItem itemCopy;
        EditorMenuItem itemPaste;
        EditorMenuItem itemCut;
        EditorMenuItem itemMaj;
        EditorMenuItem itemMin;
        EditorMenuItem itemUndo;
        EditorMenuItem itemRedo;

        if (textArea.getSelectedText() != null)
        {
            itemCopy = new EditorMenuItem("Copy", model);
            itemCopy.storeCommand(CommandFactory.getInstance().createCopyCommand(model, textArea));
            add(itemCopy);

            itemCut = new EditorMenuItem("Cut", model);
            itemCut.storeCommand(CommandFactory.getInstance().createCutCommand(model, textArea));
            add(itemCut);

            itemMaj = new EditorMenuItem("Maj", model);
            itemMaj.storeCommand(CommandFactory.getInstance().createMajCommand(model, textArea));
            add(itemMaj);

            itemMin = new EditorMenuItem("Min", model);
            itemMin.storeCommand(CommandFactory.getInstance().createMinCommand(model, textArea));
            add(itemMin);
        }
        else
        {
            itemPaste = new EditorMenuItem("Paste", model);
            itemPaste.storeCommand(CommandFactory.getInstance().createPasteCommand(model, textArea));
            add(itemPaste);
        }

        if (!CommandFactory.getInstance().getLog().isEmptyUndo())
        {
            itemUndo = new EditorMenuItem("Undo", model);
            itemUndo.storeCommand(CommandFactory.getInstance().createUndoCommand(model, textArea));
            add(itemUndo);
        }

        if (!CommandFactory.getInstance().getLog().isEmptyRedo())
        {
            itemRedo = new EditorMenuItem("Redo", model);
            itemRedo.storeCommand(CommandFactory.getInstance().createRedoCommand(model, textArea));
            add(itemRedo);
        }

    }
}