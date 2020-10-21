package com.bird.samples.controller;

import com.bird.web.file.upload.ServletUploader;
import com.bird.web.file.upload.UploadResult;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liuxx
 * @since 2020/10/21
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private final ServletUploader uploader;

    public FileController(ObjectProvider<ServletUploader> uploader) {
        this.uploader = uploader.getIfAvailable();
    }

    @PostMapping("/upload")
    public UploadResult upload(HttpServletRequest request) throws IOException {
        if (uploader == null) {
            return UploadResult.fail("上传组件未配置");
        }

        return uploader.upload(request);
    }
}
