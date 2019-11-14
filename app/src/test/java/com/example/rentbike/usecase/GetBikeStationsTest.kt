package com.example.rentbike.usecase

import com.example.rentbike.bikeStation
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.BikeStationRepository
import com.example.rentbike.domain.usecase.GetBikeStations
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.util.*

class GetBikeStationsTest {

    private lateinit var getBikeStation: GetBikeStations

    private val bikeStationRepository: BikeStationRepository = mock()

    val bikeList = listOf(bikeStation)

    @Before
    fun setUp() {
        getBikeStation = GetBikeStations(bikeStationRepository)
    }

    @Test
    fun `repository get success`() {
        //given
        whenever(bikeStationRepository.getBikeStations()).thenReturn(Single.just(bikeList))

        // when
        val test = getBikeStation.get().test()

        // then
        verify(bikeStationRepository).getBikeStations()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(bikeList)
    }


    @Test
    fun `repository get fail`() {
        // given
        val throwable = Throwable()
        whenever(bikeStationRepository.getBikeStations()).thenReturn(Single.error(throwable))

        // when
        val test = getBikeStation.get().test()

        // then
        verify(bikeStationRepository).getBikeStations()

        test.assertNoValues()
        test.assertNotComplete()
        test.assertError(throwable)
        test.assertValueCount(0)

    }

}