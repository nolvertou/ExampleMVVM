package nou.com.example.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import nou.com.example.examplemvvm.databinding.ActivityMainBinding
import nou.com.example.examplemvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Create a QuoteViewModel
    // "by viewModels" is going to do all the connections between viewModel and activity,
    // this is achieved using the activity library already implemented
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // It observes a change in the quote and author and display it to the view
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        // Call the function randomQuote of quoteViewModel to get a randomized quote
        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}