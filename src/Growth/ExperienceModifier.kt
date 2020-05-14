package Growth

import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.roundToInt

class ExperienceModifier(var firstLevelXP: Double, var xpGrowthPerLevel: Double, var xpPerDay: Double) {

    fun calculateXP(days: Double): Int {
        return (days * xpPerDay).roundToInt()
    }

    /**
     * Calculates your current level based off your current XP.
     * Complete formula is: L = Log(T/S) / Log(M).
     * For reference:  L = Level, T = Total XP, S = First Level XP, and M = XP per level growth over time (Modifier).
     * This is based off the formula SM^L = T, which calculates the XP needed for a level. This is based off the formula y=a(1+r)^x.
     *
     * @author Abel Anderson
     * @see calculateNextLevelXP
     * @param currentXP The current experience the player has.
     * @return The level the player has, based on the currentXP provided
     */
    fun calculateLevel(currentXP: Double): Int {
        return floor(ln(currentXP / firstLevelXP) / ln(xpGrowthPerLevel)).toInt()
    }

    /**
     * Calculates the XP needed for the next level.
     * This is based off the formula SM^L = T.
     *
     * @author Abel Anderson
     * @see calculateLevel
     * @param currentXP The current experience the player has.
     * @param currentLevel The current level the player is at.
     * @return The experience needed to reach the next level.
     */
    fun calculateNextLevelXP(currentXP: Double, currentLevel: Double): Double {
        return firstLevelXP * xpGrowthPerLevel.pow(currentLevel + 1) - currentXP
    }
}