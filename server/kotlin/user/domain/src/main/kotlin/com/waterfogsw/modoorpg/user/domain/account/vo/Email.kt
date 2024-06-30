package com.waterfogsw.modoorpg.user.domain.account.vo

@JvmInline
value class Email(private val value: String) {

    companion object {

        private const val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
        private const val MAX_LOCAL_PART_LENGTH = 64
        private const val MAX_DOMAIN_LENGTH = 255
        private const val INVALID_EMAIL_MESSAGE = "잘못된 이메일 형식입니다."
    }

    init {
        require(value.matches(EMAIL_REGEX.toRegex())) { INVALID_EMAIL_MESSAGE }
        require(isValidLength(value)) { INVALID_EMAIL_MESSAGE }
    }

    private fun isValidLength(value: String): Boolean {
        val split: List<String> = value.split("@")
        return split[0].length <= MAX_LOCAL_PART_LENGTH && split[1].length <= MAX_DOMAIN_LENGTH
    }

    override fun toString(): String = value
}
