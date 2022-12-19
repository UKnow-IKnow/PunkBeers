package com.example.punkbeers.ui.BeerDiscover

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.punkbeers.PunkBeersApplication
import com.example.punkbeers.api.models.Beer
import com.example.punkbeers.repository.BeersRepository
import kotlinx.coroutines.launch

class BeerDiscoverViewModel(app:Application) : AndroidViewModel(app) {

    private val _discoverBeer = MutableLiveData<List<Beer>>()

    val discoverBeer: LiveData<List<Beer>> = _discoverBeer

//    init {
//        hasInternetConnection()
//    }

    fun makeAPICall() = viewModelScope.launch {

        BeersRepository.getDiscoverBeers().let {
            _discoverBeer.postValue(it.body())
        }
    }

//    private fun hasInternetConnection() : Boolean{
//        val connectivityManager = getApplication<PunkBeersApplication>().getSystemService(
//            Context.CONNECTIVITY_SERVICE
//        ) as ConnectivityManager
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            val activeNetwork = connectivityManager.activeNetwork ?: return false
//            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
//            return when {
//                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//                else -> false
//            }
//        }else {
//            connectivityManager.activeNetworkInfo ?.run {
//                return when(type) {
//                    ConnectivityManager.TYPE_WIFI -> true
//                    ConnectivityManager.TYPE_MOBILE -> true
//                    ConnectivityManager.TYPE_ETHERNET -> true
//                    else -> false
//                }
//            }
//        }
//        return false
//    }

}
