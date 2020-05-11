import abstractDate.AbstractDateController
import abstractDate.RealDateController
import growth.ExperienceModifier
import growth.GrowthController

/**
 * @author Abel Anderson
 * @since 01/05/2020
 * @see ExperienceModifier.calculateLevel for the formulas used in this project.
 * See instructions for using this program below.
 */
fun main() {

    /*
    Experience Modifier: This will determine how quickly the user levels up & how much experience they need to level up.
    For now, you can only put in a Double as the XPGrowthPerLevel, resulting in a flat curve, but I plan to change that soon.
    */
    //val experienceModifier = ExperienceModifier(20.0, 1.2, 50.0)

    //GrowthController will handle the Player's growth - For now, all you need to pass it is the exModifier, and it will work it's magic
    //val growthController = GrowthController(experienceModifier)

    /*
    The AbstractDateController runs simulations for periods of time determined by the list you pass it.
    Say you want to run data for 500 days, with reports back every 100 and 10 days.
    This would require you to provide it with a list of: 500, 100, 10.
    You can make this list as long or as short as you want, as long as you provide it with a valid number.
    */
    //val dateController = AbstractDateController(mutableListOf(300, 100))

    /*
    This will actually perform the calculations for you. You will need to pass it the growth Controller.
    It has an option Parameter: repeatFor. This will allow you to repeat the pattern of 500, 100, 10 that you earlier put it for a set amount of times.
    So if you actually wanted to run it for 1500 days, you could put in 3, and it will run the set of 500 3 times.
    You can also reuse the dateController you created to run different simulations on separate growth rates, just by using the perform growth function.
    */
    //dateController.performGrowth(growthController, 2)

    /*
    Alternative to Using AbstractDateController. This will simple perform calculations over a whole year.
    You can also choose whether to show weekly growth & how many year to repeat it for.
    */
    //RealDateController().performGrowth(growthController, false, 2)
}