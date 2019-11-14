package com.example.rentbike.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rentbike.RxSchedulersOverrideRule
import com.example.rentbike.core.functional.Resource
import com.example.rentbike.core.functional.ResourceState
import com.example.rentbike.domain.usecase.GetGeoBikeStations
import com.example.rentbike.geoBikeStation
import com.example.rentbike.presentation.bikestationlist.BikeStationsViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class BikeStationsListViewModelTest {

    @Rule
    @JvmField
    val rxSchedulersOverrideRule = RxSchedulersOverrideRule()

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BikeStationsViewModel

    private val mockGetGeobikeStations: GetGeoBikeStations = mock()

    val geoBikeStations = listOf(geoBikeStation)

    @Before
    fun setUp() {
        viewModel = BikeStationsViewModel(mockGetGeobikeStations)
    }

    @Test
    fun `get bike stations succeeds`() {
        // given
        whenever(mockGetGeobikeStations.get())
            .thenReturn(Single.just(geoBikeStations))

        // when
        viewModel.fetchBikeStations()

        // then
        verify(mockGetGeobikeStations).get()
        assertEquals(
            Resource(
                state = ResourceState.SUCCESS,
                data = geoBikeStations,
                message = null
            ), viewModel.bikeStations.value
        )

    }

    @Test
    fun `get bike stations fails`() {
        // given
        val throwable = Throwable()
        whenever(mockGetGeobikeStations.get()).thenReturn(Single.error(throwable))

        // when
        viewModel.fetchBikeStations()

        // then
        verify(mockGetGeobikeStations).get()
        assertEquals(
            Resource(state = ResourceState.ERROR, data = null, message = throwable.message),
            viewModel.bikeStations.value
        )
    }
}