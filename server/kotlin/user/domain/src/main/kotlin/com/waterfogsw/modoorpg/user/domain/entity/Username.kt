package com.waterfogsw.modoorpg.user.domain.entity

@JvmInline
value class Username(private val value: String) {

    companion object {

        private const val MIN_LENGTH = 2
        private const val MAX_LENGTH = 8
        private val VALID_PATTERN = Regex("^[가-힣a-zA-Z0-9]+$")
        private const val INVALID_LENGTH_MESSAGE = "사용자 이름은 2글자 이상 8글자 이하여야 합니다."
        private const val INVALID_PATTERN_MESSAGE = "사용자 이름은 한글, 영문, 숫자만 포함할 수 있습니다."
    }

    init {
        require(value.length in MIN_LENGTH..MAX_LENGTH) { INVALID_LENGTH_MESSAGE }
        require(value.matches(VALID_PATTERN)) { INVALID_PATTERN_MESSAGE }
    }

    fun length(): Int = value.length

    override fun toString(): String = value
}
