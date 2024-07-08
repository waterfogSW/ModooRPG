package com.waterfogsw.modoorpg.user.application.account.port.inbound

interface AccountRegister {

    fun register(
        email: String,
        password: String,
        nickname: String
    ): Result<Unit>

}
