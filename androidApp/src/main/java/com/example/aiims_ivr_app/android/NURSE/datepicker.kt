import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.temporal.ChronoUnit



@Composable
fun showdatepicker(context : Context) {

    var year by remember {
        mutableStateOf(0)
    }
    var month by remember {
        mutableStateOf(0)
    }
    var day by remember {
        mutableStateOf(0)
    }

    var calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day= calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    var date by remember {
        mutableStateOf("")
    }

    val datepickerdialog = DatePickerDialog(
        context, {_:DatePicker,year1:Int,month1:Int,dayofmonth:Int ->
            year = year1
            month = month1
            day = dayofmonth
                 },year,month,day
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center, content = {
        Column(Modifier.fillMaxSize()) {
            Text(text = day.toString())
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {datepickerdialog.show()}) {
                Text(text = "Select date")

            }



        }

    })

}




fun addDaysToDate(day: Int, month: Int, year: Int, daysToAdd: Int): MutableList<Int> {
    val calendar = Calendar.getInstance()
    calendar.set(year, month - 1, day)
    calendar.add(Calendar.DAY_OF_MONTH, daysToAdd)
    return mutableListOf(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))
}

//val today = Calendar.getInstance()
//val day = today.get(Calendar.DAY_OF_MONTH)
//val month = today.get(Calendar.MONTH) + 1
//val year = today.get(Calendar.YEAR)
//
//val (newDay, newMonth, newYear) = addDaysToDate(day, month, year, 10)
//
//println("Starting date: $day/$month/$year")
//println("Date after adding 10 days: $newDay/$newMonth/$newYear")


@Composable
fun example(context: Context) {
    val today = Calendar.getInstance()
    val date = addDaysToDate(today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.MONTH), today.get(Calendar.YEAR), 90)
    Text(text = "Resulting date: $date")

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getDaysSince(day: Int, month: Int, year: Int): Long {
    val inputDate = LocalDate.of(year, month, day)
    val today = LocalDate.now()
    return ChronoUnit.DAYS.between(inputDate, today)
}
