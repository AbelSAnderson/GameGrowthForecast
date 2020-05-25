import dates.RealDateController
import growth.GrowthController
import growth.GrowthExpression
import growth.SystemController
import systems.LevelSystem
import systems.PrestigeSystem
import systems.helpers.Value

/**
 * @author Abel Anderson
 * @since 01/05/2020
 * See instructions for using this program below.
 */
fun main() {

    /*
    Create GrowthExpressions for the Systems you will be allocating the GrowthController to have.
    GrowthExpressions have one parameter - The function you want to run whenever date growth is simulated.
    The Function takes on the form (currencyController: CurrencyController, days: Int) -> Double.

    The SystemController will hold all the systems you add to the GrowthController.
    You can use currencyController.getCurrencyValue(currencyName: String) to grab whatever currency you want to use in your calculations.

    A simple Leveling & Prestige System is demonstrated here.
    */
    val xpGrowthRate = GrowthExpression { systemController: SystemController, days: Int ->
        20.0 * days * (0.2 * systemController.getSystemValue("prestige").toDouble())
    }
    val levelGrowthRate = GrowthExpression { systemController: SystemController, days: Int ->
        1.2
    }

    val prestigeCurrencyGrowthRate = GrowthExpression { systemController: SystemController, days: Int ->
        0.5 * systemController.getSystemValue("level").toDouble()
    }

    /*
        Here we create your systems with the Growth Expressions we made earlier.
        CurrencySystem takes in a couple values - name: The name of the Currency, currentValue: The Starting value of the Currency, and GrowthExpression: The GrowthExpression that defines the growth of the Currency.
        It has one optional value - showDouble - This determines whether the currency is displayed as a double. This is automatically set to false.

        LevelSystem has a few more values - name, level: The starting level, growthRate: How much xp required for each level increases each level, experienceCurrency: The currency that increases the level, and firstLevelExperience: The experience needed for the first level

        Please note that I use non-zero values for value on systems - This is because zero values may cause bugs in the program. This will be fixed soon - for now just don't use zero in systems.
    */
    val xpCurrency = systems.CurrencySystem("xp", Value(0.1), xpGrowthRate)
    val levelSystem = LevelSystem("level", Value(1), levelGrowthRate, xpCurrency, 15)

    val prestigeCurrency = systems.CurrencySystem("gems",
        Value(0.1), prestigeCurrencyGrowthRate)
    val prestigeSystem = PrestigeSystem("prestige", prestigeCurrency, mutableListOf(levelSystem), 80)

    /*
    The GrowthController takes in a mutable list of CurrencySystems as it's only parameter
    It will run any calculations that are needed in your dateController

    Notice that xpCurrency is not included in the GrowthController - This is because it's stats is already managed by the LevelSystem you created earlier.
    If you wanted to use xpCurrency in any of your calculations, you would simply access the level currency & from there access the xpCurrency
    */
    val growthController = GrowthController(mutableListOf(levelSystem, prestigeSystem))

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