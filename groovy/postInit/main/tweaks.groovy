import net.minecraftforge.fml.common.registry.EntityRegistry
import net.minecraft.entity.monster.EntityEnderman
import net.minecraft.entity.EnumCreatureType
import net.minecraft.init.Biomes

/* ------- Vanilla Tools Debuff ------- */
def toolsToDebuff = [ 'sword', 'shovel', 'pickaxe', 'axe', 'hoe' ]
def materialsToDebuff = [ 'stone', 'iron', 'golden', 'diamond' ]

for (def tool in toolsToDebuff) {
    for (def material in materialsToDebuff) {
        def iTool = item("minecraft:${material}_${tool}")
        iTool.getItem()
            .setMaxStackSize(1)
            .setMaxDamage(1)
    }

    // Wooden Tool specific
    def iTool = item("minecraft:wooden_${tool}")
    iTool.getItem().setMaxStackSize(1).setMaxDamage((iTool.getMaxDamage()/2).toInteger())
}

item('minecraft:ender_pearl').getItem().setMaxStackSize(64)

/* -------- Starting Inventory -------- */
minecraft.player.setReplaceDefaultInventory(true)
minecraft.player.addStartingItem(item('retro_sophisticated_backpacks:backpack_leather'))
minecraft.player.addStartingItem(item('betterquesting:quest_book'))

/* Entity Spawns */
EntityRegistry.addSpawn(
    EntityEnderman, 
    2200, 
    3, 
    5, 
    EnumCreatureType.MONSTER, 
    Biomes.HELL)