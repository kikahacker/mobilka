package org.example

import com.sun.tools.javac.Main
import org.example.data.UserRepository
import org.example.data.UserRepositoryImpl
import org.example.domain.UserUseCaseImpl
import org.example.ui.MainMenuUI
import org.example.ui.UserUI

fun main() {
    val userRepository = UserRepositoryImpl()
    val userUseCase = UserUseCaseImpl(userRepository)
    val userUI = UserUI(userUseCase)
    val mainMenuUI=MainMenuUI(userUI)
    mainMenuUI.displayStartMenu()
}