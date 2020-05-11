import abstractDate.AbstractDateController
import growth.*
import kotlin.math.floor
import kotlin.math.ln

/**
 * @author Abel Anderson
 * @since 01/05/2020
 * @see ExperienceModifier.calculateLevel for the formulas used in this project.
 * See instructions for using this program below.
 */
fun main() {

    /*
    Create GrowthExpressions for the Currencies you will be allowing the GrowthController to have.
    GrowthExpressions have one parameter - The function you want to run whenever date growth is simulated
    The Function takes on the form (currencyController: CurrencyController, days: Int) -> Double

    Currency Controller will hold all the currencies you add to the GrowthController.
    You can use currencyController.getCurrencyValue(currencyName: String) to grab whatever currency you want to use in your calculations

    A Simple Experience & Leveling System is demonstrated here
    */
    val xpGrowthExpression = GrowthExpression { currencyController: CurrencyController, days: Int -> 20.0 * days }
    val levelGrowthExpression = GrowthExpression { currencyController: CurrencyController, days: Int ->
        floor(ln(currencyController.getCurrencyValue("xp") / 15) / ln(1.2)) - currencyController.getCurrencyValue("level")
    }

    /*
    CurrencySystems takes in two parameters: The Currency, and the Growth Expression that we created above.
    Currency takes in two parameters as well: The currency name, and the initial value of the currency (as a Double)
    You can add an optional third parameter to Currency: displayDouble which lets you see the currency as a Double
    */
    val xpCurrencySystem = CurrencySystem(Currency("xp", 0.0), xpGrowthExpression)
    val levelCurrencySystem = CurrencySystem(Currency("level", 1.0), levelGrowthExpression)

    /*
    The GrowthController takes in a mutable list of CurrencySystems as it's only parameter
    It will run any calculations that are needed in your dateController
    */
    val growthController = GrowthController(mutableListOf(xpCurrencySystem, levelCurrencySystem))

    /*
    The AbstractDateController runs simulations for periods of time determined by the list you pass it.
    Say you want to run data for 500 days, with reports back every 100 and 10 days.
    This would require you to provide it with a list of: 500, 100, 10.
    You can make this list as long or as short as you want, as long as you provide it with a valid number.
    */
    val dateController = AbstractDateController(mutableListOf(300, 100))

    /*
    This will actually perform the calculations for you. You will need to pass it the growth Controller.
    It has an option Parameter: repeatFor. This will allow you to repeat the pattern of 500, 100, 10 that you earlier put it for a set amount of times.
    So if you actually wanted to run it for 1500 days, you could put in 3, and it will run the set of 500 3 times.
    You can also reuse the dateController you created to run different simulations on separate growth rates, just by using the perform growth function.
    */
    dateController.performGrowth(growthController, 2)

    /*
    Alternative to Using AbstractDateController. This will simple perform calculations over a whole year.
    You can also choose whether to show weekly growth & how many year to repeat it for.
    */
    //RealDateController().performGrowth(growthController, false, 2)
}