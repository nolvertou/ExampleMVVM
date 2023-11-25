package nou.com.example.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nou.com.example.examplemvvm.model.QuoteModel
import nou.com.example.examplemvvm.model.QuoteProvider

// TODO (8): Create a ViewModel
class QuoteViewModel: ViewModel() {

   // TODO (8.1) Create a  MutableLiveData of quoteModel
   // We're encapculating QuoteModel in a MutableLiveData because the value changes
   // with the randomQuote function
   val quoteModel = MutableLiveData<QuoteModel>()

   // TODO (8.2) Create a randomQuote function to get a quote randomly
    /**
     * When the user press the screen, its going to call a setOnClickListener,
     * and we are going to call the VIewModel from the activity, and we'll tell it,
     * we have clicked the screen and give a randomQuote
      */
   fun randomQuote(){
       val currentQuote = QuoteProvider.random()
       quoteModel.postValue(currentQuote)
   }
}