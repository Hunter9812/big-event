package com.example.controller;

import com.example.entity.RestBean;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
@Tag(name = "文件上传", description = "只包括文件上传。")
public class FileUpLoadController {
    private final String separator = File.separator;

    @PostMapping
    public RestBean<String> upload(MultipartFile file) throws IOException {
        String originalFilename = Optional.ofNullable(file.getOriginalFilename()).orElse("xxx");
        String filename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String filePath = System.getProperty("user.home") + separator + "files" + separator;
        String pathname = filePath + filename;
        file.transferTo(new File(pathname));
        return RestBean.success(pathname);
    }
}
