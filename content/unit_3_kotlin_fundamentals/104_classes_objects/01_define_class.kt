// Define a simple class
class SmartDevice {
    
    // Properties
    // Read-only properties are defined with val
    val name:String = "Android TV"
    val category:String = "Entertainment"
    // Mutable properties are defined with var
    var deviceStatus:String = "online"
    /*
        The field is a keyword that retains the value of the accessed property
        Don't use the property name in the setter and getter otherwise it will 
        lead to infinite loop
    */
    var speakerVolume:Int = 25
        // Getter: gets the field value contains get() = {...}
        get() = field
        // Setter: set the field value dones't contain set(value) {...}
        set(value) {
            if(value in 1..100) field = value
        }
    
    
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
    println("Device: ${myDevice.name}")
    println("Speaker volume: ${myDevice.speakerVolume}")
    myDevice.speakerVolume = 50
    println("Speaker volume: ${myDevice.speakerVolume}")
    myDevice.turnOff()
}