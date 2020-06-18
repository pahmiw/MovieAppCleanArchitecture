package inn.mroyek.movieappcleanarchitecture.helper.extension

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.toLocalDate() : String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return try {

        val date = simpleDateFormat.parse(this) ?: return this
        val formattedDate = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault()).format(date)
        formattedDate
    } catch (e: Exception){
        throw IllegalArgumentException("Not a valid datetime format")
    }
}