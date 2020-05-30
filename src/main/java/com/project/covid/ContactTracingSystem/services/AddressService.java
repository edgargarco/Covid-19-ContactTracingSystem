package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Address;
import com.project.covid.ContactTracingSystem.repository.AddressRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class AddressService implements ICrudOperation<Address,Long> {
    private AddressRepository addressRepository;
    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createOrUpdate(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null){
            addressRepository.delete(address);
        }else {
            Logger.getInstance().getLog(AddressService.class).error("ADDRESS ID: "+ id+" DOES NOT EXIST");
        }

    }

    @Override
    public Collection<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }
}
