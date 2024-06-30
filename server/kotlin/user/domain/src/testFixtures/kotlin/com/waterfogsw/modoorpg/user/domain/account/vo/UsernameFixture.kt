package com.waterfogsw.modoorpg.user.domain.account.vo

object UsernameFixture {

    fun Username.Companion.fixture(username: String = "test"): Username {
        return Username(username)
    }
}
