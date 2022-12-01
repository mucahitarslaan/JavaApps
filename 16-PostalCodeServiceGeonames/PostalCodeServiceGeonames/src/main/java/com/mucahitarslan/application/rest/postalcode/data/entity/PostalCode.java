package com.mucahitarslan.application.rest.postalcode.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "postal_code_table")
public class PostalCode {
    @Id
    @Column(name = "postal_code")
    public int postalCode;

    @Column(name = "creation_date_time")
    public LocalDateTime creationDateTime;

    @OneToMany(mappedBy = "postalCode", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<PostalCodeInfo> postalCodeInfos;
}
