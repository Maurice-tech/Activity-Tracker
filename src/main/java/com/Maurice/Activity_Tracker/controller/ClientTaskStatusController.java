package com.Maurice.Activity_Tracker.controller;

import com.Maurice.Activity_Tracker.entity.ClientTask;
import com.Maurice.Activity_Tracker.service.ServicesImpl.TestingClient;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

    @Controller
    public class ClientTaskStatusController {

       private TestingClient testingClient;

        public ClientTaskStatusController(TestingClient testingClient) {
            this.testingClient = testingClient;
        }

        @GetMapping("/tasks/done")
        public String getTasksWithStatusDone(Model model) {
            System.out.println("are you here");
            List<ClientTask> tasks = testingClient.getTasksWithStatusDone();
            System.out.println("did you get to this place");
            model.addAttribute("tasks", tasks);
            System.out.println("welcome here");
            return "taskDone";
        }
        @GetMapping("/tasks/progress")
        public String getTasksWithStatusInProgress(Model model) {
            List<ClientTask> tasks = testingClient.getTasksWithStatusInProgress();
            model.addAttribute("tasks", tasks);
            return "taskDone";
        }

        @GetMapping("/tasks/todo")
        public String getTasksWithStatusTodo(Model model) {
            List<ClientTask> tasks = testingClient.getTasksWithStatusTodo();
            model.addAttribute("tasks", tasks);
            return "taskDone";
        }
    }



