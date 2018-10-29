package com.example.luisenriquez.mockdatavasev2.network.models.data


class Question {
    data class Response(val status:String,
                                val data:List<RespData>
    ) {

        data class RespData(val title: String,
                                    val category_name:String,
                                    val answer: String,
                                    val vendor_name:String,
                                    val contributor_name:String,
                                    val tags:List<String>
        )
    }
}


