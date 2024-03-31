package org.example.exception;

import org.example.model.Cat;

public class DuplicatingNameException extends RuntimeException {

    private final Cat cat;

    public DuplicatingNameException(Cat cat) {
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }
}
