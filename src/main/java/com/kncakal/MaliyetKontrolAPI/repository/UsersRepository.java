package com.kncakal.MaliyetKontrolAPI.repository;

import com.kncakal.MaliyetKontrolAPI.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
