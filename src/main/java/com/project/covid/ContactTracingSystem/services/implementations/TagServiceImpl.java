package com.project.covid.ContactTracingSystem.services.implementations;

import com.project.covid.ContactTracingSystem.model.Tag;
import com.project.covid.ContactTracingSystem.repository.TagRepository;
import com.project.covid.ContactTracingSystem.services.TagService;
import com.project.covid.ContactTracingSystem.services.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    private TagRepository tagRepository;
    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag findOne(Object id) {
        return super.findOne(id);
    }

    @Override
    public List<Tag> findAll() {
        return super.findAll();
    }

    @Override
    public Tag create(Tag entity) {
        return super.create(entity);
    }

    @Override
    public Tag update(Tag entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Tag entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Object entityId) {
        super.deleteById(entityId);
    }

    @Override
    protected JpaRepository<Tag, Long> getDao() {
        return tagRepository;
    }
}
