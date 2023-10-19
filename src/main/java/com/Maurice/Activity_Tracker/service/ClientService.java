package com.Maurice.Activity_Tracker.service;

import com.Maurice.Activity_Tracker.entity.Client;

public interface ClientService {
    public Client registerCustomer(String firstName, String lastName, String email, String userName, Integer age, String password);

    public Client loginSer(String userName, String password);
}
