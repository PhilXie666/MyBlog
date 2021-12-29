package com.demo.xwx.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 与前端进行图片交互的Controller
 */
@RestController
@RequestMapping("/img")
public class PictureController {

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPicture(@RequestParam("fileName") String fileName) throws Exception {

        System.out.println("前端请求的图片名称：");
        System.out.println(fileName);

        // 组装图片文件完整路径
        String path = "D:\\InGraduateSchool\\workPreparation\\Blog_Myself_Picture_Savepath\\" + fileName;

        File imgFile = new File(path);
        FileInputStream inputStream = new FileInputStream(imgFile);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());

        return bytes;

    }

}
