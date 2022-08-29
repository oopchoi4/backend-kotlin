package com.oopchoi4.adminkotlin.api.address

import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Int>
