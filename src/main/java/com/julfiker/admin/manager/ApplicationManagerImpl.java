package com.julfiker.admin.manager;

import com.julfiker.admin.entity.Application;
import com.julfiker.admin.repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationManagerImpl implements ApplicationManager {
    @Autowired
    ApplicationRepo applicationRepo;
    @Override
    public List<Application> findAllApplications() {
        return applicationRepo.findAll();
    }

    @Override
    public List<Application> findBy(Long id, String secretKey) {
        return applicationRepo.getApplicationBy(id, secretKey);
    }
}
