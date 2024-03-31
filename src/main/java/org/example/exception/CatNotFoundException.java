package org.example.exception;

public class CatNotFoundException extends RuntimeException {

    private final String catName;

    public CatNotFoundException(String catName) {
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }
}
