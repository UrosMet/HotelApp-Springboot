package com.metropolitan.it355.services;

import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;

public interface ImageService {
    /**
     * Metoda vraca sliku iz foldera da moze da se procita na frontu
     * @param filename
     * @return Resource
     */
    Resource getImage(String filename) throws FileNotFoundException;
}
