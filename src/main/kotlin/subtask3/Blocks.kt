package subtask3

import subtask1.DateFormatter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val list: List<Any?> = blockA.toList()
        var blockCInt: Int = 0
        var blockCString: String = ""
        val blockCDate = ArrayList<LocalDate>()
        var differenceDay: Long = 0
        var blockC: LocalDate = LocalDate.now()
        for (element in list) {
            if (element is Int && blockB == Int::class) blockCInt += element
            if (element is String && blockB == String::class) blockCString += element
            if (element is LocalDate && blockB == LocalDate::class) {
                blockC = element
                differenceDay = element.until(LocalDateTime.now(), ChronoUnit.DAYS)
                blockCDate.add(element)
            }
        }
        if (blockB == LocalDate::class) {
            for (element in blockCDate) {
                if (differenceDay > element.until(LocalDateTime.now(), ChronoUnit.DAYS)) {
                    blockC = element
                    differenceDay = element.until(LocalDateTime.now(), ChronoUnit.DAYS)
                }
            }
        }
        if (blockB == Int::class) return blockCInt
        if (blockB == String::class) return blockCString
        else {
            val dateFormatter=DateTimeFormatter.ofPattern("dd.MM.yyyy")
            return blockC.dayOfMonth.toString()+"."+blockC.monthValue.toString()+"."+blockC.year.toString()
        }
    }
}
