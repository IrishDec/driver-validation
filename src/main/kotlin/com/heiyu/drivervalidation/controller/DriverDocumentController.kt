package com.heiyu.drivervalidation.controller

import com.heiyu.drivervalidation.model.DriverDocument
import com.heiyu.drivervalidation.service.DriverDocumentService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/api")
class DriverDocumentController(
    private val driverDocumentService: DriverDocumentService
) {

    @GetMapping("/health")
    fun hello(): String {
        return "Driver Validation API is running"
    }

    @GetMapping("/driver-documents")
    fun createDocument(
        @RequestParam driverId: String,
        @RequestParam fileName: String
    ): DriverDocument {
        return driverDocumentService.createDocument(driverId, fileName)
    }
}