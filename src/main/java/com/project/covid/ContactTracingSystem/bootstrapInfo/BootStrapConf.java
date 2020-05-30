package com.project.covid.ContactTracingSystem.bootstrapInfo;

import com.project.covid.ContactTracingSystem.model.Address;
import com.project.covid.ContactTracingSystem.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class BootStrapConf implements ApplicationListener<ContextRefreshedEvent> {
    private AddressService addressService;
    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadAddress();
    }

    private void loadAddress() {
        addressService.createOrUpdate(new Address("Av. Rivas con Avenida Pedro A. Rivera",
                "41000","La Vega","Republica Dominicana"));
    }


}
