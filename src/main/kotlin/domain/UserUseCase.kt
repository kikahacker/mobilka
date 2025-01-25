package org.example.domain

import org.example.domain.request.AuthorizeRequest
import org.example.domain.request.RegistrationRequest
import org.example.domain.response.UserResponse
import org.example.domein.Request.ChangePasswordRequest
import org.example.domein.Request.ChangeProfileRequest

interface UserUseCase {
    fun authorize(authorizeRequest: AuthorizeRequest): UserResponse
    fun registration(registrationRequest: RegistrationRequest): UserResponse
    fun changePassword(changePasswordRequest: ChangePasswordRequest)
    fun changeProfile(changeProfileRequest: ChangeProfileRequest)
}