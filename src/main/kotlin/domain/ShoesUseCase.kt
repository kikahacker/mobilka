package org.example.domain

import org.example.domain.request.ShoesAddRequest
import org.example.domain.response.ShoesResponse

interface ShoesUseCase {
    fun addShoes(shoesAddRequest: ShoesAddRequest):ShoesResponse
    fun removeShoes(shoesID:Int):ShoesResponse
    fun returnAllShoes()
    fun returnShoes(shoesID: Int)
}