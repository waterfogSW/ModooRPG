package extension

import com.github.f4b6a3.uuid.UuidCreator
import java.util.*


object UuidUtil {
    fun getTimeOrderedEpoch(): UUID {
        return UuidCreator.getTimeOrderedEpochPlus1()
    }
}
