import matteroverdrive.init.OverdriveBioticStats

// requirement nerf ; 64 -> 8
OverdriveBioticStats.zeroCalories.getRequiredItems().tap {
    clear()
    add(item('matteroverdrive:emergency_ration') * 8)
}

// disable light level for industrial glass 10 -> 0
block('matteroverdrive:industrial_glass').setLightLevel(0f)