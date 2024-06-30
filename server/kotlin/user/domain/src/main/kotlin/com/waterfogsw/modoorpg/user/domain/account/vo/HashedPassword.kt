package com.waterfogsw.modoorpg.user.domain.account.vo

import java.security.MessageDigest


@JvmInline
value class HashedPassword(private val value: String) {

    companion object {

        private const val ALGORITHM = "SHA-256"
        private const val SHA_256_REGEX = "^[a-fA-F0-9]{64}\$"
        private const val INVALID_HASHED_PASSWORD = "잘못된 해시 비밀번호 입니다."
        private val MESSAGE_DIGEST = MessageDigest.getInstance(ALGORITHM)

        fun hash(password: Password): HashedPassword {
            val bytes: ByteArray = password.toString().toByteArray()
            val digest: ByteArray = MESSAGE_DIGEST.digest(bytes)
            return HashedPassword(digest.joinToString("") { "%02x".format(it) })
        }
    }

    init {
        require(value.matches(SHA_256_REGEX.toRegex())) { INVALID_HASHED_PASSWORD }
    }


    fun verify(password: Password): Boolean = this == password.hash()

    override fun toString(): String = value
}
