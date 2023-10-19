package com.Maurice.Activity_Tracker.controller;


import com.Maurice.Activity_Tracker.entity.Client;
import com.Maurice.Activity_Tracker.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class ClientController {

        private ClientService clientService;

        public ClientController(ClientService clientService) {
            this.clientService = clientService;
        }

        @GetMapping("/cus_register")
        public String Registration(Model model){
            model.addAttribute("customerModel", new Client());
            return "customer_register_page";
        }

        @PostMapping("/cus_register")
        public String RegisterPost(@ModelAttribute Client client){
            Client registeredCustomer = clientService.registerCustomer(client.getFirstName(),client.getLastName(),client.getEmail(),client.getUserName(),
                    client.getAge(),client.getPassword());

            return registeredCustomer == null ? "errorPage" : "customerLogin";
        }
    }



