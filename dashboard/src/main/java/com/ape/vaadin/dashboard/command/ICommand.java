package com.ape.vaadin.dashboard.command;

/**
 * The command interface
 */
public interface ICommand {
	/**
	 * @return true if the command was successfully executed
	 */
	public abstract boolean execute();
}