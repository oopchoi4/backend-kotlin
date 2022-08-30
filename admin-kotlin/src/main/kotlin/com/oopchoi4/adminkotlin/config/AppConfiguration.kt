package com.oopchoi4.adminkotlin.config

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
@EnableConfigurationProperties(
  SecurityProperties::class
)
class AppConfiguration(
  val securityProperties: SecurityProperties
) {
  @Bean
  fun bCryptPasswordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder(securityProperties.strength)

  @Bean
  fun cleanMigrateStrategy(): FlywayMigrationStrategy? {
    return FlywayMigrationStrategy { flyway: Flyway ->
      flyway.repair()
      flyway.migrate()
    }
  }
}
