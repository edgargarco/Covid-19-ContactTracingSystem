package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String tagId;
    private String data;

    public Tag() {
    }
    public Tag(Long id, String tagId,String data) {
        this.id = id;
        this.data = data;
        this.tagId = tagId;
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
