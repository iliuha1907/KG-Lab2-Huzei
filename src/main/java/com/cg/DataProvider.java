package com.cg;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static final String IMAGE_HEIGHT = "height";
    public static final String IMAGE_WIDTH = "width";
    public static final String DEPTH = "depth";
    public static final String DPI_H = "dpiH";
    public static final String DPI_W = "dpiW";
    public static final String ZIP = "zip";
    private static final Map<String, String> PROPERTIES = new HashMap<>();

    static {
        PROPERTIES.put("Image Height", IMAGE_HEIGHT);
        PROPERTIES.put("Y Max", IMAGE_HEIGHT);
        PROPERTIES.put("Image Width", IMAGE_WIDTH);
        PROPERTIES.put("X Max", IMAGE_WIDTH);
        PROPERTIES.put("Bits per Pixel", DEPTH);
        PROPERTIES.put("Bits Per Pixel", DEPTH);
        PROPERTIES.put("Data Precision", DEPTH);
        PROPERTIES.put("Color Planes", DEPTH);
        PROPERTIES.put("Bits Per Sample", DEPTH);
        PROPERTIES.put("Vertical DPI", DPI_H);
        PROPERTIES.put("Pixels Per Unit Y", DPI_H);
        PROPERTIES.put("Y Resolution", DPI_H);
        PROPERTIES.put("Compression", ZIP);
        PROPERTIES.put("Compression Type", ZIP);
        PROPERTIES.put("Horizontal DPI", DPI_W);
        PROPERTIES.put("Pixels Per Unit X", DPI_W);
        PROPERTIES.put("X Resolution", DPI_W);
    }

    public static List<String> findImages(List<File> files) throws ImageProcessingException, IOException {
        List<String> results = new ArrayList<>();
        if(files.size() == 0){
            return results;
        }
        for (File file : files) {
            ImageData data = new ImageData();
            data.setFileName(file.getName());
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    if (PROPERTIES.containsKey(tag.getTagName())) {
                        setField(PROPERTIES.get(tag.getTagName()), tag.getDescription(), data);
                    }
                }
            }
            results.add(data.toString());
        }
        return results;
    }

    public static void setField(String property, String description, ImageData data) {
        switch (property) {
            case IMAGE_HEIGHT:
                data.setHeight(description);
                break;
            case IMAGE_WIDTH:
                data.setWidth(description);
                break;
            case DEPTH:
                data.setDepth(description);
                break;
            case DPI_H:
                data.setDpiH(description);
                break;
            case DPI_W:
                data.setDpiW(description);
                break;
            case ZIP:
                data.setZip(description);
                break;
        }
    }
}
