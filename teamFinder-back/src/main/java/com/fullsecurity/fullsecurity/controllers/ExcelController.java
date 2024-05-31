package com.fullsecurity.fullsecurity.controllers;

import com.fullsecurity.fullsecurity.models.ExcelTest;
import com.fullsecurity.fullsecurity.services.ExcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (this.excelService.hasExcelFormat(file)) {
            try {
                this.excelService.save(file);
                message = "The Excel file is uploaded: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                message = e.getMessage();  // Extract the exact message from the IllegalArgumentException
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
            catch (Exception exp) {
                message = "The Excel file is not upload: " + file.getOriginalFilename() + "!";
                exp.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @GetMapping("/student-list")
    public ResponseEntity<?> getStudents() {
        Map<String, Object> respStu = new LinkedHashMap<String, Object>();
        List<ExcelTest> studList = excelService.findAll();
        if (!studList.isEmpty()) {
            respStu.put("status", 1);
            respStu.put("data", studList);
            return new ResponseEntity<>(respStu, HttpStatus.OK);
        } else {
            respStu.clear();
            respStu.put("status", 0);
            respStu.put("message", "Data is not found");
            return new ResponseEntity<>(respStu, HttpStatus.NOT_FOUND);
        }
    }
}
