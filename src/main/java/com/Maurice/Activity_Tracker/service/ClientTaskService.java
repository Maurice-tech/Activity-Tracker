package com.Maurice.Activity_Tracker.service;

import com.Maurice.Activity_Tracker.entity.ClientTask;
import org.hibernate.engine.spi.Status;

import java.util.List;

public interface ClientTaskService {
    public ClientTask createTask(ClientTask clientTask);
    public ClientTask getTaskById(Long id);
    public Iterable<ClientTask> getAllTasks();
    public ClientTask updateTask(Long id, ClientTask updatedTask);

}
