package org.example.ui

import org.example.domain.UserUseCase
import org.example.domain.request.AuthorizeRequest
import org.example.domain.request.RegistrationRequest
import org.example.domain.response.UserResponse
import org.example.domein.Request.ChangePasswordRequest
import org.example.domein.Request.ChangeProfileRequest

class UserUI(private val userUseCase: UserUseCase) {
    var userauto: UserResponse?  = null
    fun authorize(){
        println("Введите почту")
        val email = readlnOrNull()
        checkNotNull(email){
            "Почта не должна отсутствовать"
        }
        println("Введите пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Пароль не должен отсутствовать"
        }
        val authorizeRequest = AuthorizeRequest(
            email = email,
            password = password,)
        val user = userUseCase.authorize(authorizeRequest)
        println(userResponseToString(user))
        userauto = user
    }

    fun registration(){
        println("Введите имя")
        val firstName = readlnOrNull()
        checkNotNull(firstName){
            "Имя не должно отсутствовать"
        }
        println("Введите почту")
        val email = readlnOrNull()
        checkNotNull(email){
            "Почта не должна отсутствовать"
        }
        println("Введите пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Пароль не должен отсутствовать"
        }
        val registrationRequest = RegistrationRequest(
            email = email,
            firstName = firstName,
            password = password
        )
        val newUser = userUseCase.registration(registrationRequest)
        userResponseToString(newUser)
    }

    private fun userResponseToString(userResponse: UserResponse): String{
        val printOutput = StringBuilder()
        printOutput.append("Ваша почта ${userResponse.email}")
        printOutput.appendLine()
        printOutput.append("Ваше имя ${userResponse.firstName}")
        if (!userResponse.lastName.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append("Ваше фамилия ${userResponse.lastName}")
        }
        if (!userResponse.phone.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append("Ваш телефон ${userResponse.phone}")
        }
        if (!userResponse.address.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append("Ваш адрес ${userResponse.phone}")
        }
        return printOutput.toString()
    }
    fun changePassword(){
        checkNotNull(userauto) {
            "нет авторизации"
        }
        println("Введите ваш пароль")
        val password = readlnOrNull()
        checkNotNull(password){
            "Параоль не должен отсутствовать"
        }
        val changePasswordRequest = ChangePasswordRequest(
            Id = userauto!!.userId,
            newPassword = password
        )
        userUseCase.changePassword(changePasswordRequest)
    }
    fun changeProfile(){
        checkNotNull(userauto){
            "нет авторизации"
        }
        println("Введите ваше имя")
        val firstName = readlnOrNull()

        println("Введите вашe фамилию")
        val lastName = readlnOrNull()

        println("Введите ваш email")
        val email = readlnOrNull()

        println("Введите ваш телефон")
        val phone = readlnOrNull()

        println("Введите ваш адресс")
        val address = readlnOrNull()
        val changeProfileRequest = ChangeProfileRequest(
            Id = userauto!!.userId,
            newFirstName = firstName,
            newLastName = lastName,
            newEmail = email,
            newPhone = phone,
            newAddress = address
        )
    }
}