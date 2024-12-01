package com.service.service_comissao.controller;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.service_comissao.model.TestDrive;
import com.service.service_comissao.service.TestDriveService;
import com.service.service_comissao.dtos.TestDriveRequest;

@RestController
@RequestMapping("/testdrives")
public class TestDriveController {
    private final TestDriveService service;

    public TestDriveController(TestDriveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TestDrive> scheduleTestDrive(@RequestBody TestDriveRequest request) {
        TestDrive testDrive = new TestDrive();
        testDrive.setDate(request.getDate());
        testDrive.setClientName(request.getClientName());

        TestDrive saved = service.scheduleTestDrive(testDrive, request.getVehicleId());
        return ResponseEntity.ok(saved);
    }

     @GetMapping
    public ResponseEntity<List<TestDrive>> getAllTestDrives() {
        List<TestDrive> testDrives = service.getAllTestDrives();
        return ResponseEntity.ok(testDrives);
    }


}



