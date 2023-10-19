package com.Maurice.Activity_Tracker.controller;


import com.Maurice.Activity_Tracker.entity.Client;
import com.Maurice.Activity_Tracker.entity.ClientTask;
import com.Maurice.Activity_Tracker.entity.Status;
import com.Maurice.Activity_Tracker.repository.ClientTaskRepository;
import com.Maurice.Activity_Tracker.service.ClientTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;


    @Controller
    public class ClientTaskController {
        private final ClientTaskService clientTaskService;
        private final ClientTaskRepository clientTaskRepository;


        @Autowired
        public ClientTaskController(ClientTaskService clientTaskService, ClientTaskRepository clientTaskRepository) {
            this.clientTaskService = clientTaskService;
            this.clientTaskRepository = clientTaskRepository;
        }



        @PostMapping("/task_display")
        public String createTask(ClientTask clientTask) {
            clientTaskService.createTask(clientTask);
            return "redirect:/task_display";
        }

        @GetMapping("/task_display")
        public String getAllTasks(Model model) {
            Iterable<ClientTask> tasks = clientTaskService.getAllTasks();
            model.addAttribute("newTask", new ClientTask());
            model.addAttribute("tasks", tasks);
            return "taskPage"; // Render the task list view
        }


        @GetMapping("/view_task")
        public String getAllTasksAndView(Model model) {
            Iterable<ClientTask> tasks = clientTaskRepository.findAll();
            model.addAttribute("tasks", tasks);
            return "viewTask"; // Render the task list view
        }


        @PostMapping("/updateTaskStatus")
        public String updateTaskStatus(@RequestParam Long taskId) {
            // Retrieve the task from the database
            ClientTask task = clientTaskRepository.findById(taskId).orElse(null);

            if (task != null) {
                // Update the task's status to "Done"
                task.setStatus(Status.DONE);

                // Set the completedTime to the current timestamp
                task.setCompletedTime(Instant.now());

                clientTaskRepository.save(task); // Save the updated task

                // Redirect back to the task list page
                return "redirect:/view_task";
            } else {
                // Handle the case where the task is not found
                return "redirect:/task_display";
            }
        }

    }



