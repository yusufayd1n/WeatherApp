package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.ModelWeather
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {

    private val APIService=com.example.weatherapp.service.APIService()

    private val disposable=CompositeDisposable()

    val weatherData=MutableLiveData<ModelWeather>()
    val weatherError=MutableLiveData<Boolean>()
    val weatherLoading=MutableLiveData<Boolean>()

    fun refresh(cityName: String){
        getDataFromAPI(cityName)
        //getDataFromLocal()
    }

    private fun getDataFromAPI(cityName:String) {

        weatherLoading.value=true
        disposable.add(
            APIService.getDataService(cityName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<ModelWeather>(){
                    override fun onSuccess(t: ModelWeather) {
                        weatherData.value=t
                        weatherError.value=false
                        weatherLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        weatherError.value=true
                        weatherLoading.value=false
                    }

                })
        )
    }
}