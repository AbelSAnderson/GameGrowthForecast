package Growth

import Currency.Currency
import Currency.CurrencyController
import Currency.CurrencySystem

class Player(private val currencySystems: MutableList<CurrencySystem>) {

    val currencyController: CurrencyController =
        CurrencyController(mutableListOf())

    init {
        //New HashMap of values
        val attributeList: HashMap<String, Currency> = hashMapOf()

        //Grab all the key & values
        currencySystems.forEach {
            attributeList[it.currency.name] = it.currency
        }

        //Add the new attributes
        currencyController.addCurrencies(attributeList)
    }

    fun calculateGrowth(days: Int): CurrencyController {
        currencySystems.forEach {
            it.calculateGrowth(currencyController, days)
        }

        return currencyController
    }

    fun getGrowthData(oldGrowthData: CurrencyController): CurrencyController {
        return currencyController.calculateGrowth(oldGrowthData)
    }
}