package com.waterfogsw.modoorpg.user.application.account.service

import com.waterfogsw.modoorpg.user.application.account.port.inbound.AccountRegister
import com.waterfogsw.modoorpg.user.domain.account.entity.Account
import com.waterfogsw.modoorpg.user.domain.account.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
) : AccountRegister {

    override fun register(
        email: String,
        password: String,
        nickname: String
    ): Result<Unit> {
        return runCatching {
            Account.register(email, password, nickname)
        }.map {
            runCatching { accountRepository.save(it) }
        }.fold(
            onSuccess = { Result.success(Unit) },
            onFailure = { e -> Result.failure(e) }
        )
    }

}
