// The `open` keyword tells the compiler that this class is extensible
open class SmartDevice(val name: String, val category: String) {

    // `open` can be also used for methods and properties for overriding.

    var deviceStatus = "on"
    open val deviceType = "unknown"


    open fun turnOn() {
        deviceStatus = "on"
        println("Smart device is on ...")
    }

    open fun turnOff() {
        deviceStatus = "off"
        println("Smart device is off ...")
    }

}

// Let's make a SmartTV that inherites from SmartDevice
// class ChildClass([params]) : ParentClass([params-binding])

class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory) {

        override val deviceType = "Smart TV"

        // Speaker volume property in SmartTV
        var speakerVolume:Int = 20
            set(value:Int) {if(value in 0..100) field = value}
        // Channel no. property in SmartTV
        var channelNumber:Int = 1
            set(value:Int) {if(value in 0..200) field = value}

        // These are new implemented child-methods
        fun increaseSpeakerVolume() {
            speakerVolume++ // This is an impilicit call of the setter
            println("Speaker volume increased to $speakerVolume")
        }

        fun nextChannel() {
            channelNumber++
            println("You are watching channel: $channelNumber")
        }

        // These are newly defined parent-methods
        override fun turnOn() {
            // deviceStatus = "on" this can be accessed parent class
            super.turnOn() // call the parent method from the child
            println("SmartTV $deviceName is on\nSpeaker volume: $speakerVolume\nChannel: $channelNumber")
        }

        override fun turnOff() {
            super.turnOff()
            println("SmartTV $deviceName is off")
        }
}

// Class inheritance is also called is-a relationship
// E.g. Smart tv is a smart device, it is a uni-directional relationship

class SmartLightDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory) {

        override val deviceType = "Smart Light"

        var brightnessLevel:Int = 0
            set(value:Int) {if(value in 0..100) field = value}

        // This is a new implemented child-method
        fun increaseBrightnessLevel() {
            brightnessLevel++
            println("Brightness level increased to ${brightnessLevel}%")
        }

        // These are redefined parent-methods
        override fun turnOn() {
            super.turnOn()
            brightnessLevel  = 2
            println("Smart light $deviceName is on and brightness is set to $brightnessLevel")
        }

        override fun turnOff() {
            super.turnOff()
            brightnessLevel = 0
            println("Smart light $deviceName is turned off")
        }


}

// In this case we define a has-a relationship
// E.g. a smart home has a smart tv
class SmartHome(
    val smartTv: SmartTvDevice,
    val smartLight: SmartLightDevice,
) {
    fun turnOnTv() {smartTv.turnOn()}
    fun turnOffTv() {smartTv.turnOff()}
    fun increaseTvVolume() {smartTvDevice.increaseSpeakerVolume()}
    fun changeTvChannelToNext() {smartTvDevice.nextChannel()}

    fun turnOnLight() {smartLightDevice.turnOn()}
    fun turnOffLight() {smartLightDevice.turnOff()}
    fun increaseLightBrightness() {smartLightDevice.increaseBrightnessLevel()}
    
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

fun main() {
    // The child class accepts the type of the parent one
    val smartTv: SmartDevice = SmartTvDevice("Samsung TV", "Entertainment")
    val smartLight: SmartDevice = SmartLightDevice("Philips", "Utils")

    smartLight.turnOff()
    smartTv.turnOn()

    smartTv.speakerVolume = 99
    smartTv.increaseSpeakerVolume() // increases to 100
    smartTv.increaseSpeakerVolume() // no more increase, only in in 0..100

    smartTv.turnOff()
    smartLight.turnOn()

    smartLight.increaseBrightnessLevel() // increases to 1%
}

/*
    -------
    Summary
    -------

    - Define classes : class name(params) {...}
    - Define properties : var/val name: type = default value
    - Define a getter: get() = field
    - Define a setter: set(newValue) {...}
    - `field` is used to represent the encapsulated value of the property
    - Don't access the property by its name in the setter/getter
      that would make an infinite loop.
    - The setters and getters are defined right below the property
    - Define methods : fun name(params) {}
    - Constructors:
        A. default empty constructor class name : constructor() {...}
        B. default parameterized constructor class name(params) {...}
        C. In class constructors: constructor(params) {...}
    - Enheritance called also is-a relationship
    - We need to use `open` on the parent class to make it extensible:
        open class name(params) {...}
    - Syntax: class name(params) : child_name(params_binding) {...}
        - params binding: new_param_name = parent_param_name
    - We can use the same open concept on properties and methods
    - To override a property or method in the class we use override
    - To reuse a parent method we use super.method_name(...)
    - The type of a child can be the parent's type in inheritance
    - When a user-defined class is used for a property in another class
      that is called has-a relationship
 */