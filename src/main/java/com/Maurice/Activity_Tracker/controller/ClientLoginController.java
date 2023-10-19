package com.Maurice.Activity_Tracker.controller;

import com.Maurice.Activity_Tracker.entity.Client;
import com.Maurice.Activity_Tracker.service.ClientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


    @Controller
    public class ClientLoginController {
        private ClientService clientService;

        public ClientLoginController(ClientService clientService) {
            this.clientService = clientService;
        }

        @GetMapping("/cus_login")
        public String login(Model model){
            model.addAttribute("customerModel", new Client());
            return "customerLogin";
        }
        @GetMapping("/MainHomePage")
        public String mainHomePage(Model model){
            model.addAttribute("customerModel", new Client());
            return "homePage";
        }

        @PostMapping("/cus_login")
        public String loginPost(@ModelAttribute Client customerModel, Model model, HttpSession httpSession){
            Client checkModel = clientService.loginSer(customerModel.getUserName(),customerModel.getPassword());
            if(checkModel != null){
                model.addAttribute("checkLogin", checkModel.getFirstName());
                httpSession.setAttribute("customerId",checkModel.getId());
                return "redirect:/MainHomePage";
            }
            else {
                return "errorPage";
            }
        }
    }




