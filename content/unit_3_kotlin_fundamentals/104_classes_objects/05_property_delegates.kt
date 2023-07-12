import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
    We can notice that checking range for previous code is duplicated
    Thus using delegates is the best way to approach such problem

    Now we are going to delegate the setters and getters of these checked
    variables to the `delegate object`

    Syntax:
    ------
    var var_name by delegate_name

    Delegation is bound to interfaces, which are made for abstraction
    "An interface is a protocol to which classes that implement it need to adhere."

    Delegates
    ---------
    var : ReadWriteProperty interface
    val : ReadOnlyProperty interface
    
*/


/*
    This is an implementation of ReadWriteProperty for any int type\
    it takes three params in the constructor, one public and two private

    "The KProperty is an interface that represents a declared property
    and lets you access the metadata on a delegated property."
*/
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int,
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue


    override fun getValue(thisRef: Any?, property: KProperty<*>:) : Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue) fieldData = value
    }

}


class SmartDevice(name: String, category: String) {
    var deviceStatus = "on"
        protected set(value) {deviceStatus = value}

    // ... rest of the code
}

class SmartTvDevice(
    name: String, 
    category: String,
): SmartDevice(
    name = name,
    category = category
) {
    private var speakerVolume by RangeRegulator(
        initialValue = 2,
        minValue = 0,
        maxValue = 100,
    )

    private var channelNumber by RangeRegulator(
        initialValue = 1,
        minValue = 1,
        maxValue = 200,
    )

    // ... rest of the code
}

class SmartLightDevice(
    name: String,
    category: String,
) : SmartDevice(
    name = name,
    category = category
) {

    private var brightnessLevel by RangeRegulator(
        initialValue = 0,
        minValue = 0,
        maxValue = 100,
    )
    // Now the setter and getter are implemented in the RangeRegulator

    // ... Rest of the code

}