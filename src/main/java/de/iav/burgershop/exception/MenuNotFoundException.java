package de.iav.burgershop.exception;

import java.util.NoSuchElementException;

public class MenuNotFoundException extends NoSuchElementException {

    public MenuNotFoundException(String id) {
        super("Menu mit der ID " + id + " konnte nicht gefunden werden.");
    }
}
