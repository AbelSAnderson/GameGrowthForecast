package growth

class Player(private val experienceModifier: ExperienceModifier) {

    var overallGrowthData: GrowthData = GrowthData(experienceModifier.firstLevelXP.toInt())

    fun simulateGrowth(forDays: Double): GrowthData {

        //Calculate the Experience gained
        val experienceGained = experienceModifier.calculateXP(forDays)

        //Save the old Growth Data
        val oldGrowthData = overallGrowthData.clone()

        //Update the Player Growth Data
        updatePlayerGrowth(experienceGained)

        return overallGrowthData.createGrowthData(oldGrowthData)
    }

    private fun updatePlayerGrowth(experienceGained: Int) {
        overallGrowthData.totalExperience += experienceGained
        overallGrowthData.currentLevel = experienceModifier.calculateLevel(overallGrowthData.totalExperience.toDouble())
        overallGrowthData.experienceTillNextLevel = experienceModifier.calculateNextLevelXP(overallGrowthData.totalExperience.toDouble(), overallGrowthData.currentLevel.toDouble()).toInt()
        overallGrowthData.levelsGained = overallGrowthData.currentLevel - 1
        overallGrowthData.experienceGained = overallGrowthData.totalExperience
    }

    fun getGrowthData(oldGrowthData: GrowthData): GrowthData {
        return overallGrowthData.createGrowthData(oldGrowthData)
    }
}