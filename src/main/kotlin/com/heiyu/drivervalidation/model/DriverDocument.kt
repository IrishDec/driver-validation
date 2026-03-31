package com.heiyu.drivervalidation.model

enum class DocumentStatus {
    PENDING,
    REJECTED,
    APPROVED
}

data class DriverDocument(
    val id: Long?,
    val fileName: String,
    val status: DocumentStatus
)