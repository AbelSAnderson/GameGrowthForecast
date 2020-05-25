package systems.helpers

import java.security.InvalidParameterException

class SystemInfoShell(
    val name: String,
    val systemValue: Value,
    val systemCurrency: SystemInfoShell?
) {

    fun calculateGrowth(fromShell: SystemInfoShell) {
        systemValue.currentValue = fromShell.systemValue.currentValue

        systemCurrency?.calculateGrowth(
            fromShell.systemCurrency
                ?: throw InvalidParameterException("System Currency does not exist in Shell. Please contact developer With simulation settings.")
        )
    }

    override fun toString(): String {
        var tempString = "System Name: $name\n" +
                "$systemValue\n"

        if (systemCurrency != null) tempString += "Inner Currency of $name: \n$systemCurrency"

        return tempString
    }
}