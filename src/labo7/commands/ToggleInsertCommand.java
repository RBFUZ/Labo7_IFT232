package labo7.commands;

import labo7.model.EditableDocument;
import labo7.ui.EditorCheckBox;

public class ToggleInsertCommand extends Command
{
    EditableDocument model;
    EditorCheckBox checkBox;

    public ToggleInsertCommand(EditableDocument model, EditorCheckBox checkBox)
    {
        this.model = model;
        this.checkBox = checkBox;
    }

    @Override
    public void execute()
    {
        if (checkBox.isSelected())
        {
            System.out.println("IsSelected");
            model.enableInsert();
        }
        else
        {
            System.out.println("Is not Selected");
            model.disableInsert();
        }
    }
}