package com.fdobrotv.testphonebooking.entity;

import com.fdobrotv.testphonebooking.dto.Technology;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "phone")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne
    private PhoneModelEntity model;

    @OneToMany
    @JoinTable(
            name = "technology_to_phone",
            joinColumns = @JoinColumn( name="phone_id"),
            inverseJoinColumns = @JoinColumn( name="technology_id")
    )
    private List<TechnologyEntity> technologies;

    @OneToMany
    @JoinTable(
            name = "band_to_phone",
            joinColumns = @JoinColumn( name="phone_id"),
            inverseJoinColumns = @JoinColumn( name="band_id")
    )
    private List<BandEntity> bands;
}