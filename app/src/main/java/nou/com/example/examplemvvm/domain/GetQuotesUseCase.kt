package nou.com.example.examplemvvm.domain

import nou.com.example.examplemvvm.data.model.QuoteModel
import nou.com.example.examplemvvm.data.model.QuoteRepository

// TODO (16) Create GetQuotesUseCase
class GetQuotesUseCase {
    // 16.1
    private val repository = QuoteRepository()

    // 16.2
    // This functions runs automatically when it is called an object of GetQuotesUseCase class
    // eg.
    // val getQuotesUseCase = GetQuotesUseCase()
    // getQuotesUseCase()   <--- Tis executes the logic inside "suspend operator fun invoke"
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}