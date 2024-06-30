package com.waterfogsw.modoorpg.user.domain.account.entity

import com.waterfogsw.modoorpg.user.domain.account.vo.Email
import com.waterfogsw.modoorpg.user.domain.account.vo.HashedPassword
import com.waterfogsw.modoorpg.user.domain.account.vo.Password
import com.waterfogsw.modoorpg.user.domain.account.vo.Username
import extension.UuidUtil
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
) {

    companion object {

        fun register(
            email: String,
            password: String,
            username: String,
        ): Account {
            return Account(
                id = UuidUtil.getTimeOrderedEpoch(),
                email = Email(email),
                password = Password(password).hash(),
                username = Username(username),
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now(),
                lastLoginAt = ZonedDateTime.now(),
            )
        }

    }


}
