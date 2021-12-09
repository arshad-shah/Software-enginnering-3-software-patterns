package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Command interface.
 * @author Arshad Shah
 */
public interface Command {

	public String execute(
			HttpServletRequest request, HttpServletResponse response);
}