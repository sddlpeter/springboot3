package com.powernode.uploadfile.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadAction {

    @PostMapping("/files")
    public String upload(HttpServletRequest request) {
        try {
            for (Part part : request.getParts()){
                String filename = extractFileName(part);
                part.write(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/index.html";
    }

    private String extractFileName(Part part) {
        String contentDis = part.getHeader("content-disposition");
        String[] items = contentDis.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
