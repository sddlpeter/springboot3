package com.powernode.uploadfile.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadMultiFilesController {

    // 上传文件控制器方法
    @PostMapping("uploadFiles")
    public String uploadFile(@RequestParam("upFile") MultipartFile[] multipartFiles) {
        System.out.println("开始处理上传文件...");
        Map<String, Object> info = new HashMap<>();

        try {
            for (MultipartFile multipartFile : multipartFiles) {
                if (!multipartFile.isEmpty()) {
                    info.put("上传文件名称", multipartFile.getName());
                    info.put("内容类型", multipartFile.getContentType());

                    var ext = "unknown";
                    var filename = multipartFile.getOriginalFilename();
                    if (filename.indexOf(".") > 0) {
                        ext = filename.substring(filename.indexOf(".") + 1);
                    }

                    var newFileName = UUID.randomUUID().toString() + "." + ext;
                    var path = "c://source//upload//" + newFileName;

                    // 保存文件到目录
                    multipartFile.transferTo(new File(path));

                    System.out.println("info=" + info);

                    info.put("文件名称", newFileName);

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        // 重定向index页面
        return "redirect:/index.html";
    }
}