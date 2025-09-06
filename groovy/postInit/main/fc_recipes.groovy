import mods.draconicevolution
import mods.extendedcrafting

// Tinkers Construct
crafting.removeByOutput(item('tconstruct:materials:14'))
crafting.shapedBuilder() // Reinforced Modifier (buffed)
    .output(item('tconstruct:materials:14'))
    .shape('ORO',
           'RPR',
           'ORO')
    .key([
        O: item('minecraft:obsidian'),
        R: item('mekanism:ingot'), // Refined Obsidian Ingot
        P: item('tconstruct:cast').withNbt([PartType:'tconstruct:large_plate']) // Large Plate Cast
    ])
    .register()

// SRParasites
def frag = item('srparasites:ada_longarms_drop')
def bone = item('srparasites:bone')
def membrane = item('srparasites:beckon_drop')
def shell = item('srparasites:vile_shell')
def core = item('srparasites:living_core')
crafting.shapedBuilder() // Living Helm (added)
    .output(item('srparasites:armor_helm'))
    .shape('   ',
           'FCF',
           'BMB')
    .key([
        F: frag,
        C: core,
        B: bone,
        M: membrane
    ])
    .register()

crafting.shapedBuilder() // Living Chest (added)
    .output(item('srparasites:armor_chest'))
    .shape('B B',
           'MCM',
           'FSF')
    .key([
        F: frag,
        C: core,
        B: bone,
        M: membrane,
        S: shell
    ])
    .register()

crafting.shapedBuilder() // Living Pants (added)
    .output(item('srparasites:armor_pants'))
    .shape('FMF',
           'BCB',
           'F F')
    .key([
        F: frag,
        C: core,
        B: bone,
        M: membrane
    ])
    .register()

crafting.shapedBuilder() // Living Boots (added)
    .output(item('srparasites:armor_boots'))
    .shape('F F',
           'BCB',
           'M M')
    .key([
        F: frag,
        C: core,
        B: bone,
        M: membrane
    ])
    .register()

def blade = item('srparasites:infectious_blade_fragment')
def membrane2 = item('srparasites:dispatcher_drop')
def bone2 = item('srparasites:ada_yelloweye_drop')
crafting.shapedBuilder() // Living Lance (added)
    .output(item('srparasites:weapon_lance'))
    .shape('  I',
           'BMI',
           'CB ')
    .key([
        I: blade,
        C: core,
        B: bone2,
        M: membrane2
    ])
    .register()

// ExtraUtil2
crafting.remove('extrautils2:angel_ring_0')
crafting.shapedBuilder() // Angel Ring (buffed)
    .output(item('extrautils2:angelring'))
    .shape('AEA',
           'BCB',
           'ADA')
    .key([
        A: ore('blockGlass'),
        B: ore('plateGold'),
        C: item('extrautils2:chickenring:1'), // Ring of the Flying Squid
        D: item('extrautils2:goldenlasso:1').withNbt([Animal:[id: 'minecraft:ghast']]), // Cursed Lasso (Animal: Ghast)
        E: item('minecraft:elytra:*')
    ])
    .register()

    

// Thermal Expansion
crafting.removeByOutput(item('thermalexpansion:frame'))
crafting.shapedBuilder() // Machine Frame (buffed)
    .output(item('thermalexpansion:frame'))
    .shape('IGI',
           'GMG',
           'IDI')
    .key([
        I: ore('plateIron'),
        G: ore('blockGlass'),
        M: item('rftools:machine_frame'),
        D: item('thermalexpansion:frame:64') // Device Frame
    ])
    .register()

// RFTools
crafting.removeByOutput(item('thermalexpansion:frame'))
crafting.shapedBuilder() // TE Machine Frame (buffed)
    .output(item('thermalexpansion:frame'))
    .shape('IGI',
           'GMG',
           'IDI')
    .key([
        I: ore('plateIron'),
        G: ore('blockGlass'),
        M: item('rftools:machine_frame'),
        D: item('thermalexpansion:frame:64') // Device Frame
    ])
    .register()

crafting.removeByOutput(item('rftools:machine_frame'))
crafting.shapedBuilder() // RFTools Machine Frame (buffed)
    .output(item('rftools:machine_frame'))
    .shape('IBI',
           'GTG',
           'IBI')
    .key([
        I: ore('plateIron'),
        B: ore('dyeBlue'),
        G: ore('ingotGold'),
        T: ore('gearTin')
    ])
    .register()

// Mystical Agriculture
def fcrafting = draconicevolution.fusion
def s = item('mysticalagriculture:crafting:4')
crafting.removeByOutput(item('mysticalagriculture:crafting:21')) // Tier 5 Crafting Seed
fcrafting.recipeBuilder()
    .catalyst(item('mysticalagriculture:crafting:20')) // Tier 4 Crafting Seed
    .input(s, s, s, s, 
           s, s, s, s)
    .output(item('mysticalagriculture:crafting:21')) // Tier 5 Crafting Seed
    .energy(1000000)
    .tierWyvern()
    .register()

def bs = item('mysticalagriculture:storage:4')
def ie = item('mysticalagradditions:insanium')
crafting.removeByOutput(item('mysticalagradditions:insanium:1'))
fcrafting.recipeBuilder()
    .catalyst(item('mysticalagriculture:crafting:21')) // Tier 5 Crafting Seed
    .input(bs, bs, bs, bs, 
           ie, ie, ie, ie)
    .output(item('mysticalagradditions:insanium:1')) // Tier 6 Crafting Seed
    .energy(5000000)
    .tierDraconic()
    .register()

// Draconic Evolution
crafting.removeByOutput(item('draconicevolution:draconic_core'))
crafting.shapedBuilder() // Draconic Core (buffed)
    .output(item('draconicevolution:draconic_core'))
    .shape('DED',
           'IEI',
           'DED')
    .key([
        D: ore('ingotDraconium'),
        I: item('rftools:infused_diamond'),
        E: item('thermalfoundation:material:167') // Enderium Ingot
    ])
    .register()

def ccrafting = extendedcrafting.combination_crafting
crafting.removeByOutput(item('draconicevolution:wyvern_helm'))
ccrafting.recipeBuilder()
    .input(item('draconicevolution:wyvern_core'))
    .pedestals(
        item('minecraft:iron_helmet'),
        item('minecraft:golden_helmet'),
        item('minecraft:diamond_helmet'),
        item('ic2:nano_helmet'),
        item('ic2:quantum_helmet'),
        item('netherex:wither_bone_helmet'),
        item('nuclearcraft:helm_tough'),
        item('nuclearcraft:helm_hard_carbon'),
        item('enderio:item_dark_steel_helmet'),
        item('enderio:item_end_steel_helmet'),
        item('enderio:item_stellar_alloy_helmet'),
        item('mysticalagriculture:supremium_helmet'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 5
    )
    .output(item('draconicevolution:wyvern_helm'))
    .cost(1000000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_chest'))
ccrafting.recipeBuilder()
    .input(item('draconicevolution:wyvern_core'))
    .pedestals(
        item('minecraft:iron_chestplate'),
        item('minecraft:golden_chestplate'),
        item('minecraft:diamond_chestplate'),
        item('ic2:nano_chestplate'),
        item('ic2:quantum_chestplate'),
        item('netherex:wither_bone_chestplate'),
        item('nuclearcraft:chest_tough'),
        item('nuclearcraft:chest_hard_carbon'),
        item('enderio:item_dark_steel_chestplate'),
        item('enderio:item_end_steel_chestplate'),
        item('enderio:item_stellar_alloy_chestplate'),
        item('mysticalagriculture:supremium_chestplate'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 8
    )
    .output(item('draconicevolution:wyvern_chest'))
    .cost(1000000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_legs'))
ccrafting.recipeBuilder()
    .input(item('draconicevolution:wyvern_core'))
    .pedestals(
        item('minecraft:iron_leggings'),
        item('minecraft:golden_leggings'),
        item('minecraft:diamond_leggings'),
        item('ic2:nano_leggings'),
        item('ic2:quantum_leggings'),
        item('netherex:wither_bone_leggings'),
        item('nuclearcraft:legs_tough'),
        item('nuclearcraft:legs_hard_carbon'),
        item('enderio:item_dark_steel_leggings'),
        item('enderio:item_end_steel_leggings'),
        item('enderio:item_stellar_alloy_leggings'),
        item('mysticalagriculture:supremium_leggings'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 7
    )
    .output(item('draconicevolution:wyvern_legs'))
    .cost(1000000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_boots'))
ccrafting.recipeBuilder()
    .input(item('draconicevolution:wyvern_core'))
    .pedestals(
        item('minecraft:iron_boots'),
        item('minecraft:golden_boots'),
        item('minecraft:diamond_boots'),
        item('ic2:nano_boots'),
        item('ic2:quantum_boots'),
        item('netherex:wither_bone_boots'),
        item('nuclearcraft:boots_tough'),
        item('nuclearcraft:boots_hard_carbon'),
        item('enderio:item_dark_steel_boots'),
        item('enderio:item_end_steel_boots'),
        item('enderio:item_stellar_alloy_boots'),
        item('mysticalagriculture:supremium_boots'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 4
    )
    .output(item('draconicevolution:wyvern_boots'))
    .cost(1000000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_sword'))
ccrafting.recipeBuilder()
    .input(item('mysticalagriculture:supremium_sword'))
    .pedestals(
        item('enderio:item_stellar_alloy_sword'),
        item('draconicevolution:draconic_core') * 2,
        item('draconicevolution:wyvern_core'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 4
    )
    .output(item('draconicevolution:wyvern_sword'))
    .cost(640000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_bow'))
ccrafting.recipeBuilder()
    .input(item('mysticalagriculture:supremium_bow'))
    .pedestals(
        item('mekanism:electricbow'),
        item('enderio:item_end_steel_bow'),
        item('draconicevolution:draconic_core') * 2,
        item('draconicevolution:wyvern_core'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 4
    )
    .output(item('draconicevolution:wyvern_bow'))
    .cost(640000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_pick'))
ccrafting.recipeBuilder()
    .input(item('mysticalagriculture:supremium_pickaxe'))
    .pedestals(
        item('enderio:item_stellar_alloy_pickaxe'),
        item('draconicevolution:draconic_core') * 2,
        item('draconicevolution:wyvern_core'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 4
    )
    .output(item('draconicevolution:wyvern_pick'))
    .cost(640000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_axe'))
ccrafting.recipeBuilder()
    .input(item('mysticalagriculture:supremium_axe'))
    .pedestals(
        item('enderio:item_stellar_alloy_axe'),
        item('draconicevolution:draconic_core') * 2,
        item('draconicevolution:wyvern_core'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 4
    )
    .output(item('draconicevolution:wyvern_axe'))
    .cost(640000)
    .perTick(5000)
    .register()

crafting.removeByOutput(item('draconicevolution:wyvern_shovel'))
ccrafting.recipeBuilder()
    .input(item('mysticalagriculture:supremium_shovel'))
    .pedestals(
        item('minecraft:diamond_shovel'),
        item('thermalfoundation:tool.shovel_platinum'),
        item('draconicevolution:draconic_core') * 2,
        item('draconicevolution:wyvern_core'),
        item('draconicevolution:wyvern_energy_core'),
        item('draconicevolution:draconium_ingot') * 2
    )
    .output(item('draconicevolution:wyvern_shovel'))
    .cost(640000)
    .perTick(5000)
    .register()

// Environmental Tech
crafting.removeByOutput(item('environmentaltech:litherite_crystal'))
crafting.shapedBuilder() // Litherite Crystal (buffed)
    .output(item('environmentaltech:litherite_crystal'))
    .shape('GFG',
           'FIF',
           'GFG')
    .key([
        G: ore('dyeGreen'),
        F: item('minecraft:flint'),
        I: item('rftools:infused_diamond')
    ])
    .register()

crafting.removeByOutput(item('environmentaltech:tool_multiblock_assembler'))
crafting.shapedBuilder() // Assembler (re-done)
    .output(item('environmentaltech:tool_multiblock_assembler'))
    .shape('  L',
           ' O ',
           'O  ')
    .key([
        L: item('environmentaltech:litherite_crystal'),
        O: item('tconstruct:tool_rod').withNbt([Material:'obsidian']) // Obsidian Tool Rod
    ])
    .register()