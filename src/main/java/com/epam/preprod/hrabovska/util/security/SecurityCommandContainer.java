package com.epam.preprod.hrabovska.util.security;

import com.epam.preprod.hrabovska.util.security.securitycommand.ErrorCommand;
import com.epam.preprod.hrabovska.util.security.securitycommand.RedirectCommand;
import com.epam.preprod.hrabovska.util.security.securitycommand.SuccessCommand;

import java.util.HashMap;
import java.util.Map;

public class SecurityCommandContainer {

    public final static String OK = "ok";
    public final static String REDIRECT = "redirect";
    public final static String ERROR = "error";
    private Map<String, SecurityCommand> actions;

    public SecurityCommandContainer() {
        actions = new HashMap<>();
        actions.put(OK, new SuccessCommand());
        actions.put(REDIRECT, new RedirectCommand());
        actions.put(ERROR, new ErrorCommand());
    }

    public SecurityCommand getCommand(String command) {
        return actions.get(command);
    }
}
