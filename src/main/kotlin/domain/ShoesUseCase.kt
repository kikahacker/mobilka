package org.example.domain

import org.example.data.model.ShoesDTO
import org.example.domain.request.ShoesAddRequest
import org.example.domain.response.ShoesResponse

interface ShoesUseCase {
    fun addShoes(shoesAddRequest: ShoesAddRequest):ShoesResponse
    fun removeShoes(shoesID:Int):Boolean
    fun returnAllShoes():List<ShoesResponse>
    fun returnShoes(shoesID: Int):ShoesResponse
}