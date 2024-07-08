package com.waterfogsw.modoorpg.user.domain.account.repository

import com.waterfogsw.modoorpg.user.domain.account.entity.Account

interface AccountRepository {

    fun save(account: Account)
}
