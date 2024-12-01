package com.service.service_comissao.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.service_comissao.model.TestDrive;
import com.service.service_comissao.repository.TestDriveRepository;

@Service
public class TestDriveService {
    private final TestDriveRepository repository;
    private final RestTemplate restTemplate;

    public TestDriveService(TestDriveRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public TestDrive scheduleTestDrive(TestDrive testDrive, Long vehicleId) {
        

        String vehicleServiceUrl = "https://testeconexao-production.up.railway.app/test/" + vehicleId;
        String vehicleName = restTemplate.postForObject(vehicleServiceUrl,null, String.class);

        
        testDrive.setVehicleName(vehicleName);
        return repository.save(testDrive);
    }


    public List<TestDrive> getAllTestDrives() {
        return repository.findAll();
    }
}
