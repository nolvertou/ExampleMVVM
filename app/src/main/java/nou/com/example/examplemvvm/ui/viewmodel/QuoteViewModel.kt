package nou.com.example.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nou.com.example.examplemvvm.data.model.QuoteModel
import nou.com.example.examplemvvm.data.model.QuoteProvider
import nou.com.example.examplemvvm.domain.GetQuotesUseCase
import nou.com.example.examplemvvm.domain.GetRandomQuoteUseCase

class QuoteViewModel: ViewModel() {

    // We're encapculating QuoteModel in a MutableLiveData because the value changes
    // with the randomQuote function
    val quoteModel = MutableLiveData<QuoteModel>()
    // TODO (22) Create a MutableLiveData for the progressBar
    val isLoading = MutableLiveData<Boolean>()

    // TODO (19): Create getQuotesUseCase
    var getQuotesUseCase = GetQuotesUseCase()

    // TODO (29): Create GetRandomQuoteUseCase
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    // TODO (18): Add onCreate function
    fun onCreate() {
        // Notes
        // How should I call a suspend function inside a function?
        // Answer: We should use viewModelScope.launch  to run coroutines
        // TODO (19): Run a coroutine to get the Quote Lists
        viewModelScope.launch {
            // TODO (24): Displaying the progressBar by default
            // Displaying the progressBar by default using isLoading
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                // Getting the first element of the response list
                quoteModel.postValue(result[0])

                // TODO (25): Hiding the progressBar once we get the result
                // Hiding the progressBar using isLoading
                isLoading.postValue(false)
            }
        }
    }

    /**
     * When the user press the screen, its going to call a setOnClickListener,
     * and we are going to call the ViewModel from the activity, and we'll tell it that
     * we have clicked the screen and give a randomQuote
      */
    fun randomQuote(){
        // TODO (26): Displaying the progressBar by default
        // Displaying the progressBar while we are calculating the random Quote to display
        isLoading.postValue(true)

        // TODO (29): Getting the random Quote and displaying it
        val quote = getRandomQuoteUseCase()
        if(quote != null) {
            quoteModel.postValue(quote)
        }

        // TODO (27): Hiding the progressBar once we get the result
        // Hiding the progressBar once we get the random Quote to display
        isLoading.postValue(false)
    }


}