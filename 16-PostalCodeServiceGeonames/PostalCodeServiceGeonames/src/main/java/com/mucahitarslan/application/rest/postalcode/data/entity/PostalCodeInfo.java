package com.mucahitarslan.application.rest.postalcode.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "postal_codes_info")
public class PostalCodeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postal_codes_info_id")
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code", nullable = false)
    public PostalCode postalCode;

    @Column(name = "admin_name1")
    public String adminName1;

    @Column(name = "admin_code1")
    public String adminCode1;

    @Column(name = "place_name")
    public String placeName;

    public double latitude;

    public double longitude;
}
