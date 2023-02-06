package com.example.ageinminutes

import androidx.lifecycle.ViewModel


class DataViewModel : ViewModel() {
    var notClicked : Boolean = false
    var date : String = ""
    var ageMin : Long = 0
//    get() = ageMin
//    set(value) = updateMin(value)
//
//    private fun updateMin( minute : Long) {
//        ageMin = minute
//    }

    var ageHours : Long =0
//    get() = ageHours
//    set(value) = updateHour(value)

//    private fun updateHour(hours : Long) {
//        ageHours = hours
//    }

}