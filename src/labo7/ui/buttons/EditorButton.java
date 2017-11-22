package labo7.ui.buttons;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import labo7.commands.Command;
import labo7.invoker.Invoker;
import labo7.model.EditableDocument;

public class EditorButton extends JButton implements ActionListener, Invoker
{
    private static final long serialVersionUID = 1L;
    protected Command command;

    public EditorButton(String label)
    {
        super(label);
        setMaximumSize(new Dimension(120, 20));
        this.addActionListener(this);
    }

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