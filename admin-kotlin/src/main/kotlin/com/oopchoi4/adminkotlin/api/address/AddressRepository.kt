package com.oopchoi4.adminkotlin.api.address

import com.oopchoi4.adminkotlin.api.address.domain.entity.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Int>
