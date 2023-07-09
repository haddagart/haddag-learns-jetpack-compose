// Define a simple class
class SmartDevice {
    
    // Properties
    // Read-only properties are defined with val
    val name:String = "Android TV"
    val category:String = "Entertainment"
    // Mutable properties are defined with var
    var deviceStatus:String = "online"
    var speakerVolume:Int = 25
        get() = field // this is a getter call predefined get
        set(value) {
            if(value in 1..100) field = value
        } // setter are function without the = symbol
        /*
            The field is a keyword that retains the value of the accessed property
            Don't use the property name in the setter and getter otherwise
            it will lead to infinite loop
         */
    
    // Methods
    fun turnOn() {
        println("The smart device is on")
    }
    
    fun turnOff() {
        println("The smart device is off")
    }
}

fun main() {
    val myDevice = SmartDevice()
    myDevice.turnOn()
    myDevice.turnOff()
}