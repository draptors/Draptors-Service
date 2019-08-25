package com.draptors.controller;

import com.draptors.config.ApplicationConstants;
import com.draptors.model.FileUploadResponse;
import com.draptors.service.FileStorageService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping("/uploadFile")
    @ResponseBody
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file) {
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        fileUploadResponse.setStatus(ApplicationConstants.FAILURE);

        String fileName = fileStorageService.storeFile(file);
        if (!StringUtils.isEmpty(fileName)) {
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            fileUploadResponse.setStatus(ApplicationConstants.SUCCESS);
            fileUploadResponse.setFileDownloadUri(fileDownloadUri);
            fileUploadResponse.setFileName(fileName);
        }
        return fileUploadResponse;
    }

    @RequestMapping("/uploadMultipleFiles")
    @ResponseBody
    public List<FileUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        List<FileUploadResponse> responseList = Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
        return responseList;
    }
}
