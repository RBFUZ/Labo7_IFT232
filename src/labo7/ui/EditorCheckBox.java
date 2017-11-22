package labo7.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import labo7.commands.Command;
import labo7.commands.EditDocumentCommand;
import labo7.invoker.Invoker;
import labo7.model.EditableDocument;

public class EditorCheckBox extends JCheckBox implements ActionListener, Invoker
{
    private Command command;

    public EditorCheckBox(String label)
    {
        super(label);
        addActionListener(this);
    }

    private static final long serialVersionUID = 1L;

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        command.execute();
    }

    @Override
    public void storeCommand(Command command)
    {
        this.command = command;
    }
}