package org.example.domain

import org.example.data.ShoesRepository
import org.example.data.model.ShoesDTO
import org.example.data.shoesList
import org.example.domain.request.ShoesAddRequest
import org.example.domain.response.ShoesResponse

class ShoesUseCaseImpl(private val shoesRepository: ShoesRepository) :ShoesUseCase{
    val shoesSource = shoesList.toMutableList()
    override fun returnAllShoes(): List<ShoesResponse> {
        val allShoes = shoesRepository.getAllShoes().map {
            ShoesDtoToShoesResponse(it)
        }
        return allShoes
    }

    override fun addShoes(shoesAddRequest: ShoesAddRequest): ShoesResponse {

        val newShoes = ShoesDTO(
            shoesUrl = shoesAddRequest.shoesUrl,
            shoesName = shoesAddRequest.shoesName,
            shoesDescription = shoesAddRequest.shoesDescription,
            category = shoesAddRequest.category,
            shoesId = shoesSource.size+1
        )
        shoesSource.add(newShoes)
        return ShoesDtoToShoesResponse(newShoes)
    }

    override fun removeShoes(shoesID: Int): Boolean {
        return shoesSource.removeIf{it.shoesId == shoesID}
    }

    override fun returnShoes(shoesID: Int): ShoesResponse {
        val findShoes = shoesRepository.getAllShoes().find { it.shoesId==shoesID }
        checkNotNull(findShoes)
        return ShoesDtoToShoesResponse(findShoes)
    }
}