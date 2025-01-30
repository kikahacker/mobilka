package org.example.ui

import org.example.domain.response.UserResponse
import java.awt.MenuItem

class MainMenuUI (private val userUI: UserUI){
    val menuStartItems = listOf(
        "1. Авторизоваться",
        "2. Зарегестрироваться",
        "3.EXIT"
    )
    val menuItems = listOf(
        "1.Сменить пароль",
        "2.Изменить профиль",
        "3.EXIT"
    )
    private fun displayMenuItem(menuItem: ()-> Unit){
        try {
            menuItem()
        }catch (e:Exception){
            println(e.message)
            userUI.userauto?.let{
                displayMenuForAuthorizeUser()
            }

        }
    }
    fun displayStartMenu() {
        println(menuStartItems.joinToString  ("\n") )
        val menuPosition = readlnOrNull()?.toIntOrNull()
        if (menuPosition == null) displayStartMenu()
        when (menuPosition) {
            1 -> {
                displayMenuItem {
                    userUI.authorize()
                    displayMenuForAuthorizeUser()
                }
            }

            2 -> {
                displayMenuItem{
                    userUI.registration()
                    displayStartMenu()
                }
            }
            3->{
                return
            }
            else->{
                displayStartMenu()
            }

        }
    }
    fun displayMenuForAuthorizeUser(){
        println(menuItems.joinToString ("\n"))
        val menuPosition = readlnOrNull()?.toIntOrNull()
        if (menuPosition == null) displayMenuForAuthorizeUser()
        when(menuPosition){
            1->{
                displayMenuItem{
                    userUI.changePassword()
                    displayMenuForAuthorizeUser()
                }
            }
            2->{
                displayMenuItem{
                    userUI.changeProfile()
                    displayMenuForAuthorizeUser()
                }
            }
            3->{
                return
            }
            else->{
                displayMenuForAuthorizeUser()
            }
        }
    }
}