package growth

class GrowthController(experienceModifier: ExperienceModifier) {

    private val player = Player(experienceModifier)


    fun calculateGrowth(forDays: Double): GrowthData {
        return player.simulateGrowth(forDays)
    }

    fun calculateGrowth(oldGrowthData: GrowthData): GrowthData {
        return player.getGrowthData(oldGrowthData)
    }

    fun currentGrowth(): GrowthData {
        return player.overallGrowthData.clone()
    }
}