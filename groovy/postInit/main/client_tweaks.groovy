// side: client

import net.minecraftforge.event.entity.player.ItemTooltipEvent

@groovy.transform.Field def tooltipMap = [:]

/* ------- Vanilla Tools Debuff ------- */
def toolsToDebuff = [ 'sword', 'shovel', 'pickaxe', 'axe', 'hoe' ]
def materialsToDebuff = [ 'stone', 'iron', 'golden', 'diamond' ]

for (def tool in toolsToDebuff) {
    for (def material in materialsToDebuff) {
        def iTool = item("minecraft:${material}_${tool}")
        addTooltip(iTool, '\u00A7cVanilla Tools are heavily nerfed, use Tinkers\' Construct instead.')
    }
}

/* Helper Functions */
def addTooltip(ItemStack itemStack, String line) {
    tooltipMap[itemStack] = line
}

event_manager.listen { ItemTooltipEvent event ->
    for (def entry in tooltipMap) {
        if (event.getItemStack() in entry.key) {
            event.getToolTip().add(1, entry.value)
        }
    }
}