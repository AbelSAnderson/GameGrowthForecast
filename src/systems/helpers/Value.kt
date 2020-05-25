package systems.helpers

class Value(
    value: Number
) : Cloneable {
    private var _oldValue: Number? = null
    val oldValue: Number
        get() = _oldValue ?: currentValue

    var currentValue: Number = value
        set(value) {
            _oldValue = value
            field = value
        }

    operator fun inc(): Value {
        currentValue = currentValue.toDouble() + 1
        return this
    }

    override fun toString(): String {
        return currentValue.toString()
    }

    public override fun clone(): Value {
        return super.clone() as Value
    }
}
