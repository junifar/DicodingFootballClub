package com.rubahapi.footballclub.main

import com.google.gson.Gson
import com.rubahapi.footballclub.TestContextProvider
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.League
import com.rubahapi.footballclub.model.LeagueResponse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LeaguePresenterTest {

    @Mock
    private lateinit var view: MainView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    private lateinit var presenter: LeaguePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LeaguePresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun getLeagueList() {
        val leagues: MutableList<League> = mutableListOf()
        val leagueResponse = LeagueResponse(leagues)

        `when`(gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeagues()), LeagueResponse::class.java))
            .thenReturn(leagueResponse)

        presenter.getLeagueList()

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showLeagueListView(leagues)
        Mockito.verify(view).hideLoading()
    }
}