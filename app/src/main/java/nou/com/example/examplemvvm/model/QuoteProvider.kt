package nou.com.example.examplemvvm.model

// TODO (7): Create QuoteProvider class that contains a companion object with:
//      7.1 A private quote list
//      7.2 A public function that returns a random quote
class QuoteProvider{

    // Notes:
    //      Companion Object is like a Static Object
    //      So, everyone can access into it
    companion object{
        private val quote = listOf<QuoteModel>(
            QuoteModel("Example 1 ", "Author 1"),
            QuoteModel("Example 2 ", "Author 2"),
            QuoteModel("Example 3 ", "Author 3"),
            QuoteModel("Example 4 ", "Author 4"),
            QuoteModel("Example 5 ", "Author 5"),
            QuoteModel("Example 6 ", "Author 6"),
            QuoteModel("Example 7 ", "Author 7"),
            QuoteModel("Example 8 ", "Author 8"),
            QuoteModel("Example 9 ", "Author 9"),
            QuoteModel("Example 10 ", "Author 10")
        )

        /**
         * Returns a random QuoteModel
         */
        fun random(): QuoteModel{
            val position = (0..9).random()
            return quote[position]
        }
    }
}