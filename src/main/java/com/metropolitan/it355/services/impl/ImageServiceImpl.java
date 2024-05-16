package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.services.ImageService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    /**
     * Metoda vraca sliku iz foldera da moze da se procita na frontu
     *
     * @param filename
     * @return Resource
     */
    @Override
    public Resource getImage(String filename) throws FileNotFoundException {
        Path path = Paths.get("src/main/resources/images/" + filename);
        Resource resource = new FileSystemResource(path.toFile());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new FileNotFoundException("Image not found");
        }
    }
}
