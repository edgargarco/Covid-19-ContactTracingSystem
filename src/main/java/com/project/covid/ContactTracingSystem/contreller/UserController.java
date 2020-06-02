package com.project.covid.ContactTracingSystem.contreller;

import com.project.covid.ContactTracingSystem.model.GenericUser;
import com.project.covid.ContactTracingSystem.services.GenericUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private GenericUserService genericUserService;
    @Autowired
    public void setGenericUserService(GenericUserService genericUserService) {
        this.genericUserService = genericUserService;
    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<GenericUser>> getAllUsers(){
        return new ResponseEntity<>(genericUserService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<GenericUser> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(genericUserService.findById(id),HttpStatus.OK);
    }

}
