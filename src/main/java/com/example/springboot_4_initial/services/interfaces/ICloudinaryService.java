package com.example.springboot_4_initial.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {
    public abstract Map upload(MultipartFile file) throws IOException;
    public abstract Map uploadFile(MultipartFile file) throws IOException;
    public abstract boolean delete_image(String public_id_img) throws IOException;
    public abstract boolean validateMimes(MultipartFile file, String[] mimes);
}
