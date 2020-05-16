import currency.Currency
import currency.CurrencyController
import dates.RealDateController
import growth.GrowthController
import growth.GrowthExpression
import kotlin.math.floor
import kotlin.math.ln

/**
 * @author Abel Anderson
 * @since 01/05/2020
 * See instructions for using this program below.
 */
fun main() {

    /*
    Create GrowthExpressions for the Currencies you will be allowing the GrowthController to have.
    GrowthExpressions have one parameter - The function you want to run whenever date growth is simulated.
    The Function takes on the form (currencyController: CurrencyController, days: Int) -> Double.

    Currency Controller will hold all the currencies you add to the GrowthController.
    You can use currencyController.getCurrencyValue(currencyName: String) to grab whatever currency you want to use in your calculations.

    A Simple Experience & Leveling System is demonstrated here.
    */
    val xpGrowthExpression = GrowthExpression { currencyController: CurrencyController, days: Int -> 20.0 * days }
    val levelGrowthExpression = GrowthExpression { currencyController: CurrencyController, days: Int ->
        floor(ln(currencyController.getCurrencyValue("xp") / 15) / ln(1.2)) - currencyController.getCurrencyValue("level")
    }

    /*
        Here we create your currencies with the Growth Expressions we made earlier.
        Currency takes in a couple values - name: The name of the Currency, currentValue: The Starting value of the Currency, and GrowthExpression: The GrowthExpression that defines the growth of the Currency.
        It has one optional value - showDouble - This determines whether the currency is displayed as a double. This is automatically set to false.

        (Notice that I set the xp value to 1, not 0 - this is because you cannot log 0. I will probably create a check for this problem in a later version.).
    */
    val xpCurrency = Currency("xp", 1.0, xpGrowthExpression)
    val levelCurrency = Currency("level", 1.0, levelGrowthExpression)

    /*
    The GrowthController takes in a mutable list of CurrencySystems as it's only parameter
    It will run any calculations that are needed in your dateController
    */
    val growthController = GrowthController(mutableListOf(xpCurrency, levelCurrency))

    /*
    The AbstractDateController runs simulations for periods of time determined by the list you pass it.
    Say you want to run data for 500 days, with reports back every 100 and 10 days.
    This would require you to provide it with a list of: 500, 100, 10.
    You can make this list as long or as short as you want, as long as you provide it with a valid number.
    */
//    val dateController = AbstractDateController(mutableListOf(300, 100))

    /*
    This will actually perform the calculations for you. You will need to pass it the growth Controller.
    It has an option Parameter: repeatFor. This will allow you to repeat the pattern of 500, 100, 10 that you earlier put it for a set amount of times.
    So if you actually wanted to run it for 1500 days, you could put in 3, and it will run the set of 500 3 times.
    You can also reuse the dateController you created to run different simulations on separate growth rates, just by using the perform growth function.
    */
//    dateController.performGrowth(growthController, 2)

    /*
    Alternative to Using AbstractDateController. This will simple perform calculations over a whole year.
    You can also choose whether to show weekly growth & how many year to repeat it for.
    */
    RealDateController().performGrowth(growthController, false, 2)
}