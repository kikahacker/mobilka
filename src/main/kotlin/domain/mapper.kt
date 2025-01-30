package org.example.domain

import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO
import org.example.domain.response.ShoesResponse
import org.example.domain.response.UserResponse

fun UserDtoToUserResponse(userDTO: UserDTO) = UserResponse(
    lastName = userDTO.lastName,
    firstName = userDTO.firstName,
    email = userDTO.email,
    phone = userDTO.phone,
    userId = userDTO.userId,
    address = userDTO.address,
)
fun ShoesDtoToShoesResponse(shoesDTO: ShoesDTO) = ShoesResponse(
    shoesId = shoesDTO.shoesId,
    shoesName = shoesDTO.shoesName,
    shoesUrl = shoesDTO.shoesUrl,
    shoesDescription = shoesDTO.shoesDescription,
    category = shoesDTO.category
)