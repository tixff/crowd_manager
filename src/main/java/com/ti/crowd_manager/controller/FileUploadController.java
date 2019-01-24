package com.ti.crowd_manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author Ti
 * @date 2019/1/25
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping
    public String uploadImage(MultipartFile file) {
        String path = FileUploadController.class.getClass().getResource("/static").getPath();
        String fileName = UUID.randomUUID().toString()+".png";
        try {
            file.transferTo(new File(path, fileName));
            logger.info("上传图片成功");
        } catch (Exception e) {
            logger.error("上传图片失败：{}", e.getStackTrace());
        }
        return fileName;
    }
}
