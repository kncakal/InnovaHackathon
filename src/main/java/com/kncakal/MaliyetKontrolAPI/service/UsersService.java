package com.kncakal.MaliyetKontrolAPI.service;

import com.kncakal.MaliyetKontrolAPI.model.Users;

import java.util.List;

public interface UsersService {
    void save(Users user) throws Exception;

    List<Users> findAll() throws Exception;

    Users findById(int id) throws Exception;

    void delete(int id) throws Exception;
}
