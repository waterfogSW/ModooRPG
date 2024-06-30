package com.waterfogsw.modoorpg.user.domain.account.vo

object PasswordFixture {

    fun Password.Companion.fixture(value: String = "Test1234!@#"): Password {
        return Password(value)
    }

}
