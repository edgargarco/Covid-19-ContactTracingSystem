package com.project.covid.ContactTracingSystem.bootstrapInfo;

import com.project.covid.ContactTracingSystem.model.*;
import com.project.covid.ContactTracingSystem.model.enums.CivilStatus;
import com.project.covid.ContactTracingSystem.model.enums.Gender;
import com.project.covid.ContactTracingSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Configuration
public class BootStrapConf implements ApplicationListener<ContextRefreshedEvent> {

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
        loadPrivileges();
        loadRoles();
        loadUsers();
        loadLocality();
    }


    private void loadUsers() {

        Tag tag = new Tag("4F422275334835423F532C35", "Edgar Garcia Coronado");
        Address address = new Address("Av. Rivas con Avenida Pedro A. Rivera",
                "41000", "La Vega", "República Dominicana");

        GenericUser genericUser = new GenericUser("Edgar", "Garcia Coronado", "402-1403050-0",
                "example@spring.com", "829-381-9028",
                new Date(1999, 6, 4), Gender.MALE,
                CivilStatus.SINGLE, "Estudiante");
        genericUser.setAddress(address);
        genericUser.setTag(tag);
        genericUser.setUserCredential(new UserCredential("garco", "admin", "997644", true));
        genericUser.setHealthStatus(loadHealthStatus());
        genericUserService.createOrUpdate(genericUser);
    }

    private void loadPrivileges() {
        privilegeService.createOrUpdate(new Privilege("READ_PRIVILEGE"));
        privilegeService.createOrUpdate(new Privilege("WRITE_PRIVILEGE"));
        privilegeService.createOrUpdate(new Privilege("CREATE_NODES"));
        privilegeService.createOrUpdate(new Privilege("CREATE_TAGS"));
        privilegeService.createOrUpdate(new Privilege("STATISTICS"));
        privilegeService.createOrUpdate(new Privilege("SEE_NODE_STATUS"));
    }

    private void loadRoles() {
        UserRole userRole = new UserRole("SUPERUSER");
        userRole.setPrivileges((List<Privilege>) privilegeService.findAll());
        userRoleService.createOrUpdate(userRole);

        UserRole userRole_2 = new UserRole("PROGRAMMER");
        userRole_2.setPrivileges(privilegeService.findThreePrivileges("CREATE_NODES", "CREATE_TAGS", "SEE_NODE_STATUS"));
        userRoleService.createOrUpdate(userRole_2);

        UserRole userRole_3 = new UserRole("HEALTH_MINISTER");
        userRole_3.setPrivileges((List<Privilege>) privilegeService.findAll());
        userRoleService.createOrUpdate(userRole_3);
    }

    private void loadLocality() {
        Node node = new Node();
        node.setNodeId("NODE-01");
        node.setGpsLocation(new GpsLocation(new BigDecimal(19.4436), new BigDecimal(70.6844)));
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);

        Locality locality = new Locality();
        locality.setName("PUCMM");
        locality.setEmail("info@pucmm.edu.do");
        locality.setCellPhone("809-200-1962");
        locality.setAddress(new Address("Autopista Duarte Km 1 1/2", "51000", "Santiago", "República Dominicana"));
        locality.setNodes(nodes);
        localityService.createOrUpdate(locality);

    }
    private List<HealthStatus> loadHealthStatus(){
        List<HealthStatus> healthStatuses = new ArrayList<>();
        HealthStatus healthStatus = new HealthStatus();
        healthStatus.setBreathDifficulty(false);
        healthStatus.setCough(false);
        healthStatus.setFever(false);
        healthStatus.setSmellLoss(false);
        healthStatus.setSoreThroat(false);
        healthStatus.setTasteLoss(false);
        healthStatus.setTest(new PcrTest(true,false));
        healthStatuses.add(healthStatus);
        return healthStatuses;
    }




}
