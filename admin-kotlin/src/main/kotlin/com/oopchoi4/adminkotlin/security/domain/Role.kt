@file:Suppress("unused")

package com.oopchoi4.adminkotlin.security.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "app_role")
class Role(
  @Id
  @GeneratedValue
  val id: Int,

  @Column(name = "role_name", updatable = false)
  val roleName: String? = null,

  @Column(name = "description", updatable = false)
  val description: String? = null,

  @ManyToMany(mappedBy = "roles")
  val users: MutableSet<User>? = null,

  val createdAt: LocalDateTime? = LocalDateTime.now(),
  val updatedAt: LocalDateTime? = LocalDateTime.now()
)
