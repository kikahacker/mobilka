package org.example.domain.request

import jdk.jfr.Description

data class ShoesAddRequest (
    val shoesName:String,
    val shoesUrl:String,
    val shoesDescription: String,
    val category: String
    )

