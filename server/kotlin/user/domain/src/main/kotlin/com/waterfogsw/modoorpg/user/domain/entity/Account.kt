package com.waterfogsw.modoorpg.user.domain.entity

import java.time.ZonedDateTime
import java.util.*

data class Account(
    val id: UUID,
    val email: Email,
    val password: HashedPassword,
    val username: Username,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
    val lastLoginAt: ZonedDateTime,
)
