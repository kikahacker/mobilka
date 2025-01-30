package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.request.ShoesAddRequest

interface ShoesRepository {
    fun addShoes(shoesAddRequest: ShoesAddRequest):ShoesDTO
    fun getAllShoes():List<ShoesDTO>
    fun removeShoes(shoesID:Int):Boolean

}
