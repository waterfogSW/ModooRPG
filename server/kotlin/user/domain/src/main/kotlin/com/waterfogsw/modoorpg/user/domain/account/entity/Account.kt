package com.waterfogsw.modoorpg.user.domain.account.entity

import com.waterfogsw.modoorpg.user.domain.account.vo.Email
import com.waterfogsw.modoorpg.user.domain.account.vo.HashedPassword
import com.waterfogsw.modoorpg.user.domain.account.vo.Username
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
