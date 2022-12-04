package com.mucahitarslan.application.rest.postalcode.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "postal_codes_info_table")
@NoArgsConstructor
@AllArgsConstructor
public class PostalCodeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postal_codes_info_id")
    public long id;

    @Column(name = "admin_name1")
    public String adminName1;

    @Column(name = "admin_code1")
    public String adminCode1;

    @Column(name = "place_name")
    public String placeName;

    @JsonProperty("lat")
    public double latitude;

    @JsonProperty("lng")
    public double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postal_code", nullable = false)
    public PostalCode postalCode;
}
