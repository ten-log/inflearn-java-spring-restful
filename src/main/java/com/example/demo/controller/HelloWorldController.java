package com.example.demo.controller;

import com.example.demo.bean.HelloWorldBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Locale;


/**
 * rest contorller, 일반 contorller 차이는?
 */
@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @PostMapping("/upload")
    public String fileUpload(@RequestParam("uploadFile") MultipartFile file, Model model
            , HttpServletRequest request
    ) throws IOException {
        String savedFileName = "test789";
        // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치(프로젝트 외부에 저장)
        String uploadPath = "C:/Users/TEN/Downloads/";
        // 2. 원본 파일 이름 알아오기
        String originalFileName = "test456";
        // 3. 파일 이름 중복되지 않게 이름 변경(서버에 저장할 이름) UUID 사용
        String fileName = "test123.mp3";
        // 4. 파일 생성
        File file1 = new File(uploadPath + fileName);
        // 5. 서버로 전송
        file.transferTo(file1);
        // model로 저장
        model.addAttribute("originalFileName", originalFileName);
        return "upload/fileUploadResult";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "test";
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@Valid
                                         @PathVariable String name
    ) {
        throw new RuntimeException("this is test error");
//        return new HelloWorldBean(String.format("hello , %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String HelloWorldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
        System.out.println("test");
        return this.messageSource.getMessage("greeting.messages", null, locale);
    }

}
