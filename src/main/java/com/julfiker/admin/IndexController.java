package com.julfiker.admin;

import com.julfiker.admin.entity.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.julfiker.admin.repository.ApplicationRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class IndexController {

    @Autowired(required = false)
    ApplicationRepo applicationRepo;


    @PostMapping("/applications")
    public Application createApplication(@RequestBody Application application) {
        application = applicationRepo.save(application);
        return application;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> index(@RequestParam(required = false) String appId) {
        try {
            List<Application> applications = new ArrayList<>();

            if (appId == null)
                applicationRepo.findAll().forEach(applications::add);
            else
                applicationRepo.findByAppId(appId).forEach(applications::add);

            if (applications.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(applications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
