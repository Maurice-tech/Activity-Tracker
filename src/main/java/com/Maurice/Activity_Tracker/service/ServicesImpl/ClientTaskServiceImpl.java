package com.Maurice.Activity_Tracker.service.ServicesImpl;

import com.Maurice.Activity_Tracker.entity.ClientTask;
import com.Maurice.Activity_Tracker.repository.ClientTaskRepository;
import com.Maurice.Activity_Tracker.service.ClientTaskService;
import org.hibernate.engine.spi.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientTaskServiceImpl implements ClientTaskService {
    private final ClientTaskRepository taskRepository;

    @Autowired
    public ClientTaskServiceImpl(ClientTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public ClientTask createTask(ClientTask clientTask) {
        return taskRepository.save(clientTask);
    }

    @Override
    public ClientTask getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<ClientTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public ClientTask updateTask(Long id, ClientTask updatedTask) {
        ClientTask existingTask = getTaskById(id);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setDueDate(LocalDateTime.now());
            existingTask.setCompletedTime(updatedTask.getCompletedTime());
            return taskRepository.save(existingTask);
        }
        return null; // Task not found
    }
}


