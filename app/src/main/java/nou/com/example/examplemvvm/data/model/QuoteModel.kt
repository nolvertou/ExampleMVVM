package nou.com.example.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

// TODO (12): If the fields are named different, we must use SerializedName
// An annotation that indicates this member should be serialized to JSON with the provided
// name value as its field name
data class QuoteModel(
    @SerializedName("quote")  val quote:String,
    @SerializedName("author") val author:String
)
