/* ------- Vanilla Tools Debuff ------- */
def toolsToDebuff = [ 'sword', 'shovel', 'pickaxe', 'axe', 'hoe' ]
def materialsToDebuff = [ 'stone', 'iron', 'golden', 'diamond' ]

for (def tool in toolsToDebuff) {
    for (def material in materialsToDebuff) {
        def iTool = item("minecraft:${material}_${tool}")
        iTool.getItem()
            .setMaxStackSize(1)
            .setMaxDamage((iTool.getMaxDamage()*0.1).toInteger())
    }
    def iTool = item("minecraft:wooden_${tool}")
    iTool.getItem().setMaxStackSize(1).setMaxDamage((iTool.getMaxDamage()/2).toInteger())
}

item('minecraft:ender_pearl').getItem().setMaxStackSize(64)

/* -------- Starting Inventory -------- */
player.setReplaceDefaultInventory(true)
player.addStartingItem(item('retro_sophisticated_backpacks:backpack_leather'))