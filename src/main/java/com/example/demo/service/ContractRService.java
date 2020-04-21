package com.example.demo.service;

import com.example.demo.model.ContractR;
import com.example.demo.model.Roba;
import com.example.demo.model.User;
import com.example.demo.repository.ContractRRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractRService {
    @Autowired
    ContractRRepository contractRRepository;

    @Autowired
    UserRepository userRepository;

    public void save(ContractR contractR){
        contractRRepository.save(contractR);
    }

    public ContractR findByRobaId(Long id){
        if(contractRRepository.findByRobaId(id).isPresent())
            return contractRRepository.findByRobaId(id).get();
        else
            return null;
    }

    public List<Roba> findByKupac(String username){
        Optional<User> u = userRepository.findByUsername(username);
        List<Roba> roba=new ArrayList<>();
        if(u.isPresent()) {
            for(ContractR c: contractRRepository.findByKupacId(u.get().getId())){
                roba.add(c.getRoba());
            }
            return roba;
        }
        return null;
    }

    public List<ContractR> getAll(){
        return contractRRepository.findAll();
    }

    public void delete(ContractR contractR){
        contractRRepository.delete(contractR);
    }
}
