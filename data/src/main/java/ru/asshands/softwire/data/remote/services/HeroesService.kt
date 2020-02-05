package ru.asshands.softwire.data.remote.services

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import ru.asshands.softwire.data.remote.models.HeroApi

interface HeroesService {


    @GET("/api/heroes")
    fun getHeroes(): Deferred<List<HeroApi>>
}