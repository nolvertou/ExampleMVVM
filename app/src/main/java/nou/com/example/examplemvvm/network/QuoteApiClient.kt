package nou.com.example.examplemvvm.network

import nou.com.example.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

// TODO (12): Create QuoteApiClient to get data from BASE_URL/.json
interface QuoteApiClient {
    @GET("/.json")
    // Note: suspend is used because we're going to use coroutines
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}