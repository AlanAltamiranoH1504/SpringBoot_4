package com.example.springboot_4_initial.controllers;

import com.example.springboot_4_initial.services.interfaces.ICloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/imgs")
public class ImgController {
    @Autowired
    private ICloudinaryService iCloudinaryService;

    @PostMapping("/prueba")
    public ResponseEntity<?> prueba(@RequestParam("file") MultipartFile file) throws IOException {
        Map response_cloudinaru = iCloudinaryService.upload(file);
        Map<String, Object> response = new HashMap<>();
        response.put("url", response_cloudinaru.get("url"));
        response.put("public_id", response_cloudinaru.get("public_id"));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
