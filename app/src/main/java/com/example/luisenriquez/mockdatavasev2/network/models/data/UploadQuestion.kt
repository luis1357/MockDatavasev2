package com.example.luisenriquez.mockdatavasev2.network.models.data


class UploadQuestion {
    data class Data(val data:List<UploadData>) {
        data class UploadData(val category: String,
                              val title:String,
                              val answer:String,
                              val contributor:String,
                              val vendor:String,
                              val tags:List<String>)
    }

    data class Response(val status:String,
                        val message:String)
}


