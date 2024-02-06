package com.fdobrotv.testphonebooking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "specific_phone")
public class SpecificPhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne
    private PhoneEntity phone;

    @Column(name = "inventory_number", length = 1000)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String inventoryNumber;
}