package nou.com.example.examplemvvm.data.model

import nou.com.example.examplemvvm.network.QuoteService

// TODO (14) Create QuoteRepository
class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}