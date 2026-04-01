package com.heiyu.drivervalidation.service

import com.heiyu.drivervalidation.model.DocumentStatus
import com.heiyu.drivervalidation.model.DriverDocument
import com.heiyu.drivervalidation.repository.DriverDocumentRepository
import org.springframework.stereotype.Service

@Service
class DriverDocumentService(
    private val driverDocumentRepository: DriverDocumentRepository
) {

    fun createDocument(driverId: String, fileName: String): DriverDocument {

        val isExpired = fileName.contains("expired", ignoreCase = true)

        val status = if (isExpired) {
            DocumentStatus.REJECTED
        } else {
            DocumentStatus.PENDING
        }

        val rejectionReason = if (isExpired) {
            "Document is expired"
        } else {
            null
        }

        val document = DriverDocument(
            driverId = driverId,
            fileName = fileName,
            status = status,
            rejectionReason = rejectionReason
        )

        return driverDocumentRepository.save(document)
    }
}