package subtask1

import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        try{
            val calendar=LocalDate.parse(day+ " "+ month+ " "+year,DateTimeFormatter.ofPattern("d M yyyy"))
            if(calendar.dayOfMonth.toString()!=day){
                return "Такого дня не существует"
            }
        }catch (e:Exception){
            return "Такого дня не существует"
        }
        var dayOfWeek = GregorianCalendar(
            year.toInt(),
            month.toInt() - 1,
            day.toInt()
        ).get(GregorianCalendar.DAY_OF_WEEK)
        var numberOfMonth = GregorianCalendar(
            year.toInt(),
            month.toInt() - 1,
            day.toInt()
        ).get(GregorianCalendar.MONTH)
        val listOfDays: List<String> = listOf(
            "воскресенье",
            "понедельник",
            "вторник",
            "среда",
            "четверг",
            "пятница",
            "суббота"
        )
        val listOfMonth: List<String> = listOf(
            "января",
            "февраля",
            "марта",
            "апреля",
            "мая",
            "июня",
            "июля",
            "августа",
            "сентября",
            "октября",
            "ноября",
            "декабря"
        )
        return day + " " + listOfMonth[numberOfMonth] + ", " + listOfDays[dayOfWeek-1]
    }
}
