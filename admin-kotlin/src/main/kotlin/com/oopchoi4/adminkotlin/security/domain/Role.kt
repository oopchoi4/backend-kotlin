@file:Suppress("unused")

package com.oopchoi4.adminkotlin.security.domain

import javax.persistence.*

@Entity
@Table(name = "app_role")
class Role(
  @Id
  @GeneratedValue
  val id: Int,

  @Column(name = "role_name", updatable = false)
  var roleName: String? = null,

  @Column(name = "description", updatable = false)
  var description: String? = null,

  @ManyToMany(mappedBy = "roles")
  var users: MutableSet<User>? = null
)
