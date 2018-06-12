package com.epam.preprod.hrabovska.util.handler;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class ImageHandler {

    private static final Logger LOG = Logger.getLogger(ImageHandler.class);

    private String uploadPath;

    public ImageHandler(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String loadImage(HttpServletRequest request, String name) {
        String savePath = uploadPath;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        String fileName = null;
        try {
            for (Part part : request.getParts()) {
                String extension = extractFileExtension(part);
                if (!extension.isEmpty()) {
                    fileName = name.substring(name.lastIndexOf(".")) + extension;
                    part.write(savePath + File.separator + fileName);
                }
            }
        } catch (IOException | ServletException e) {
            LOG.error("File upload error " + e.getMessage());
        }

        return fileName;
    }

    private String extractFileExtension(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (!s.isEmpty() && s.trim().startsWith("filename")) {
                return (s.substring(s.lastIndexOf("."), s.length() - 1)).toLowerCase();
            }
        }
        return "";
    }

    public void removeImage(String name) {
        if (!name.isEmpty())
            new File(name).delete();
    }

}
