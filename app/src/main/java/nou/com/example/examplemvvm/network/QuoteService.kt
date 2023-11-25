package nou.com.example.examplemvvm.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import nou.com.example.examplemvvm.core.RetrofitHelper
import nou.com.example.examplemvvm.data.model.QuoteModel
import retrofit2.Response

// TODO (13): This is going to check if we are going to get data
//  from Database(Room) or Internet (Retrofit)
class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{

        // TODO (13.1): Get the data from Internet using Retrofit and Coroutines
        // We are going to execute the request in the background using coroutines to process the
        // request into a secondary thread and avoid adding more responsibilities to the main thread,
        // and then well get a response
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> =
                retrofit.create(QuoteApiClient::class.java).getAllQuotes()

            // If the response is null, so this returns an emptyList
            response.body() ?: emptyList()
        }


    }
}