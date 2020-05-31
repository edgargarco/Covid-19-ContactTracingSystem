package com.project.covid.ContactTracingSystem.bootstrapInfo;

import com.project.covid.ContactTracingSystem.model.Address;
import com.project.covid.ContactTracingSystem.model.GenericUser;
import com.project.covid.ContactTracingSystem.model.Privilege;
import com.project.covid.ContactTracingSystem.model.Tag;
import com.project.covid.ContactTracingSystem.model.enums.CivilStatus;
import com.project.covid.ContactTracingSystem.model.enums.Gender;
import com.project.covid.ContactTracingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.sql.Date;

@Configuration
public class BootStrapConf implements ApplicationListener<ContextRefreshedEvent> {
    private AddressService addressService;
    private PrivilegeService privilegeService;
    private UserRoleService userRoleService;
    private TagService tagService;
    private UserCredentialService userCredentialService;
    private VisitService visitService;
    private LocalityService localityService;
    private NodeService nodeService;
    private GpsLocationService gpsLocationService;
    private InstitutionService institutionService;
    private HealthStatusService healthStatusService;
    private PcrTestService pcrTestService;
    private GenericUserService genericUserService;
    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
    @Autowired
    public void setPrivilegeService(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }
    @Autowired
    public void setUserCredentialService(UserCredentialService userCredentialService) {
        this.userCredentialService = userCredentialService;
    }
    @Autowired
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }
    @Autowired
    public void setLocalityService(LocalityService localityService) {
        this.localityService = localityService;
    }
    @Autowired
    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }
    @Autowired
    public void setGpsLocationService(GpsLocationService gpsLocationService) {
        this.gpsLocationService = gpsLocationService;
    }
    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    @Autowired
    public void setHealthStatusService(HealthStatusService healthStatusService) {
        this.healthStatusService = healthStatusService;
    }
    @Autowired
    public void setPcrTestService(PcrTestService pcrTestService) {
        this.pcrTestService = pcrTestService;
    }
    @Autowired
    public void setGenericUserService(GenericUserService genericUserService) {
        this.genericUserService = genericUserService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //loadAddress();
        loadUsers();
    }


    private void loadUsers() {
        Tag tag = new Tag("4F422275334835423F532C35","Edgar Garcia Coronado");
        Address address = new Address("Av. Rivas con Avenida Pedro A. Rivera",
                "41000","La Vega","República Dominicana");
        genericUserService.createOrUpdate(new GenericUser("Edgar","Garcia Coronado","402-1403050-0",
                address,"example@spring.com","829-381-9028",
                new Date(1999,06,04), Gender.MALE,
                CivilStatus.SINGLE,"Estudiante",tag));
    }
    private void loadUserCredential(){

    }
    private void load(){

    }
    private void loadProvileges(){
        //privilegeService.createOrUpdate(new Privilege("READ_PRIVILEGE"));
    }
    private void loadRoles(){
        //userRoleService.createOrUpdate()
    }


    private void loadAddress() {
        addressService.createOrUpdate(new Address("Av. Rivas con Avenida Pedro A. Rivera",
                "41000","La Vega","República Dominicana"));
        addressService.createOrUpdate(new Address("Av. Gregorio Rivas #183",
                "41000","La Vega","República Dominicana"));
        addressService.createOrUpdate(new Address("Av Juan Pablo Duarte",
                "51000","Santiago","República Dominicana"));
    }
//    private void loadTags(){
//        tagService.createOrUpdate(new Tag("4F422275334835423F532C35","[\"name\": \"Mercer Simpson\",\n" +
//                "    \"gender\": \"male\",\n" +
//                "    \"company\": \"TALENDULA\",\n" +
//                "    \"email\": \"mercersimpson@talendula.com\",\n" +
//                "    \"phone\": \"+1 (855) 495-2432\"]",genericUserService.findById(1L)));
//    }




}
