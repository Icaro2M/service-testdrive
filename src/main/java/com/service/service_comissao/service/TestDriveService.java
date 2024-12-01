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
        

        String vehicleServiceUrl = "https://av3-projetos-production.up.railway.app/produtos/" + vehicleId;
         Map<String, Object> response = restTemplate.postForObject(vehicleServiceUrl, null, Map.class);
        String vehicleName = response != null ? (String) response.get("nome") : "";

        
        testDrive.setVehicleName(vehicleName);
        return repository.save(testDrive);
    }


    public List<TestDrive> getAllTestDrives() {
        return repository.findAll();
    }
}
