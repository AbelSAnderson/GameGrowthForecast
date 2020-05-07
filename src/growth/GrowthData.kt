package growth

class GrowthData(var experienceTillNextLevel: Int) : Cloneable {

    var currentLevel: Int = 1
    var totalExperience: Int = 0
    var levelsGained: Int = 0
    var experienceGained: Int = 0

    fun createGrowthData(oldGrowthData: GrowthData): GrowthData {
        val newGrowthData = GrowthData(experienceTillNextLevel)

        newGrowthData.currentLevel = currentLevel
        newGrowthData.levelsGained = currentLevel - oldGrowthData.currentLevel
        newGrowthData.totalExperience = totalExperience
        newGrowthData.experienceGained = totalExperience - oldGrowthData.totalExperience

        return newGrowthData
    }

    public override fun clone(): GrowthData {
        return super.clone() as GrowthData
    }

    override fun toString(): String {
        return "Player Data: \n" +
                "Levels Gained: $levelsGained\n" +
                "Current level: $currentLevel\n" +
                "Experience Gained: $experienceGained\n" +
                "Total Experience: $totalExperience\n" +
                "Experience till next level: $experienceTillNextLevel\n"
    }
}