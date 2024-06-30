package com.waterfogsw.modoorpg.user.domain.account.entity

import com.waterfogsw.modoorpg.user.domain.account.vo.Email
import com.waterfogsw.modoorpg.user.domain.account.vo.EmailFixture.fixture
import com.waterfogsw.modoorpg.user.domain.account.vo.Password
import com.waterfogsw.modoorpg.user.domain.account.vo.PasswordFixture.fixture
import com.waterfogsw.modoorpg.user.domain.account.vo.Username
import com.waterfogsw.modoorpg.user.domain.account.vo.UsernameFixture.fixture
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

@DisplayName("[Domain] Account")
class AccountTest : DescribeSpec({

    describe("register") {
        it("새로운 계정을 생성한다") {
            // Arrange
            val email = Email.fixture().toString()
            val password = Password.fixture().toString()
            val username = Username.fixture().toString()

            // Act
            val account = Account.register(email, password, username)

            // Assert
            account.email.toString() shouldBe email
            account.password.toString() shouldBe Password(password).hash().toString()
            account.username.toString() shouldBe username
        }
    }

})
