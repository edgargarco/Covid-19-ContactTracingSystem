package com.project.covid.ContactTracingSystem.bootstrapInfo;

import com.project.covid.ContactTracingSystem.model.*;
import com.project.covid.ContactTracingSystem.model.enums.CivilStatus;
import com.project.covid.ContactTracingSystem.model.enums.Gender;
import com.project.covid.ContactTracingSystem.services.*;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Configuration
public class BootStrapConf implements ApplicationListener<ContextRefreshedEvent> {

    private PrivilegeService privilegeService;
    private RoleService roleService;
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
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
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
        Logger.getInstance().getLog(this.getClass()).info("Data bootstrap [...]");

        //Creating default Roles and Privileges
        createDefaultRolesAndPrivilege();

        //Creating default superusers
        createDefaultSuperUser();

        Logger.getInstance().getLog(this.getClass()).info("Ending bootstrap [...]");
    }

    private void createDefaultSuperUser(){
        Logger.getInstance().getLog(this.getClass()).info("Creating and Updating SUPERUSERS");
        Collection<Role> superUserRoles = roleService.findAll();
        UserCredential osvaldoCredentials = userCredentialService.findByName("osvaldo");
        if (osvaldoCredentials == null){
            osvaldoCredentials = new UserCredential("osvaldo","123","123456",true);

            Address address = new Address("Autopista las Americas Km.1",
                    "51000", "Santiago", "República Dominicana");
            Tag tag = new Tag("4F422275334835423F532C35", "Osvaldo Fernandez Valdez");

            GenericUser genericUser = new GenericUser("Osvaldo", "Fernandez Valdez", "402-1403345-0",
                    "example@spring.com", "829-888-8888",
                    new Date(1999, 2, 22), Gender.MALE,
                    CivilStatus.SINGLE, "Estudiante");
            genericUser.setAddress(address);
            genericUser.setUserCredential(osvaldoCredentials);
            genericUser.setTag(tag);
            genericUser.setHealthStatus(loadHealthStatus());
            genericUser.setRoles(roleService.findAll());
            genericUserService.createOrUpdate(genericUser);

        }
    }
    public void createDefaultRolesAndPrivilege() {
        Logger.getInstance().getLog(this.getClass()).info("Creating and update Application Privileges...");

        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        Logger.getInstance().getLog(this.getClass()).info("Creating and update Application Roles...");

        createRoleIfNotFound("ROLE_ADMIN", Arrays.asList(readPrivilege, writePrivilege));
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
    }

    private void createRoleIfNotFound(String role_user, Collection<Privilege> privileges) {
        Role role = roleService.findByRoleName(role_user);
        if (role == null) {
            role = new Role(role_user);
            role.setPrivileges(privileges);
            roleService.createOrUpdate(role);
        }
    }

    private Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeService.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeService.createOrUpdate(privilege);
        }
        return privilege;
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
