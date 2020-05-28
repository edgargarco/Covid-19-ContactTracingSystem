package com.project.covid.ContactTracingSystem.bootstrapInfo;

import com.project.covid.ContactTracingSystem.model.Tag;
import com.project.covid.ContactTracingSystem.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class BootStrapConf implements ApplicationListener<ContextRefreshedEvent> {
    private TagService tagService;

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadTag();
    }

    public void loadTag() {
        tagService.create(new Tag((long) 1, "324-5432", "Name: Jhon Doe"));
        tagService.create(new Tag((long) 2, "324-5433", "Name: Zoe Click"));
    }
}
