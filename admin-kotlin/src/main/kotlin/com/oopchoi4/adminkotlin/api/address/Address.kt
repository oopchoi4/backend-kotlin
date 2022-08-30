package com.oopchoi4.adminkotlin.api.address

import org.hibernate.Hibernate
import com.oopchoi4.adminkotlin.toArray
import com.oopchoi4.adminkotlin.toMap
import com.oopchoi4.adminkotlin.writeValueAsString
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "address")
data class Address(
  @Id
  @GeneratedValue
  val id: Int?,

  val name: String?,

  val street: String?,

  val zip: String?,

  val city: String?,

  val email: String?,

  val tel: String?,

  val enabled: Boolean?,

  val lastModified: LocalDateTime?,

  @Lob val options: String?,

  @Lob val things: String?,

  val createdAt: LocalDateTime? = LocalDateTime.now(),
  val updatedAt: LocalDateTime? = LocalDateTime.now()
) {
  fun toDTO() = AddressDto(
    id,
    name,
    street,
    zip,
    city,
    email,
    tel,
    enabled,
    lastModified,
    options.toMap(),
    things.toArray()
  )

  companion object {
    fun fromDTO(dto: AddressDto) = Address(
      dto.id,
      dto.name,
      dto.street,
      dto.zip,
      dto.city,
      dto.email,
      dto.tel,
      dto.enabled,
      LocalDateTime.now(),
      dto.options.writeValueAsString(),
      dto.things.writeValueAsString()
    )
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
    other as Address

    return id != null && id == other.id
  }

  override fun hashCode(): Int = javaClass.hashCode()

  @Override
  override fun toString(): String {
    return this::class.simpleName + "(id = $id )"
  }
}
