package jama.apps.movienews.data.actors.model.remote

import com.google.gson.annotations.SerializedName

data class ActorsResponse(
    @SerializedName("results")
    var results: List<ActorsResult> ?= null,
)