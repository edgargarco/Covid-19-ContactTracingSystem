package com.project.covid.ContactTracingSystem.services.implementations;

import com.project.covid.ContactTracingSystem.model.Address;
import com.project.covid.ContactTracingSystem.repository.AddressRepository;
import com.project.covid.ContactTracingSystem.services.AddressService;
import com.project.covid.ContactTracingSystem.services.common.IOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findOne(Object id) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address create(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address update(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public void delete(Address entity) {
        addressRepository.delete(entity);
    }

    @Override
    public void deleteById(Object entityId) {
        addressRepository.deleteById((long)entityId);
    }
}
