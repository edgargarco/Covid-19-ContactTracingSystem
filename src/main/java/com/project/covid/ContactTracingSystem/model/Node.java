package com.project.covid.ContactTracingSystem.model;

import javax.persistence.*;

 @Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nodeId;
    private boolean isAuthenticated;
    @OneToOne(cascade = CascadeType.ALL)
    private GpsLocation gpsLocation;
    @OneToOne
    private Locality locality;
    @OneToOne
    private GpsLocation lastLocation;

    public Node() {
    }

    public Node(String nodeId, boolean isAuthenticated, GpsLocation gpsLocation, Locality locality, GpsLocation lastLocation) {
        this.nodeId = nodeId;
        this.isAuthenticated = isAuthenticated;
        this.gpsLocation = gpsLocation;
        this.locality = locality;
        this.lastLocation = lastLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public GpsLocation getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(GpsLocation gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public GpsLocation getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(GpsLocation lastLocation) {
        this.lastLocation = lastLocation;
    }
}
