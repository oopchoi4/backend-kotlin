@file:Suppress("unused")

package com.oopchoi4.adminkotlin.api.user.domain.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "app_user")
class User(
  @Id
  @GeneratedValue
  val id: Long? = null,

  @Column(name = "username", unique = true)
  val username: String? = null,

  @Column(name = "email", unique = true)
  val email: String? = null,

  @Column(name = "password")
  val password: String? = null,

  @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
  @JoinTable(
    name = "user_role",
    joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
    inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
  )
  val roles: Set<Role>? = null,

  val createdAt: LocalDateTime? = LocalDateTime.now(),
  val updatedAt: LocalDateTime? = LocalDateTime.now()
)

