package com.iti.android_6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class SharedViewModel : ViewModel() {

    private val _backgroundColor: MutableLiveData<Int> = MutableLiveData()
    val backgroundColor: MutableLiveData<Int> = _backgroundColor


    fun getBackgroundColor() =
        viewModelScope.launch {
            setBackgroundColor()
        }


    private suspend fun setBackgroundColor() {
        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
        val currentTime = sdf.format(calendar.time)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        //        when (hour) {
//            in 1..6 -> _backgroundColor.postValue(R.drawable.morning_img)
//            in 6..12 -> _backgroundColor.postValue(R.drawable.sunset_img)
//            in 12..17 -> _backgroundColor.postValue(R.drawable.sunny_img)
//            in 17..21 -> _backgroundColor.postValue(R.drawable.sun_rise_img)
//            in 21..24 -> _backgroundColor.postValue(R.drawable.night_img)
//        }

        when (calendar.get(Calendar.SECOND)) {
            in 0..10 -> _backgroundColor.postValue(R.drawable.morning_img)
            in 10..20 -> _backgroundColor.postValue(R.drawable.sunset_img)
            in 20..30 -> _backgroundColor.postValue(R.drawable.sunny_img)
            in 30..45 -> _backgroundColor.postValue(R.drawable.sun_rise_img)
            in 45..59 -> _backgroundColor.postValue(R.drawable.night_img)
        }


    }


}