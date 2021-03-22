package com.cg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWalker {

    private static final List<String> EXTENSIONS = new ArrayList<>(Arrays.asList(".jpg", ".bmp", ".png", ".tif", ".gif", ".pcx"));

    public static List<File> findFiles(File directory) throws IOException {
        return Files.walk(directory.toPath())
                .filter(Files::isRegularFile)
                .filter(element -> EXTENSIONS.stream().anyMatch(element.toString().toLowerCase()::endsWith))
                .map(Path::toFile)
                .collect(Collectors.toList());
    }
}
