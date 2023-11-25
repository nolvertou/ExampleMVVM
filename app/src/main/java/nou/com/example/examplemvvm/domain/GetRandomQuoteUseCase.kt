package nou.com.example.examplemvvm.domain

import nou.com.example.examplemvvm.data.model.QuoteModel
import nou.com.example.examplemvvm.data.model.QuoteProvider
import nou.com.example.examplemvvm.data.model.QuoteRepository

// TODO (28): Create GetRandomQuoteUseCase
class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    // 28.1 Creating invoke function that returns a random Quote data
    // Note: In this case we are not using a coroutine because we currently have the value in the memory
    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){

            // 28.2 Randomizing a number between the 0 and quotes list size
//            val randomNumber = (0..quotes.size-1)
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}