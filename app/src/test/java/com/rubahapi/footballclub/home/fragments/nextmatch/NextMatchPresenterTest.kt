package com.rubahapi.footballclub.home.fragments.nextmatch

import com.google.gson.Gson
import com.rubahapi.footballclub.TestContextProvider
import com.rubahapi.footballclub.api.ApiRepository
import com.rubahapi.footballclub.api.TheSportDBApi
import com.rubahapi.footballclub.model.NextMatch
import com.rubahapi.footballclub.model.NextMatchResponse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextMatchPresenterTest {

    @Mock
    private lateinit var view: NextMatchFragment

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    private lateinit var presenter: NextMatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view, apiRepository, gson, TestContextProvider())
    }


    @Test
    fun getNextMatchList() {
        val nextMatches: MutableList<NextMatch> = mutableListOf()
        val nextMatchResponse = NextMatchResponse(nextMatches)

        Mockito.`when`(gson.fromJson(apiRepository.doRequest(TheSportDBApi.getNextMatch(4328.toString())),
            NextMatchResponse::class.java)).thenReturn(nextMatchResponse)

        //get next match(4328)
        presenter.getNextMatchList(4328)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showNextMatchList(nextMatches)
        Mockito.verify(view).hideLoading()
    }
}