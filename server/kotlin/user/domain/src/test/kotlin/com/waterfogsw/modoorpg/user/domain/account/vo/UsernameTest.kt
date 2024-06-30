package com.waterfogsw.modoorpg.user.domain.account.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.core.annotation.DisplayName

@DisplayName("[VO] Username")
class UsernameTest : DescribeSpec({

    describe("생성자") {
        context("올바른 형식의 사용자 이름으로 객체를 생성할 때") {
            it("예외가 발생하지 않아야 한다") {
                // Arrange
                val validUsernames = listOf("홍길동", "Hong", "길동123", "User8")

                // Act & Assert
                validUsernames.forEach { username ->
                    shouldNotThrowAny { Username(username) }
                }
            }
        }

        context("길이가 2글자 미만인 사용자 이름으로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val shortUsername = "홍"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Username(shortUsername)
                }
            }
        }

        context("길이가 8글자를 초과하는 사용자 이름으로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val longUsername = "a".repeat(9)

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Username(longUsername)
                }
            }
        }

        context("한글, 영문, 숫자 이외의 문자가 포함된 사용자 이름으로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Arrange
                val invalidUsernames = listOf("User@", "홍길동!", "Hong_Gil", "길동-123")

                // Act & Assert
                invalidUsernames.forEach { username ->
                    shouldThrow<IllegalArgumentException> {
                        Username(username)
                    }
                }
            }
        }
    }

    describe("length") {
        it("사용자 이름의 길이를 정확히 반환해야 한다") {
            // Arrange
            val usernames = listOf("홍길동" to 3, "User" to 4, "길동123" to 5)

            usernames.forEach { (usernameString, expectedLength) ->
                // Act
                val username = Username(usernameString)
                val result = username.length()

                // Assert
                result shouldBe expectedLength
            }
        }
    }

    describe("toString") {
        it("원래 사용자 이름 문자열을 반환해야 한다") {
            // Arrange
            val usernameString = "홍길동"
            val username = Username(usernameString)

            // Act
            val result = username.toString()

            // Assert
            result shouldBe usernameString
        }
    }
})
