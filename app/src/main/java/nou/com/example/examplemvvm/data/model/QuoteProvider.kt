package nou.com.example.examplemvvm.data.model

// TODO (15):
//    15.1. Remove quote List and random function
//    15.2  Create quotes list and declered as emptyList
class QuoteProvider{

    // Notes:
    //      Companion Object is like a Static Object
    //      So, everyone can access into it
    companion object{
        var quotes: List<QuoteModel> = emptyList()
    }
}