//package com.project.covid.ContactTracingSystem.repository;
//
//import com.project.covid.ContactTracingSystem.model.Address;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//
//@Repository
//public interface AddressRepository extends JpaRepository<Address,Long> {
//    Collection<Address> findAddressByCityContaining(String city);
//    Collection<Address> findAddressByPostalCode(String postalCode);
//    Collection<Address> findAddressByDirectionContaining(String direction);
//    Collection<Address> findAddressByDirectionContainingAndCityContaining(String direction, String city);
//}
