package com.heiyu.drivervalidation.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

enum class DocumentStatus {
    PENDING,
    REJECTED,
    APPROVED
}

@Entity
data class DriverDocument(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val driverId: String,

    val fileName: String,

    @Enumerated(EnumType.STRING)
    val status: DocumentStatus,

    val rejectionReason: String? = null
)