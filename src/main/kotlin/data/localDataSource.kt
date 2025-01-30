package org.example.data

import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO

val shoesList = listOf(
    ShoesDTO(
        shoesId = 1,
        shoesName = "1",
        shoesDescription = "123",
        shoesUrl = "3",
        category = "123"
    )
)

val userList = listOf(
    UserDTO(
        userId = 1,
        firstName = "Andrey",
        password = "123",
        email = "test@mail.ru"
        ),
    UserDTO(
        userId = 2,
        firstName = "Alexey",
        password = "321",
        email = "test2@mail.ru"
    ),
    UserDTO(
        userId = 3,
        firstName = "Oleg",
        password = "423",
        email = "test3@mail.ru",
    ),
)