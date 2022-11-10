package com.liveasy.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveasy.api.model.Load;
import com.liveasy.api.repository.LoadRepository;


@Service
public class LoadService {
    @Autowired
    private LoadRepository loadRepository;

    public Optional<Load> create(Load employee){
        if (loadRepository.existsById(employee.getId())){
            return Optional.empty();
        }else{
            return Optional.of(loadRepository.save(employee));
        }
    }

    public List<Load> retrieve(){
        return loadRepository.findAll();
    }
    
    public List<Load> retrieveByShiperId(UUID shipperId){
        return loadRepository.findByShipperId(shipperId);
    }

    public Optional<Load> retrieveOne(int id){
        return loadRepository.findById(id);
    }
    
    public Optional<Load> update(Load employee){
        if (loadRepository.existsById(employee.getId())){
            return Optional.of(loadRepository.save(employee));
        }else{
            return Optional.empty();
        }
    }   

    public String delete(int id){
        if (loadRepository.existsById(id)){
            loadRepository.deleteById(id);
            return id + " deleted successfully!";
        }else{
            return "The employee data does not exist in records!";
        }
        
    }
    
}
