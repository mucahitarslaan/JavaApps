package com.mucahitarslan.application.rest.postalcode.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "postal_codes")
public class PostalCode {
    @Id
    @Column(name = "postal_id")
    public int postal_id;

    public String postalCodeStr;

    @Column(name = "creation_date_time")
    public LocalDateTime creationDateTime;

    @OneToMany(mappedBy = "postalCode", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<PostalCodeInfo> postalCodeInfos;

}
