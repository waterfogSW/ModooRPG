package com.waterfogsw.modoorpg.user.domain.account.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

@DisplayName("[VO] Email")
class EmailTest : DescribeSpec({

    describe("Email 객체 생성") {
        context("유효한 이메일 주소로 객체를 생성할 때") {
            it("toString 메서드는 원본 이메일 문자열을 반환해야 한다") {
                // Arrange
                val emailString = "test@example.com"

                // Act
                val email = Email(emailString)

                // Assert
                email.toString() shouldBe emailString
            }
        }

        context("잘못된 형식의 이메일 주소로 객체를 생성하려 할 때") {
            it("IllegalArgumentException을 발생시켜야 한다") {
                val invalidEmails = listOf("invalid-email", "missing@tld", "@missinglocal.com")

                invalidEmails.forEach { invalidEmail ->
                    // Arrange
                    val emailString = invalidEmail

                    // Act & Assert
                    shouldThrow<IllegalArgumentException> {
                        Email(emailString)
                    }
                }
            }
        }

        context("이메일 주소의 로컬 파트 길이 제한 검증 시") {
            it("로컬 파트가 64자일 때 객체 생성에 성공해야 한다") {
                // Arrange
                val localPart = "a".repeat(64)
                val emailString = "$localPart@example.com"

                // Act
                val email = Email(emailString)

                // Assert
                email.toString() shouldBe emailString
            }

            it("로컬 파트가 65자일 때 IllegalArgumentException을 발생시켜야 한다") {
                // Arrange
                val localPart = "a".repeat(65)
                val emailString = "$localPart@example.com"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Email(emailString)
                }
            }
        }

        context("이메일 주소의 도메인 길이 제한 검증 시") {
            it("도메인이 255자일 때 객체 생성에 성공해야 한다") {
                // Arrange
                val dotCom = ".com"
                val domain = "a".repeat(255 - dotCom.length)
                val emailString = "test@$domain$dotCom"

                // Act
                val email = Email(emailString)

                // Assert
                email.toString() shouldBe emailString
            }

            it("도메인이 256자일 때 IllegalArgumentException을 발생시켜야 한다") {
                // Arrange
                val dotCom = ".com"
                val domain = "a".repeat(256 - dotCom.length)
                val emailString = "test@$domain$dotCom"

                // Act & Assert
                shouldThrow<IllegalArgumentException> {
                    Email(emailString)
                }
            }
        }
    }
})
