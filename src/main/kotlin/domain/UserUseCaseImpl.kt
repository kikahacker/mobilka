package org.example.domain

import org.example.data.UserRepository
import org.example.domain.request.AuthorizeRequest
import org.example.domain.request.RegistrationRequest
import org.example.domain.response.UserResponse
import org.example.domein.Request.ChangePasswordRequest
import org.example.domein.Request.ChangeProfileRequest

class UserUseCaseImpl(private val userRepository: UserRepository): UserUseCase {
    override fun authorize(authorizeRequest: AuthorizeRequest): UserResponse {
        val findUser = userRepository.getAllUsers()
            .firstOrNull {
                it.email == authorizeRequest.email
            }
        checkNotNull(findUser){
            "Пользователь с такой почтой не найден"
        }
        require(findUser.password == authorizeRequest.password){
            "Пароли не совпадают"
        }
        return UserDtoToUserResponse(findUser)
    }

    override fun registration(registrationRequest: RegistrationRequest): UserResponse {
        //уникальность почты
        val isUnique = userRepository.getAllUsers().firstOrNull{
            it.email == registrationRequest.email
        } == null
        require(isUnique){
            "Такая почта уже существует"
        }
        val newUser = userRepository.addUser(registrationRequest)
        return UserDtoToUserResponse(newUser)
    }



    override fun changePassword(changePasswordRequest: ChangePasswordRequest){
        var updatedUser = userRepository.findUsersById(changePasswordRequest.Id)
        updatedUser.password = changePasswordRequest.newPassword
        userRepository.updateUserById(changePasswordRequest.Id,updatedUser)
    }

    override fun changeProfile(changeProfileRequest: ChangeProfileRequest) {
        var updateProfile = userRepository.findUsersById(changeProfileRequest.Id)
        if (!changeProfileRequest.newFirstName.isNullOrEmpty()) updateProfile.firstName = changeProfileRequest.newFirstName
        if (!changeProfileRequest.newLastName.isNullOrEmpty()) updateProfile.lastName =changeProfileRequest.newLastName
        if (!changeProfileRequest.newEmail.isNullOrEmpty()) updateProfile.email = changeProfileRequest.newEmail
        if (!changeProfileRequest.newPhone.isNullOrEmpty()) updateProfile.phone = changeProfileRequest.newPhone
        if (!changeProfileRequest.newAddress.isNullOrEmpty()) updateProfile.address =changeProfileRequest.newAddress

        userRepository.updateUserById(changeProfileRequest.Id,updateProfile)

    }
}