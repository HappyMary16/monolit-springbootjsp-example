package org.example.service;

import org.example.exception.CatNotFoundException;
import org.example.exception.DuplicatingNameException;
import org.example.model.Cat;
import org.example.model.CatBehaviour;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatService {

    private final Map<String, Cat> cats = new HashMap<>();

    public CatService() {
        cats.put("Tom", new Cat("Tom", CatBehaviour.CALM));
        cats.put("Oscar", new Cat("Oscar", CatBehaviour.NORMAL));
    }


    public Collection<Cat> getAllCats() {
        return cats.values();
    }

    public Cat getCat(String catName) {
        if (cats.containsKey(catName)) {
            return cats.get(catName);
        }

        throw new CatNotFoundException(catName);
    }

    public Cat addCat(Cat cat) {
        if (cats.containsKey(cat.getName())) {
            throw new DuplicatingNameException(cat);
        }

        cats.put(cat.getName(), cat);
        return cat;
    }
}
