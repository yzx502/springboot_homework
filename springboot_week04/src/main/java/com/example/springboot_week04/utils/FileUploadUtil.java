package com.example.springboot_week04.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import com.example.springboot_week04.exception.BusinessException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;


@Slf4j
public class FileUploadUtil {
    
    private static final String UPLOAD_DIR = "D:/uploads/";
    
    static {
        try {
            Path path = Paths.get(UPLOAD_DIR);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                log.info("创建上传目录：{}", UPLOAD_DIR);
            } else {
                log.info("上传目录已存在：{}", UPLOAD_DIR);
            }
        } catch (IOException e) {
            log.error("创建上传目录失败：{}", UPLOAD_DIR, e);
            throw new RuntimeException("创建上传目录失败：" + UPLOAD_DIR, e);
        }
    }

    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx",
            ".txt", ".md", ".csv",
            ".zip", ".rar", ".7z",
            ".json", ".xml"
    );

    public static String upload(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new BusinessException(400, "文件不能为空");
        }

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.trim().isEmpty()) {
            throw new BusinessException(400, "文件名不能为空");
        }

        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        log.info("文件原名：{}, 扩展名：{}", originalFilename, suffix);

        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException(400, "不支持的文件类型：" + suffix + "，支持的文件类型：" + ALLOWED_EXTENSIONS);
        }

        String fileName = UUID.randomUUID().toString().replace("-", "") + suffix;
        File destFile = new File(UPLOAD_DIR + fileName);
        
        log.info("开始上传文件：{}, 目标路径：{}", originalFilename, destFile.getAbsolutePath());
        
        try {
            file.transferTo(destFile);
            log.info("文件上传成功：{}", fileName);
            return fileName;
        } catch (IOException e) {
            log.error("文件保存失败：{}", destFile.getAbsolutePath(), e);
            throw e;
        }
    }
    
    public static String getUploadDir() {
        return UPLOAD_DIR;
    }
}