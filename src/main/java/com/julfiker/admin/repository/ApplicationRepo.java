package com.julfiker.admin.repository;
import java.util.List;

import com.julfiker.admin.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    List<Application> findByAppId(String appId);

    @Query("Select A from Application  A where A.id=?1 and A.secretKey=?2")
    List<Application> getApplicationBy(Long id, String secretKey);
}