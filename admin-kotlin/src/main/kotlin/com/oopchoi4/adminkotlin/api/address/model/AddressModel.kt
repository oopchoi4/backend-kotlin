package com.oopchoi4.adminkotlin.api.address.model

import com.oopchoi4.adminkotlin.api.address.domain.entity.Address
import com.oopchoi4.adminkotlin.common.service.CsvImportDto
import com.opencsv.bean.CsvBindByName
import java.time.LocalDateTime

data class AddressDto(
    var id: Int?,

    var name: String?,

    var street: String?,

    var zip: String?,

    var city: String?,

    var email: String?,

    var tel: String?,

    var enabled: Boolean?,

    var lastModfied: LocalDateTime?,

    var options: Map<String, Any>?,

    var things: Collection<String>?
)

class AddressImportDto : CsvImportDto<Address> {
    @CsvBindByName(required = true)
    var id: Int? = null

    @CsvBindByName(required = true)
    var name: String? = null

    @CsvBindByName(required = true)
    var street: String? = null

    @CsvBindByName(required = true)
    var zip: String? = null

    @CsvBindByName(required = true)
    var city: String? = null

    @CsvBindByName(required = true)
    var email: String? = null

    @CsvBindByName(required = true)
    var tel: String? = null

    @CsvBindByName(required = false)
    var options: String? = null

    @CsvBindByName(required = false)
    var things: String? = null

    override fun toEntity() =
        Address(id, name, street, zip, city, email, tel, false, LocalDateTime.now(), options, things)
}