package com.tony.qr_picture_create.controller;

import com.tony.qr_picture_create.until.QRCodeUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/draw")
public class DrawQRCodeController {
    @GetMapping
    public void draw() throws Exception {
        String content = "我要拉屎";
        String imgtPath = "templates/logo.jpg";
        String destPath = "templates/drcode.jpg";

        QRCodeUtil.encode(content, imgtPath, destPath);

    }

    @GetMapping("/decode")
    public String decode() throws Exception {
        File file = new ClassPathResource("templates/drcode.jpg").getFile();

        String decode = QRCodeUtil.decode(file);
        System.out.println(decode);

        return decode;
    }
}
