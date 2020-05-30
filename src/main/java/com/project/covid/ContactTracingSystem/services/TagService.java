package com.project.covid.ContactTracingSystem.services;

import com.project.covid.ContactTracingSystem.model.Tag;
import com.project.covid.ContactTracingSystem.repository.TagRepository;
import com.project.covid.ContactTracingSystem.services.common.ICrudOperation;
import com.project.covid.ContactTracingSystem.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
@Service
public class TagService implements ICrudOperation<Tag, Long> {
    private TagRepository tagRepository;
    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createOrUpdate(Tag entity) {
        return tagRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        Tag tag = tagRepository.findById(aLong).orElse(null);
        if (tag != null){
            tagRepository.delete(tag);
        }else {
            Logger.getInstance().getLog(TagService.class).error("TAG ID: "+ aLong+" DOES NOT EXIST");
        }
    }

    @Override
    public Collection<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(Long aLong) {
        return tagRepository.findById(aLong).orElse(null);
    }
}
