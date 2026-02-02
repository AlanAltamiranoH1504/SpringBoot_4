package com.example.springboot_4_initial.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {
    public abstract boolean save_image(String path_img, MultipartFile multipartFile) throws IOException;
    public abstract boolean validated_mimes(MultipartFile multipartFile, String[] mimes);
}
