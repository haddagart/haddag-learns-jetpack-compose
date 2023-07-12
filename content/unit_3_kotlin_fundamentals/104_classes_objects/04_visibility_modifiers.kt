/* Visibility modifiers allow hidding things from unauthorized access
    1. Protect propertis and methods in classes
    2. Protect classes and interfaces in packages

    There are four level of visibiliy
    1. public: open access no restictions (default)
    2. private: accessible in the same class or source file 
    3. protected: accessible in subclasses
    4. internal: accessible in the same module

    Syntax:
    -------
    modifier var name : data_type = initial_value
    modifier set() {...} <- for setters
    * The visibility of the getter must match that of the property 
    otherwise a compilation error is going to be produced.
*/

/*
    A module is a collection of source files and build settings 
    that let you divide your project into discrete units of functionality. 
    Your project can have one or many modules. 
    You can independently build, test, and debug each module.


    A package is basically a directory or a folder that groups related classes,
    whereas a module provides a container for your app's source code,
    resource files, and app-level settings. A module can contain multiple packages.

    Source: Google Developers
 */


/*  
    We can specify the visibility of the default constructor
    Syntax:
        class name protected constructor([params]) {...}
    
    We can also specify visibility for the class itsel
    Syntax
        visibility_modifier [open] class ....
*/
open class SmartDevice protected constructor(
    name: String,
    category: String,
) {
    /* Properties */
    var deviceStatus = "on" // should be altered only by subclasses
        protected set(value) {field = value}
        /*
            You can use an empty setter in case no special thing is done
            like the following `protected set`
         */
        
}


class SmartTvDevice(name, category): (name = name, category = category) {
    
    private var channelNumber: Int = 1
        set(value) {if(value in 1..200) field = value}

    private var speakerVolume: Int = 2
        set(value) {if(value in 0..100) field = value}

    protected fun nextChannel() {
        channelNumber++
    }

    // ... rest of the code
}

class SmartLightDevice(name, category): (name = name, category = category) {

    private var brightnessLevel:Int = 0
        set(value) {if(value in 0..100) field = value}

    // ... rest of the code

}

class SmartHome(
    smartTvDevice: SmartTvDevice,
    smartLightDevice: SmarLightDevice,
) {
    var deviceTurnOnCount:Int = 0
        private set // private setter no-external changes

    fun turnOnTv() {
        deviceTurnOnCount++
        // rest of the method
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        // rest of the method
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        // rest of the method
    }

    fun turnOffLight() {
        deviceTurnOffCount--
        // rest of the method
    }
}