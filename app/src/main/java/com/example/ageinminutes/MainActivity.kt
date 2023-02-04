package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val btnDatePicker: View? = findViewById(R.id.btnDatePicker)
        if (binding.btnDatePicker != null) {
            binding.btnDatePicker.setOnClickListener {
               clickDatePicker(view = View())
                  }
        }
    }

    private fun View() {return}

    private fun clickDatePicker(view: Unit) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd =DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
                view, selectedyear, selectedmonth, selecteddayofMonth ->


            Toast.makeText(this,
                "The Chosen Year Is $selectedyear,The Chosen Month Is $selectedmonth, " +
                        "The Chosen Day Is $selecteddayofMonth"  ,Toast.LENGTH_SHORT).show()
            val selectedDate = "$selecteddayofMonth/${selectedmonth+1}/$selectedyear"
            binding.tvSelectedDate.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)


            val selectedDateInMinutes = theDate!!.time/ 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateToMinutes = currentDate!!.time /60000
            val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
//            val tvSelectedDateInMinutes = findViewById<TextView>(R.id.tvSelectedDateInMinutes)
            binding.tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

        }
            ,year
            ,month
            ,day)
        dpd.datePicker.setMaxDate((Date().time - 86400000))
        dpd.show()
    }
}

//private fun TextView.setText(fl: Float) {
//    TODO("Not yet implemented")
//}
//
//private fun Any.setText(selectedDate: String) {
//
//}
