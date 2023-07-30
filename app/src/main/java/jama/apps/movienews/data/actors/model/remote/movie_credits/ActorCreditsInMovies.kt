package jama.apps.movienews.data.actors.model.remote.movie_credits

data class ActorCreditsInMovies(
    val cast: List<ActorCastInMovies>,
    val crew: List<CrewInMovies>,
    val id: Int
)