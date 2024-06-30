package com.waterfogsw.modoorpg.user.domain.account.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec

@DisplayName("[VO] Password")
class PasswordTest : DescribeSpec({

    describe("생성자") {
        context("올바른 형식의 비밀번호로 객체를 생성할 때") {
            it("예외가 발생하지 않아야 한다") {
                // Arrange
                val validPassword = "Valid1Password!"

                // Act & Assert
                shouldNotThrowAny { Password(validPassword) }
            }
        }

        context("길이가 8자 미만인 비밀번호로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val shortPassword = "Short1!"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Password(shortPassword)
                }
            }
        }

        context("길이가 20자를 초과하는 비밀번호로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val longPassword = "ThisPasswordIsTooLong1!"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Password(longPassword)
                }
            }
        }

        context("숫자가 포함되지 않은 비밀번호로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val noNumberPassword = "NoNumberPassword!"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Password(noNumberPassword)
                }
            }
        }

        context("소문자가 포함되지 않은 비밀번호로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val noLowerCasePassword = "NOLOWERCASE1!"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Password(noLowerCasePassword)
                }
            }
        }

        context("대문자가 포함되지 않은 비밀번호로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val noUpperCasePassword = "nouppercase1!"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Password(noUpperCasePassword)
                }
            }
        }

        context("특수문자가 포함되지 않은 비밀번호로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val noSpecialCharPassword = "NoSpecialChar1"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Password(noSpecialCharPassword)
                }
            }
        }
    }
})
