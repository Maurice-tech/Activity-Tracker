package com.Maurice.Activity_Tracker.repository;

import com.Maurice.Activity_Tracker.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findCustomerModelByUserNameAndPassword (String userName, String password);
    Optional<Client> findFirstByUserName(String userName);
}
