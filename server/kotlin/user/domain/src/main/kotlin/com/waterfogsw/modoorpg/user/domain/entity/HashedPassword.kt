package com.waterfogsw.modoorpg.user.domain.entity

import java.security.MessageDigest


@JvmInline
value class HashedPassword(private val value: String) {

    companion object {

        private const val ALGORITHM = "SHA-256"
        private val MESSAGE_DIGEST = MessageDigest.getInstance(ALGORITHM)

        fun hash(password: Password): HashedPassword {
            val bytes: ByteArray = password.toString().toByteArray()
            val digest: ByteArray = MESSAGE_DIGEST.digest(bytes)
            return HashedPassword(digest.joinToString("") { "%02x".format(it) })
        }
    }

    fun verify(password: Password): Boolean = this == password.hash()

    override fun toString(): String = value
}
