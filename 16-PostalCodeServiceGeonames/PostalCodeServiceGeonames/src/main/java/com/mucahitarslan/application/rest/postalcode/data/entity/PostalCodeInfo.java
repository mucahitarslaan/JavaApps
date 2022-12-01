package com.mucahitarslan.application.rest.postalcode.data.entity;

import javax.persistence.*;

@Entity
public class PostalCodeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne
    private PostalCode postalCode;

    public String adminName1;
    public String adminCode1;
    public String placeName;

    public double latitude;

    public double longitude;
}
