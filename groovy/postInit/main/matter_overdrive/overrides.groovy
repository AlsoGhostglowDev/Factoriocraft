import matteroverdrive.init.OverdriveBioticStats

// requirement nerf ; 64 -> 8
OverdriveBioticStats.zeroCalories.getRequiredItems().tap {
    clear()
    add(item('matteroverdrive:emergency_ration') * 8)
}