package com.Maurice.Activity_Tracker.service.ServicesImpl;

import com.Maurice.Activity_Tracker.entity.Client;
import com.Maurice.Activity_Tracker.entity.ClientTask;
import com.Maurice.Activity_Tracker.entity.Status;
import com.Maurice.Activity_Tracker.repository.ClientRepository;
import com.Maurice.Activity_Tracker.repository.ClientTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class TestingClient {
    private ClientTaskRepository clientTaskRepository;

    @Autowired
    public TestingClient(ClientTaskRepository clientTaskRepository) {
        this.clientTaskRepository = clientTaskRepository;
    }

    public List<ClientTask> getTasksWithStatusDone() {
//        return clientTaskRepository.findByStatus(Status.DONE);
        return clientTaskRepository.findByStatus(Status.DONE);
    }
    public List<ClientTask> getTasksWithStatusInProgress() {
        return clientTaskRepository.findByStatus(Status.IN_PROGRESS);
    }
    public List<ClientTask> getTasksWithStatusTodo() {
        return clientTaskRepository.findByStatus(Status.TODO);
    }
}

