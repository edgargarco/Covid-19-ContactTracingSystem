package com.project.covid.ContactTracingSystem.bootstrapInfo;

import com.project.covid.ContactTracingSystem.model.Address;
import com.project.covid.ContactTracingSystem.model.Tag;
import com.project.covid.ContactTracingSystem.services.AddressService;
import com.project.covid.ContactTracingSystem.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class BootStrapConf implements ApplicationListener<ContextRefreshedEvent> {
    private TagService tagService;
    private AddressService addressService;

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }
    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadAddress();


    }

//    public void loadTag() {
//        tagService.create(new Tag((long) 1, "324-5432", "Name: Jhon Doe"));
//        tagService.create(new Tag((long) 2, "324-5433", "Name: Zoe Click"));
//    }
    public void loadAddress(){
        addressService.create(new Address((long)1,"Avenida John F. Kennedy, esquina Calle Bienvenido García Gautier"
                ,"10102","Santo Domingo","Republica Dominicana"));
        addressService.create(new Address((long)2,"Avenida John F. Kennedy, esquina Calle Bienvenido García Gautier"
                ,"41000","La Vega","Republica Dominicana"));

    }
}
