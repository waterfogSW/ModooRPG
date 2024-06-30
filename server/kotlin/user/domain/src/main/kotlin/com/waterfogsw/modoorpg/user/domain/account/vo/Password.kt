package com.waterfogsw.modoorpg.user.domain.account.vo

@JvmInline
value class Password(private val value: String) {

    companion object {

        private const val MIN_LENGTH = 8
        private const val MAX_LENGTH = 20
        private const val PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}\$"
        private const val INVALID_PASSWORD_LENGTH_MESSAGE = "비밀번호는 8자 이상 20자 이하로 입력해주세요."
        private const val INVALID_PASSWORD_REGEX_MESSAGE = "비밀번호는 영문 대소문자, 숫자, 특수문자를 모두 포함해야 합니다."
    }

    init {
        require(value.length in MIN_LENGTH..MAX_LENGTH) { INVALID_PASSWORD_LENGTH_MESSAGE }
        require(value.matches(PASSWORD_REGEX.toRegex())) { INVALID_PASSWORD_REGEX_MESSAGE }
    }

    fun hash(): HashedPassword = HashedPassword.hash(this)

    override fun toString() = value
}
