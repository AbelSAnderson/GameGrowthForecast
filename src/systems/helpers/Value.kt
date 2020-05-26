package systems.helpers

class Value(
    value: Number
) : Cloneable {
    private var _oldValue: Number? = null
    val oldValue: Number
        get() = _oldValue ?: currentValue

    var currentValue: Number = value
        set(value) {
            _oldValue = field
            field = value
        }

    operator fun inc(): Value {
        currentValue = currentValue.toDouble() + 1
        return this
    }

    override fun toString(): String {
        return "Current Value: ${currentValue.toInt()}\n" +
                "Old Value: ${oldValue.toInt()}"
    }

    public override fun clone(): Value {
        return super.clone() as Value
    }
}
