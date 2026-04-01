package com.heiyu.drivervalidation.repository

import com.heiyu.drivervalidation.model.DriverDocument
import org.springframework.data.jpa.repository.JpaRepository

interface DriverDocumentRepository : JpaRepository<DriverDocument, Long>