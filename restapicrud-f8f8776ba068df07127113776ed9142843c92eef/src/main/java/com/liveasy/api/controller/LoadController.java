package com.liveasy.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liveasy.api.model.Load;
import com.liveasy.api.service.LoadService;
/* 
    CRUD - Create, Retrieve, Update, Delete
    POST    /api/v1/load	    create new load
    GET	    /api/v1/load	    retrieve all loads
    GET	    /api/v1/load/:id	retrieve a load by :id
    PUT	    /api/v1/load/   	update a load
    DELETE  /api/v1/load/:id	delete a load by :id
*/
@RestController
@RequestMapping("/api/v1/load")
public class LoadController {
    
    @Autowired
    private LoadService loadService;

    @PostMapping
    public String saveLoad(@RequestBody Load load) {
    	if(null==load.getShipperId() || load.getShipperId().toString().isEmpty())
    		load.setShipperId(UUID.randomUUID());
        Optional<Load> _load = loadService.create(load);
        if(_load.isPresent()){
            return "The load data has been saved successfully!";
        }else{
            return "Load already exist in records";
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Load> getLoadById(@PathVariable("id") int id) {
      Optional<Load> load = loadService.retrieveOne(id);  
      if (load.isPresent()) {
        return new ResponseEntity<>(load.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }    

    /*@GetMapping
    public List<Load> getALLloads() {
      return loadService.retrieve();
    }*/
    
    @GetMapping
    public List<Load> getLoadByShipperId(@RequestParam (name = "shipperId") String shipperId) {
      return loadService.retrieveByShiperId(UUID.fromString(shipperId));
    }

    @PutMapping
    public String updateload(@RequestBody Load load) {
        Optional<Load> _load = loadService.update(load);
        if(_load.isEmpty()){
            return "The load data does not exist in records!";
        }else{
            return "The load data has been updated successfully!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteLoadById(@PathVariable("id") int id) {
      return  loadService.delete(id);   
    } 
    
    @GetMapping("/test")
    public String getRestStatus() {
    	return "Working!";
    }    

}
