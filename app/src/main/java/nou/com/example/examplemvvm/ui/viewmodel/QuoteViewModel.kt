package nou.com.example.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nou.com.example.examplemvvm.model.QuoteModel
import nou.com.example.examplemvvm.model.QuoteProvider

class QuoteViewModel: ViewModel() {

   // We're encapculating QuoteModel in a MutableLiveData because the value changes
   // with the randomQuote function
   val quoteModel = MutableLiveData<QuoteModel>()

    /**
     * When the user press the screen, its going to call a setOnClickListener,
     * and we are going to call the ViewModel from the activity, and we'll tell it that
     * we have clicked the screen and give a randomQuote
      */
   fun randomQuote(){
       val currentQuote = QuoteProvider.random()
       quoteModel.postValue(currentQuote)
   }
}