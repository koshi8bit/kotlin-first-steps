import java.util.ArrayList

interface IPublisher<T> {
    val observers: ArrayList<T>

    fun addListener(listener: T) {
        observers.add(listener)
    }

    fun removeListener(listener: T) {
        observers.remove(listener)
    }
}