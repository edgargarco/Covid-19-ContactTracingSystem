package com.project.covid.ContactTracingSystem.controller;

import com.project.covid.ContactTracingSystem.model.Address;
import com.project.covid.ContactTracingSystem.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;
    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping(path = "/",produces = "application/json")
    public ResponseEntity<Collection<Address>> getAllAddresses(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}",produces = "application/json")
    public ResponseEntity<Address> getAddressesById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);
    }
    @GetMapping(path = "/city/{city}", produces = "application/json")
    public ResponseEntity<Collection<Address>> getAddressesByCity(@PathVariable String city){
        return new ResponseEntity<>(addressService.findAddressByCity(city),HttpStatus.OK);
    }
    @GetMapping(path = "/postal-code/{postalCode}", produces = "application/json")
    public ResponseEntity<Collection<Address>> getAddressesByPostalCode(@PathVariable String postalCode){
        return new ResponseEntity<>(addressService.findAddressByPostalCode(postalCode),HttpStatus.OK);
    }
    @GetMapping(path = "/direction/{direction}", produces = "application/json")
    public ResponseEntity<Collection<Address>> getAddressByDirection(@PathVariable String direction){
        return new ResponseEntity<>(addressService.findAddressByDirection(direction),HttpStatus.OK);
    }
    @GetMapping(path = "/direction/{direction}/city/{city}", produces = "application/json")
    public ResponseEntity<Collection<Address>> getAddressByDirection(@PathVariable String direction,@PathVariable String city){
        return new ResponseEntity<>(addressService.findAddressByDirectionContainingAndCityContaining(direction,city),HttpStatus.OK);
    }



}
