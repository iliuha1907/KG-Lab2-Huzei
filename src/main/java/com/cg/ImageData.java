package com.cg;

import java.util.Objects;

public class ImageData {

    private String fileName = "";
    private String height = "";
    private String width = "";
    private String dpiH = "";
    private String dpiW = "";
    private String zip = "-";
    private String depth = "";

    public ImageData(String fileName, String height, String width, String dpiH, String dpiW, String zip, String depth) {
        this.fileName = fileName;
        this.height = height;
        this.width = width;
        this.dpiH = dpiH;
        this.dpiW = dpiW;
        this.zip = zip;
        this.depth = depth;
    }

    public ImageData() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDpiH() {
        return dpiH;
    }

    public void setDpiH(String dpiH) {
        this.dpiH = dpiH;
    }

    public String getDpiW() {
        return dpiW;
    }

    public void setDpiW(String dpiW) {
        this.dpiW = dpiW;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageData imageData = (ImageData) o;
        return Objects.equals(fileName, imageData.fileName) &&
                Objects.equals(height, imageData.height) &&
                Objects.equals(width, imageData.width) &&
                Objects.equals(dpiH, imageData.dpiH) &&
                Objects.equals(dpiW, imageData.dpiW) &&
                Objects.equals(zip, imageData.zip) &&
                Objects.equals(depth, imageData.depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, height, width, dpiH, dpiW, zip, depth);
    }

    @Override
    public String toString() {
        return "ImageData{" +
                "fileName='" + fileName + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", dpiH='" + dpiH + '\'' +
                ", dpiW='" + dpiW + '\'' +
                ", zip='" + zip + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
