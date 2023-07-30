package jama.apps.movienews.data.movie_detail.model.remote.response

import com.google.gson.annotations.SerializedName
import jama.apps.movienews.data.movie_detail.model.remote.response.AuthorDetails

data class ReviewResult(
    @SerializedName("author")
    val author: String,
    @SerializedName("author_details")
    val authorDetails: AuthorDetails,
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
)