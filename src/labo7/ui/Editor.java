package labo7.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import labo7.commands.CommandFactory;
import labo7.commands.CopyCommand;
import labo7.commands.CutCommand;
import labo7.commands.EditTextCommand;
import labo7.commands.MajCommand;
import labo7.commands.MinCommand;
import labo7.commands.PasteCommand;
import labo7.commands.RedoCommand;
import labo7.commands.ToggleInsertCommand;
import labo7.commands.TwitCommand;
import labo7.commands.UndoCommand;
import labo7.log.CommandLog;
import labo7.model.EditableDocument;
import labo7.ui.buttons.EditorButton;
import labo7.ui.shortcuts.KeyboardShortcut;
import labo7.ui.shortcuts.ShortcutManager;

@SuppressWarnings("serial")
public class Editor extends JFrame
{

    private EditableDocument model;

    private ShortcutManager shortcuts;

    private EditorLabel charCount;
    private EditorCheckBox insert;
    private EditorTextArea textBox;
    private EditorButton copyButton;
    private EditorButton cutButton;
    private EditorButton pasteButton;
    private EditorButton minButton;
    private EditorButton twitButton;
    private EditorButton majButton;

    private EditorButton redo;
    private EditorButton undo;

    private CopyCommand copyCommand;
    private CutCommand cutCommand;
    private MajCommand majCommand;
    private MinCommand minCommand;
    private PasteCommand pasteCommand;
    private TwitCommand twitCommand;
    private UndoCommand undoCommand;
    private RedoCommand redoCommand;
    private EditTextCommand editTextCommand;

    private ToggleInsertCommand toggleInsert;

    public Editor(EditableDocument doc)
    {

        setModel(doc);
        setSize(800, 600);
        setTitle("TwitEdit");

        Font font = new Font("Arial", Font.BOLD, 20);
        JPanel background = new JPanel();
        background.setLayout(new BoxLayout(background, BoxLayout.X_AXIS));

        // Bo�te de texte
        textBox = new EditorTextArea(500, 400, model);
        textBox.setFont(font);
        textBox.setLineWrap(true);
        textBox.setWrapStyleWord(true);

        // Gestionnaire de clavier pour les raccourcis
        shortcuts = new ShortcutManager();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(shortcuts);

        /*
         * Initialisation du panneau contenant les boutons
         */
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setMaximumSize(new Dimension(130, 600));

        copyButton = new EditorButton("Copier");
        cutButton = new EditorButton("Couper");
        pasteButton = new EditorButton("Coller");
        majButton = new EditorButton("MAJUSCULES");
        minButton = new EditorButton("minuscules");
        twitButton = new EditorButton("Twitterize");

        buttonsPanel.add(Box.createVerticalGlue());
        buttonsPanel.add(copyButton);
        buttonsPanel.add(cutButton);
        buttonsPanel.add(pasteButton);
        buttonsPanel.add(majButton);
        buttonsPanel.add(minButton);
        buttonsPanel.add(twitButton);
        buttonsPanel.add(Box.createVerticalGlue());

        background.add(buttonsPanel);
        background.add(Box.createHorizontalGlue());

        /*
         * Initialisation du panneau contenant la bo�te de texte et les autres
         * contr�les
         */
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        // Compteur de caract�res
        charCount = new EditorLabel();
        charCount.setModel(model);
        charCount.setFont(font);
        textPanel.add(charCount);
        textPanel.add(textBox);

        // Panneau avec undo, redo et insere
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

        undo = new EditorButton("undo");
        redo = new EditorButton("redo");

        insert = new EditorCheckBox("Insertion");
        insert.setSelected(true);
        controlPanel.add(undo);
        controlPanel.add(redo);
        controlPanel.add(insert);

        textPanel.add(controlPanel);
        background.add(textPanel);

        // Ajout du panneau principal dans le frame
        add(background);

        // Pr�parations finales
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Iniialisation des commandes
     * 
     * @param commandLog
     */
    public void initCommands()
    {
        // Initalisation des commandes
        copyCommand = CommandFactory.getInstance().createCopyCommand(model, textBox);
        cutCommand = CommandFactory.getInstance().createCutCommand(model, textBox);
        majCommand = CommandFactory.getInstance().createMajCommand(model, textBox);
        minCommand = CommandFactory.getInstance().createMinCommand(model, textBox);
        pasteCommand = CommandFactory.getInstance().createPasteCommand(model, textBox);
        twitCommand = CommandFactory.getInstance().createTwitCommand(model, textBox);
        undoCommand = CommandFactory.getInstance().createUndoCommand(model, textBox);
        redoCommand = CommandFactory.getInstance().createRedoCommand(model, textBox);
        editTextCommand = CommandFactory.getInstance().createEditTextCommand(model, textBox);

        // Liaison entre les boutons et les commandes
        copyButton.storeCommand(copyCommand);
        cutButton.storeCommand(cutCommand);
        majButton.storeCommand(majCommand);
        minButton.storeCommand(minCommand);
        pasteButton.storeCommand(pasteCommand);
        twitButton.storeCommand(twitCommand);
        undo.storeCommand(undoCommand);
        redo.storeCommand(redoCommand);
        textBox.storeCommand(editTextCommand);

        // Création des raccourcis
        KeyboardShortcut keybordshortcutCopy = new KeyboardShortcut(KeyEvent.VK_C, true);
        keybordshortcutCopy.storeCommand(copyCommand);

        KeyboardShortcut keybordshortcutPaste = new KeyboardShortcut(KeyEvent.VK_V, true);
        keybordshortcutPaste.storeCommand(pasteCommand);

        KeyboardShortcut keybordshortcutCut = new KeyboardShortcut(KeyEvent.VK_X, true);
        keybordshortcutCut.storeCommand(cutCommand);

        KeyboardShortcut keybordshortcutUndo = new KeyboardShortcut(KeyEvent.VK_Z, true);
        keybordshortcutUndo.storeCommand(undoCommand);

        KeyboardShortcut keybordshortcutRedo = new KeyboardShortcut(KeyEvent.VK_Y, true);
        // A FAIRE keybordshortcutRedo.storeCommand(command);

        // Ajout des raccourcis à la liste
        shortcuts.addShortcut(keybordshortcutCopy);
        shortcuts.addShortcut(keybordshortcutPaste);
        shortcuts.addShortcut(keybordshortcutCut);
        shortcuts.addShortcut(keybordshortcutUndo);
        shortcuts.addShortcut(keybordshortcutRedo);
        shortcuts.addShortcut(keybordshortcutUndo);

        toggleInsert = CommandFactory.getInstance().createToggleInsertCommand(model, insert);
        insert.storeCommand(toggleInsert);

    }

    public void setModel(EditableDocument doc)
    {
        model = doc;
    }
}