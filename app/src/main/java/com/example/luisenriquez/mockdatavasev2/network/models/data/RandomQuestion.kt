package com.example.luisenriquez.mockdatavasev2.network.models.data


class RandomQuestion {
    data class Response(val status:String,
                                      val data:List<RespData>) {

        data class RespData(val q_id:String,
                                      val title:String,
                                      val ans_id:String,
                                      val answer:String,
                                      val random_answers: RandomAnswer) {
            data class RandomAnswer(val uuid:String,
                                    val answer: String)
        }


    }
}

