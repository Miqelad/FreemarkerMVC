package com.site.springMVC.controller;

import com.site.springMVC.entity.FileUpload;
import com.site.springMVC.entity.User;
import com.site.springMVC.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller()
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileRepo fileRepo;
    @Value("${upload.path}")
    private String uploadPath;
    @PostMapping("/hello")
    public String imgDownloader(@RequestParam("file") MultipartFile file) throws IOException {
        FileUpload fileUpload = new FileUpload();

        if(file!=null){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                //Если файла не существует, мы его создаем, директорию для загрузки
                uploadDir.mkdir();
            }
            //создадим уникальное имя файла, и обезопасим себя коллизиями
            String uuidFile = UUID.randomUUID().toString();
            //добавляем уникальное имя + имя файла, которое создал пользователь
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            fileUpload.setFile(resultFileName);
            fileRepo.save(new FileUpload(1,resultFileName));




        }

        return "redirect:/";
    }
}
