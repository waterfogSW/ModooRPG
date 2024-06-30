package com.waterfogsw.modoorpg.user.domain.account.vo

import com.waterfogsw.modoorpg.user.domain.account.vo.PasswordFixture.fixture
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName

@DisplayName("[VO] HashedPassword")
class HashedPasswordTest : DescribeSpec({

    describe("hash") {
        context("동일한 비밀번호로 해싱할 때") {
            it("항상 같은 해시값을 반환해야 한다") {
                // Arrange
                val password: Password = Password.fixture()

                // Act
                val hashedPassword1: HashedPassword = HashedPassword.hash(password)
                val hashedPassword2: HashedPassword = HashedPassword.hash(password)

                // Assert
                hashedPassword1 shouldBe hashedPassword2
            }
        }

        context("서로 다른 비밀번호로 해싱할 때") {
            it("다른 해시값을 반환해야 한다") {
                // Arrange
                val password1: Password = Password.fixture()
                val password2: Password = Password.fixture("anotherPassword456@")

                // Act
                val hashedPassword1: HashedPassword = HashedPassword.hash(password1)
                val hashedPassword2: HashedPassword = HashedPassword.hash(password2)

                // Assert
                hashedPassword1 shouldNotBe hashedPassword2
            }
        }
    }

    describe("verify") {
        context("올바른 비밀번호로 검증할 때") {
            it("검증에 성공해야 한다") {
                // Arrange
                val password: Password = Password.fixture()
                val hashedPassword: HashedPassword = HashedPassword.hash(password)

                // Act & Assert
                hashedPassword.verify(password) shouldBe true
            }
        }

        context("잘못된 비밀번호로 검증할 때") {
            it("검증에 실패해야 한다") {
                // Arrange
                val correctPassword: Password = Password.fixture()
                val wrongPassword: Password = Password("wrongPassword456@")
                val hashedPassword: HashedPassword = HashedPassword.hash(correctPassword)

                // Act & Assert
                hashedPassword.verify(wrongPassword) shouldBe false
            }
        }
    }

    describe("toString") {
        context("해시된 비밀번호를 문자열로 변환할 때") {
            it("64자의 16진수 문자열을 반환해야 한다") {
                // Arrange
                val password: Password = Password.fixture()
                val hashedPassword: HashedPassword = HashedPassword.hash(password)

                // Act
                val result: String = hashedPassword.toString()

                // Assert
                result.length shouldBe 64
                result.all { it in '0'..'9' || it in 'a'..'f' } shouldBe true
            }

            it("원본 비밀번호와 다른 문자열을 반환해야 한다") {
                // Arrange
                val password: Password = Password.fixture()
                val hashedPassword: HashedPassword = HashedPassword.hash(password)

                // Act
                val result: String = hashedPassword.toString()

                // Assert
                result shouldNotBe password.toString()
            }
        }
    }

    describe("생성자") {
        context("올바른 형식의 해시 문자열로 객체를 생성할 때") {
            it("예외가 발생하지 않아야 한다") {
                // Arrange
                val validHash = "a".repeat(64)

                // Act & Assert
                shouldNotThrowAny { HashedPassword(validHash) }
            }
        }

        context("잘못된 형식의 문자열로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    HashedPassword("이것은 올바른 해시가 아닙니다")
                }
            }
        }

        context("길이가 64가 아닌 문자열로 객체를 생성할 때") {
            it("예외가 발생해야 한다") {
                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    HashedPassword("a".repeat(63))  // 63자
                }
                shouldThrow<IllegalArgumentException> {
                    HashedPassword("a".repeat(65))  // 65자
                }
            }
        }
    }
})
