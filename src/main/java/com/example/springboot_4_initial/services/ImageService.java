package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.exceptions.NotFoundFile;
import com.example.springboot_4_initial.exceptions.NotValidateMimes;
import com.example.springboot_4_initial.services.interfaces.IImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService implements IImageService {

    @Override
    public String save_image(String path_img, MultipartFile multipartFile) throws IOException {
        // ! Validacion de existencia de archivo
        if (multipartFile.isEmpty()) {
            throw new NotFoundFile("Ocurrio un error en la subida del archivo");
        }

        // ! Validacion de extensiones del archivo
        boolean result_validate_mimes = this.validated_mimes(multipartFile, new String[]{"image/png", "image/jpeg", "image/jpg"});
        if (!result_validate_mimes) {
            throw new NotValidateMimes("La extensión del archivo no es valida");
        }

        // ! Validacion de ruta de almacenamiento
        File destination_folder = new File(path_img);
        if (!destination_folder.exists()) {
            destination_folder.mkdir();
        }

        // * Guardado de archivo con nuevo nombre
        String file_name = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename().replace(" ", "_");
        multipartFile.transferTo(new File(destination_folder + "/" + file_name));
        return destination_folder + "/" + file_name;
    }

    @Override
    public boolean validated_mimes(MultipartFile multipartFile, String[] mimes) {
        String type_file = multipartFile.getContentType();
        List<String> validate_mimes = Arrays.asList(mimes);
        if (!validate_mimes.contains(type_file)) {
            throw new NotValidateMimes("La extensión del archivo no es valida. Se recibio un archivo tipo: " + multipartFile.getContentType());
        }
        return true;
    }
}
