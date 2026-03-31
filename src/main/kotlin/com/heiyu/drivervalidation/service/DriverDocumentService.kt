package com.heiyu.drivervalidation.service

import com.heiyu.drivervalidation.model.DocumentStatus
import com.heiyu.drivervalidation.model.DriverDocument
import org.springframework.stereotype.Service

@Service
class DriverDocumentService {

    fun createDocument(fileName: String): DriverDocument {

        val status = if (fileName.contains("expired", ignoreCase = true)) {
            DocumentStatus.REJECTED
        } else {
            DocumentStatus.PENDING
        }

        return DriverDocument(
            id = 1,
            fileName = fileName,
            status = status
        )
    }
}