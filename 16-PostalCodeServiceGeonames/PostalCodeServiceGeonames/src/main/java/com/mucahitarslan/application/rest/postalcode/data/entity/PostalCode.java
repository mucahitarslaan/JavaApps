package com.mucahitarslan.application.rest.postalcode.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class PostalCode {
    @Id
    @Column(name = "postal_code")
    public int postalCode;

    @Column(name = "creation_date_time")
    public LocalDateTime creationDateTime;

    @
    @OneToMany
    public Set<PostalCodeInfo> postalCodeInfos;
}
