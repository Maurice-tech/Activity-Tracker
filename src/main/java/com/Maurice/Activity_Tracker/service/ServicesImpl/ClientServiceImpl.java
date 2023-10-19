package com.Maurice.Activity_Tracker.service.ServicesImpl;

import com.Maurice.Activity_Tracker.entity.Client;
import com.Maurice.Activity_Tracker.repository.ClientRepository;
import com.Maurice.Activity_Tracker.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }


    @Override
    public Client registerCustomer(String firstName, String lastName, String email, String userName, Integer age, String password) {
        if(userName == null || password == null){
            return null;
        }
        else {
            if(clientRepo.findFirstByUserName(userName).isPresent()){
                return null;
            }
            else {
                Client client = new Client();

                client.setFirstName(firstName);
                client.setLastName(lastName);
                client.setEmail(email);
                client.setUserName(userName);
                client.setAge(age);
                client.setPassword(password);

                clientRepo.save(client);
                return client;
            }

        }
    }

    @Override
    public Client loginSer(String userName, String password) {
        return clientRepo.findCustomerModelByUserNameAndPassword(userName,password).orElse(null);
    }
}
