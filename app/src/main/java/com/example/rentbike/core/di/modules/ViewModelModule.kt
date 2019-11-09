package com.example.rentbike.core.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentbike.core.di.viewmodel.ViewModelFactory
import com.example.rentbike.core.di.viewmodel.ViewModelKey
import com.example.rentbike.presentation.bikestationlist.BikeStationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BikeStationsViewModel::class)
    abstract fun bindsMoviesViewModel(bikeStationsViewModel:BikeStationsViewModel): ViewModel

}