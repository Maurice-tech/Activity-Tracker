package com.Maurice.Activity_Tracker.repository;

import com.Maurice.Activity_Tracker.entity.ClientTask;
import org.hibernate.engine.spi.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientTaskRepository extends JpaRepository<ClientTask, Long> {



    List<ClientTask> findByStatus(com.Maurice.Activity_Tracker.entity.Status status);
}
