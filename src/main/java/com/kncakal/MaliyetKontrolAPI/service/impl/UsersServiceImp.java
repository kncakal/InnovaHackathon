package com.kncakal.MaliyetKontrolAPI.service.impl;

import com.kncakal.MaliyetKontrolAPI.model.Users;
import com.kncakal.MaliyetKontrolAPI.repository.UsersRepository;
import com.kncakal.MaliyetKontrolAPI.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImp implements UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(Users user) throws Exception{
        try {
            usersRepository.save(user);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<Users> findAll() throws Exception{
        try {
            return usersRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Users findById(int id) throws Exception{
        try {
            Users response;
            Optional<Users> user = usersRepository.findById(id);
            if(user.isPresent()){
                response = user.get();
                return response;
            }else{
                throw new Exception("User not found for the id:" + id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws Exception{
        try {
            Users users = findById(id);
            if(users != null){
                usersRepository.delete(users);
            }else{
                throw new Exception("User not found for the id:" + id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
