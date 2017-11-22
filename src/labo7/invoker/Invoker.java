package labo7.invoker;

import labo7.commands.Command;

public interface Invoker
{
    /**
     * @param command
     */
    public void storeCommand(Command command);
}