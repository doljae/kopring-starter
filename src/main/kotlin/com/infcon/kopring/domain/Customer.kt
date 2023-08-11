package com.infcon.kopring.domain

import com.infcon.kopring.api.request.CustomerUpdateRequest
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.time.LocalDate
import java.time.Period

@Entity
class Customer(
    @Column
    var firstName: String,
    @Column
    var lastName: String,
    @Column
    @Enumerated(EnumType.STRING)
    var gender: Gender,
    @Column
    var birthDate: LocalDate,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    var address: Address? = null

    @Embedded
    var additionalInfo: AdditionalInfo? = null

    val age: Int
        get() = Period.between(birthDate, LocalDate.now()).years

    val fullName: String
        get() = "$firstName $lastName"

    fun update(request: CustomerUpdateRequest) {
        firstName = request.firstName
        lastName = request.lastName
        gender = request.gender
        birthDate = request.birthDate
    }
}
