package com.project.covid.ContactTracingSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String tagId;
    private String data;
    @OneToOne(mappedBy = "tag")
    @JsonBackReference
    private GenericUser genericUserTag;

    public Tag() {
    }
    public Tag( String tagId,String data) {

        this.data = data;
        this.tagId = tagId;

    }

    public GenericUser getGenericUserTag() {
        return genericUserTag;
    }

    public void setGenericUserTag(GenericUser genericUserTag) {
        this.genericUserTag = genericUserTag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagId='" + tagId + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
