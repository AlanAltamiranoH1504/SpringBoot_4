package com.example.springboot_4_initial.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICloudinaryService {
    public abstract String upload(MultipartFile file) throws IOException;
    public abstract boolean validateMimes(MultipartFile file, String[] mimes);
}
