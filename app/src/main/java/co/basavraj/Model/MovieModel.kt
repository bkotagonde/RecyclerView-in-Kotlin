package co.basavraj.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class MovieModel(
        @SerializedName("title")
        @Expose
        var title: String? = null,
        @SerializedName("image")
        @Expose
        var image: String? = null,
        @SerializedName("rating")
        @Expose
        var rating: Double? = null,
        @SerializedName("releaseYear")
        @Expose
        var releaseYear: Int? = null,
        @SerializedName("genre")
        @Expose
        var genre: List<String>? = null)
