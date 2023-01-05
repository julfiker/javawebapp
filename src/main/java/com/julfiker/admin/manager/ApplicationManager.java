package com.julfiker.admin.manager;

import com.julfiker.admin.entity.Application;

import java.util.List;

public interface ApplicationManager {
    List<Application> findAllApplications();

    List<Application> findBy(Long id, String secretKey);
}
