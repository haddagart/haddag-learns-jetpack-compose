open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(): Phone() {

    var isFolded : Boolean = false

    override fun switchOn() {
        if(!isFolded) isScreenLightOn = true
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }

    fun printStatus() {
        println("folded: $isFolded, is screen light on: $isScreenLightOn")
    }
}

fun main() {
    val normalPhone: Phone = Phone()
    val foldablePhone: FoldablePhone = FoldablePhone()

    foldablePhone.printStatus()

    foldablePhone.fold()
    foldablePhone.printStatus()

    foldablePhone.switchOn()
    foldablePhone.printStatus()

    foldablePhone.unfold()
    foldablePhone.printStatus()

    foldablePhone.switchOn()
    foldablePhone.printStatus()
}