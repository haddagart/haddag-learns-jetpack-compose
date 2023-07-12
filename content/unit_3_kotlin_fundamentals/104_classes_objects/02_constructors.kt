/*
    The constructor that gets defined with the name of the class
    is called a primary constructor. 
    We can have a blank primary constructor:
    class ClassName constructor() {...}
 */
class SmartDevice(name:String, category:String) {
    var deviceStatus = "online"

    /*
        Say we have a vendor who sells smart devices with
        deviceStatus as statusCode as an Int in their API
        in such case we need to define a secondary constructor

        constructor ClassName(params) this(@parms) {...}
        @parms is a list of corresponding params from the main constructor,
        they must appear in the same order as those defined in params
    */
    constructor SmartDevice(
        name: String,
        category: String,
        statusCode: Int
    ) this(name, category) {
        deviceStatus = with(statusCode) {
            0 -> "offline",
            1 -> "online",
            else -> "unknown"
        }
    }

    fun turnOn() {
        println("The device is on ...")
    }

    fun turnOff() {
        println("The device is off ...")
    }
}

fun main() {
    deviceA = SmartDevice("Google TV", "Entertainment")
    deviceB = SmartDevice("Samsung TV", "Entertainment", 0)
}