package com.waterfogsw.modoorpg.user.domain.account.vo

object EmailFixture {

    fun Email.Companion.fixture(email:String = "test@test.com"): Email {
        return Email(email)
    }
}
