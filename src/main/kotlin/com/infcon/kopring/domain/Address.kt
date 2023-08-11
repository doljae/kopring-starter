package com.infcon.kopring.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Address(
    @Column
    var sido: String?,
    @Column
    var siGunGu: String?,
    @Column
    var eupMyonDong: String?,
    @Column
    var postalCode: String?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
