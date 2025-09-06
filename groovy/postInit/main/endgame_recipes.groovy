import mods.avaritia
import mods.extendedcrafting

def xcrafting = avaritia.extreme_crafting
def tcrafting = extendedcrafting.table_crafting

def bucketOf(String fluid) {
    return item('forge:bucketfilled').withNbt([FluidName:fluid, Amount:1000])
}

def gasTankOf(int tier, String gas, int amt) {
    return item('mekanism:gastank').withNbt([
        tier: tier,
        mekData: [
            stored: [amount: amt, gasName: gas]
        ]
    ])
}

/* ------- EC Table Crafting Recipes ------- */

crafting.remove('extendedcrafting:table_advanced')
crafting.shapedBuilder()
    .output(item('extendedcrafting:table_advanced'))
    .shape('ACA',
           'BDB',
           'AEA')
    .key([
        A: item('extendedcrafting:material', 16),
        B: item('extendedcrafting:material', 9),
        C: item('extendedcrafting:material', 8),
        D: item('extendedcrafting:table_basic'),
        E: item('minecraft:gold_block')
    ])
    .register()

crafting.remove('extendedcrafting:table_elite')
tcrafting.shapedBuilder()
    .output(item('extendedcrafting:table_elite'))
    .matrix('HEIEH',
            'GDCDG',
            'FBABF',
            'GDCDG',
            'HEIEH')
    .key([
        A: item('extendedcrafting:table_advanced'),
        B: item('extendedcrafting:table_basic'),
        C: item('minecraft:diamond_block'),
        D: item('extendedcrafting:material', 10),
        E: item('extendedcrafting:material', 16),
        F: item('extendedcrafting:material', 9),
        G: item('extendedcrafting:material', 15),
        H: item('minecraft:diamond'),
        I: item('extendedcrafting:material', 17)
    ])
    .tierAdvanced()
    .register()

crafting.remove('extendedcrafting:table_ultimate')
tcrafting.shapedBuilder()
    .output(item('extendedcrafting:table_ultimate'))
    .matrix('KGFLFGK',
            'FJEDEJF',
            'GHCBCHG',
            'JIDADIJ',
            'GHCBCHG',
            'FJEDEJF',
            'KGFLFGK')
    .key([
        A: item('extrautils2:opinium', 8),
        B: item('extendedcrafting:table_elite'),
        C: item('extendedcrafting:table_advanced'),
        D: item('extendedcrafting:material', 11),
        E: item('jaopca:item_platedenseemerald'),
        F: item('extendedcrafting:material', 16),
        G: item('extendedcrafting:material', 10),
        H: item('jaopca:item_crystaldraconium'),
        I: item('draconicevolution:chaotic_core'),
        J: item('mysticalagradditions:awakened_draconium_seeds'),
        K: item('extendedcrafting:material', 17),
        L: item('draconicevolution:awakened_core')
    ])
    .tierElite()
    .register()

/* ----------------------------------------- */

// move xtreme crafting recipes to the table crafting
xcrafting.removeAll()

// ---  ET Solar Array Buffs  --- //
crafting.remove('environmentaltech:m_multiblocks/m_solar/solar_array_cont_4')
tcrafting.shapedBuilder()
    .output(item('environmentaltech:solar_cont_4'))
    .matrix('PALAP',
            'BEDEB',
            'ALCLA',
            'BEDEB',
            'PALAP')
    .key([
        P: item('environmentaltech:pladium'),
        L: item('environmentaltech:lonsdaleite'),

        A: item('environmentaltech:solar_cell_pladium'),
        B: item('environmentaltech:solar_cell_litherite'),
        C: item('environmentaltech:solar_cont_3'),
        D: item('environmentaltech:litherite_crystal'),
        E: item('environmentaltech:pladium_crystal'),
    ])
    .tierAdvanced()
    .register()

crafting.remove('environmentaltech:m_multiblocks/m_solar/solar_array_cont_5')
tcrafting.shapedBuilder()
    .output(item('environmentaltech:solar_cont_5'))
    .matrix('AABBBAA',
            'ACDEDCA',
            'BDFFFDB',
            'BEFZFEB',
            'BDFFFDB',
            'ACDEDCA',
            'AABBBAA')
    .key([
        A: item('environmentaltech:solar_cell_pladium'),
        B: item('environmentaltech:ionite'),
        C: ore('ingotUltimate'),
        D: item('environmentaltech:solar_cell_litherite'),
        E: item('environmentaltech:solar_cell_ionite'),
        F: item('environmentaltech:ionite_crystal'),
        Z: item('environmentaltech:solar_cont_4'),
    ])
    .tierElite()
    .register()

crafting.remove('environmentaltech:m_multiblocks/m_solar/solar_array_cont_6')
tcrafting.shapedBuilder()
    .output(item('environmentaltech:solar_cont_6'))
    .matrix('AABBABBAA',
            'ACCDEFCCA',
            'BCGAGAGCB',
            'BDAHIHAJB',
            'AEGKZKGEA',
            'BFAHIHALB',
            'BCGAGAGCB',
            'ACCJELCCA',
            'AABBABBAA')
    .key([
        A: ore('ingotUltimate'),
        B: item('environmentaltech:aethium'),
        C: item('environmentaltech:solar_cell_litherite'),
        D: item('environmentaltech:solar_cell_pladium'),
        E: item('environmentaltech:solar_cell_aethium'),
        F: item('environmentaltech:solar_cell_ionite'),
        G: item('environmentaltech:ionite'),
        H: item('draconicevolution:chaos_shard:1'),
        I: item('draconicevolution:chaos_shard'),
        J: item('environmentaltech:solar_cell_erodium'),
        K: item('environmentaltech:aethium_crystal'),
        L: item('environmentaltech:solar_cell_kyronite'),
        Z: item('environmentaltech:solar_cont_5'),
    ])
    .tierUltimate()
    .register()

// ---  Endgame Items  --- //

tcrafting.shapedBuilder() // Creative Storage Upgrade
    .output(item('storagedrawers:upgrade_creative'))
    .matrix('ABBBA',
            'BAAAB',
            'CDEDC',
            'BAAAB',
            'ABBBA')
    .key([
        A: item('storagedrawers:upgrade_storage:4'), // Storage Upgrade V
        B: item('avaritia:resource:3'), // Neutronium Nugget
        C: item('industrialforegoing:black_hole_unit'),
        D: item('draconicevolution:draconium_chest'),
        E: item('storagedrawers:upgrade_template')
    ])
    .tierAdvanced()
    .register()

tcrafting.shapedBuilder() // Creative Fluid Tank
    .output(item('mekanism:machineblock2:11').withNbt([tier: 4]))
    .matrix('A1B829B1A',
            'CH7AOA7HC',
            'B3EEEEE5B',
            'KAEDGDEAK',
            '2PEFJFEP2',
            'LAEDIDEAL',
            'B4EEEEE6B',
            'CH7AOA7HC',
            'A1BM2NB1A')
    .key([
        A: ore('ingotUltimate'),
        B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:4'), // Neutronium Ingot
        D: item('avaritia:resource:6'), // Infinity Ingot
        E: item('extrautils2:drum:3'), // Demonically Gargantuan Drum
        F: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        G: item('draconicevolution:chaotic_core'),
        H: item('industrialforegoing:black_hole_tank'),
        I: item('draconicevolution:awakened_core'),
        J: item('mekanism:machineblock2:11').withNbt([tier: 3]), // Ultimate Fluid Tank
        K: bucketOf('tritium'),
        L: bucketOf('deuterium'),
        M: bucketOf('uranium_235'),
        N: bucketOf('plutonium_238'),
        O: item('jaopca:item_crystaldraconium'),
        P: item('jaopca:item_crystaltitanium'),

        '1': bucketOf("neutron"),
        '2': bucketOf("draconium"),
        '3': bucketOf("petrotheum"),
        '4': bucketOf("aerotheum"),
        '5': bucketOf("pyrotheum"),
        '6': bucketOf("cryotheum"),
        '7': bucketOf("xu_demonic_metal"),
        '8': bucketOf("americium_241"),
        '9': bucketOf("curium_247")
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Gas Tank
    .output(item('mekanism:gastank').withNbt([tier: 4]))
    .matrix('DBCAAACBD',
            'BBFAEAFBB',
            'CIEGHGEIC',
            'AAJ345JAA',
            'ACH2K6HCA',
            'AAJ1L7JAA',
            'CIEGHGEIC',
            'BBFAEAFBB',
            'DBCAAACBD')
    .key([
        A: ore('ingotUltimate'),
        B: item('avaritia:resource:4'), // Neutronium Ingot
        C: item('avaritia:resource:5'), // Infinity Catalyst
        D: item('extrautils2:drum:3'), // Demonically Gargantuan Drum
        E: item('avaritia:resource:6'), // Infinity Ingot
        F: item('extendedcrafting:material:19'), // The Ultimate Component
        G: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        H: item('industrialforegoing:black_hole_tank'),
        I: item('minecraft:bucket'),
        J: item('draconicevolution:awakened_core'),
        K: item('draconicevolution:chaotic_core'),
        L: item('mekanism:machineblock2:11').withNbt([tier: 4]), // Creative Fluid Tank

        '1': gasTankOf(3, 'oxygen', 512000),
        '2': gasTankOf(3, 'deuterium', 512000),
        '3': gasTankOf(3, 'slurryDraconium', 512000),
        '4': gasTankOf(3, 'sulfuricacid', 512000),
        '5': gasTankOf(3, 'slurryTitanium', 512000),
        '6': gasTankOf(3, 'tritium', 512000),
        '7': gasTankOf(3, 'hydrogen', 512000)
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Capactior Bank
    .output(item('enderio:block_cap_bank').withNbt(['enderio:energy': 50000000]))
    .matrix('BBBDADBBB',
            'BCEDFDECB',
            'BEECFCEEB',
            'DDGHJHGDD',
            'AFFILIFFA',
            'DDGHKHGDD',
            'BEECFCEEB',
            'BCEDFDECB',
            'BBBDADBBB')
    .key([
        A: item('avaritia:resource:5'), // Infinity Catalyst
        B: item('avaritia:resource:4'), // Neutronium Ingot
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('enderio:block_cap_bank:3'), // Vibrant Capacitor Bank
        E: item('extendedcrafting:material:19'), // The Ultimate Component
        F: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        G: item('draconicevolution:awakened_core'),
        H: item('draconicevolution:draconic_energy_core'),
        I: item('draconicevolution:energy_storage_core'),
        J: item('draconicevolution:chaotic_core'),
        K: item('ic2:te:86'), // Creative Generator
        L: item('draconicevolution:draconium_capacitor:2') // Creative Flux Capacitor
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Generator
    .output(item('ic2:te:86'))
    .matrix('OADEEEDAO',
            'AADBCBDAA',
            'PQIGHGIQP',
            'DDCFJFCDD',
            'ENMFKFMNE',
            'DDCFLFCDD',
            'RQIGHGIQR',
            'AADBCBDAA',
            'OADEEEDAO')
    .key([
        A: item('avaritia:resource:4'), // Neutronium Ingot
        B: item('avaritia:resource:6'), // Infinity Ingot
        C: item('avaritia:resource:5'), // Infinity Catalyst
        D: item('extendedcrafting:material:19'), // The Ultimate Component
        E: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        F: item('extendedcrafting:material:32'), // The Ultimate Ingot
        G: item('draconicevolution:draconic_energy_core'),
        H: item('draconicevolution:draconium_capacitor:1'), // Draconic Flux Capacitor
        I: item('enderio:block_cap_bank:3'), // Vibrant Capacitor Bank
        J: item('draconicevolution:awakened_core'),
        K: item('draconicevolution:chaotic_core'),
        L: item('draconicevolution:reactor_core'),
        M: item('draconicevolution:energy_storage_core'),
        N: item('ic2:te:24'), // Reactor Chamber
        O: item('ic2:te:22'), // Nuclear Reactor
        P: item('ic2:te:9'), // Stirling Generator
        Q: item('ic2:te:5'), // Kinetic Generator
        R: item('ic2:te:4') // Geothermal Generator
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Vending Upgrade
    .output(item('storagedrawers:upgrade_creative:1'))
    .matrix('DCAABAACD',
            'CEEGFGEEC',
            'AE2HCH4EA',
            'AGMILIMGA',
            'BFKJNJKFB',
            'AGMILIMGA',
            'AE1HCH3EA',
            'CEEGFGEEC',
            'DCAABAACD')
    .key([
        A: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        B: item('minecraft:dragon_egg'),
        C: item('industrialforegoing:black_hole_unit'),
        D: item('avaritia:block_resource:2'), // Crystal Matrix Block
        E: item('avaritia:block_resource:1'), // Infinity Block
        F: item('avaritia:resource:5'), // Infinity Catalyst
        G: item('extracells:storage.component:3'), // 16384k ME Storage Component
        H: item('draconicevolution:draconium_chest'),
        I: item('draconicevolution:chaotic_core'),
        J: item('environmentaltech:solar_cont_6'),
        K: item('extendedcrafting:singularity_ultimate'),
        L: item('appliedenergistics2:creative_storage_cell'),
        M: item('extrautils2:compressedcobblestone:7'), // Octuple Compressed Cobblestone
        N: item('storagedrawers:upgrade_template'),

        '1': item('mekanism:machineblock2:11').withNbt([tier: 4]), // Creative Fluid Tank
        '2': item('mekanism:gastank').withNbt([tier: 4]), // Creative Gas Tank
        '3': item('ic2:te:86'), // Creative Generator
        '4': item('enderio:block_cap_bank').withNbt(['enderio:energy': 50000000]), // Creative Capacitor Bank
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Exchanger
    .output(item('draconicevolution:creative_exchanger'))
    .matrix('  B      ',
            ' A C     ',
            'B  C     ',
            ' CCCB    ',
            '   B B   ',
            '    BDB  ',
            '     BB  ',
            '       CC',
            '       CE')
    .key([
        A: item('storagedrawers:upgrade_creative:1'),
        B: item('extendedcrafting:material:19'), // The Ultimate Component
        C: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        D: item('draconicevolution:reactor_core'),
        E: item('draconicevolution:draconic_block')
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative ME Storage Cell
    .output(item('appliedenergistics2:creative_storage_cell'))
    .matrix('    E    ',
            '   FDF   ',
            '  GDCDG  ',
            ' FDCBCDF ',
            'EDCBABCDE',
            ' FDCBCDF ',
            '  GDCDG  ',
            '   FDF   ',
            '    E    ')
    .key([
        A: item('avaritia:resource:5'), // Infinity Catalyst
        B: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        C: item('extracells:storage.component:3'), // 16384k ME Storage Component
        D: item('avaritia:block_resource'), // Neutronium Block
        E: item('extrautils2:compressedcobblestone:6'), // Septuple Compressed Cobblestone
        F: item('extrautils2:compressedcobblestone:5'), // Sextuple Compressed Cobblestone
        G: item('extrautils2:compressedcobblestone:4') // Quintuple Compressed Cobblestone
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Flux Capacitor
    .output(item('draconicevolution:draconium_capacitor:2'))
    .matrix('G  AAA  G',
            ' EFABAFE ',
            ' FEABAEF ',
            'AAACCCAAA',
            'ABBCDCBBA',
            'AAACCCAAA',
            ' FEABAEF ',
            ' EFABAFE ',
            'G  AAA  G')
    .key([
        A: item('draconicevolution:draconic_block'),
        B: item('extendedcrafting:storage:4'), // Block of The Ultimate
        C: item('draconicevolution:draconium_capacitor:1'), // Draconic Flux Capacitor
        D: item('draconicevolution:chaotic_core'),
        E: item('avaritia:block_resource:2'), // Crystal Matrix Block
        F: item('extendedcrafting:material:19'), // The Ultimate Component
        G: item('extendedcrafting:material:13')  // The Ultimate Catalyst
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Template
    .output(item('tconstruct:materials:50'))
    .matrix('HHGFFFGHH',
            'HEEDDDEEH',
            'GEDCCCDEG',
            'FDCBBBCDF',
            'FDCBABCDF',
            'FDCBBBCDF',
            'GEDCCCDEG',
            'HEEDDDEEH',
            'HHGFFFGHH')
    .key([
        A: item('tconstruct:materials:14'), // Reinforced Modifier
        B: item('extendedcrafting:material:19'), // The Ultimate Component
        C: item('tconstruct:materials:11'), // Magma Slime Crystal
        D: item('tconstruct:materials:10'), // Blue Slime Crystal
        E: item('tconstruct:materials:9'), // Green Slime Crystal
        F: item('tconstruct:materials:19'), // Mending Moss
        G: item('tconstruct:materials:16'), // Silky Jewel
        H: item('tconstruct:metal:6') // Silky Block of Jewel
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Builders Wand
    .output(item('extrautils2:itemcreativebuilderswand'))
    .matrix('      GAA',
            '     HEFA',
            '    GEDEG',
            '    AFEH ',
            '    BAG  ',
            '   B     ',
            '  B      ',
            ' B       ',
            'C        ')
    .key([
        A: item('draconicevolution:draconium_block:1'), // Charged Draconium Block
        B: item('draconicevolution:draconium_block'),
        C: item('extrautils2:passivegenerator:6'), // Creative Mill
        D: item('extrautils2:opinium:8'), // Opinium Core (Perfected)
        E: item('extrautils2:opinium:7'), // Opinium Core (Inspiring)
        F: item('extrautils2:klein'), // Klein Bottle
        G: item('extendedcrafting:material:19'), // The Ultimate Component
        H: item('extendedcrafting:material:13') // The Ultimate Catalyst
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // /dank/null/Creative
    .output(item('danknull:dank_null_6'))
    .matrix('IIIIIIIII',
            'IHHEEEHHI',
            'IHFGKGFHI',
            'IEBABABEI',
            'IEDCJCDEI',
            'IEBABABEI',
            'IHFGKGFHI',
            'IHHEEEHHI',
            'IIIIIIIII')
    .key([
        A: item('danknull:dank_null_5'), // /dank/null/MK VI
        B: item('appliedenergistics2:storage_cell_64k'),
        C: item('storagedrawers:upgrade_creative'), // Creative Storage Upgrade
        D: item('draconicevolution:draconium_chest'),
        E: item('draconicevolution:draconic_ingot'),
        F: item('draconicevolution:draconic_block'),
        G: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        H: item('extendedcrafting:material:19'), // The Ultimate Component
        I: item('extrautils2:compressedcobblestone:3'), // Quadruple Compressed Cobblestone
        J: item('draconicevolution:chaotic_core'),
        K: item('draconicevolution:awakened_core')
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Creative Screen
    .output(item('rftools:creative_screen'))
    .matrix('AAA',
            'BCB',
            'AAA')
    .key([
        A: item('extendedcrafting:material:19'), // The Ultimate Component
        B: item('opencomputers:screen3'),
        C: item('rftools:screen')
    ])
    .tierBasic()
    .register()

tcrafting.shapedBuilder() // Creative Mill
    .output(item('extrautils2:passivegenerator:6'))
    .matrix('ABABABABA',
            'BCDDEDDCB',
            'ADFFFFFDA',
            'BDFGJGFDB',
            'AEFHIHFEA',
            'BDFGKGFDB',
            'ADFFFFFDA',
            'BCDDEDDCB',
            'ABABABABA')
    .key([
        A: item('draconicevolution:draconium_block'),
        B: item('draconicevolution:draconium_block:1'), // Charged Draconium Block
        C: item('extendedcrafting:material:13'), // The Ultimate Catalyst
        D: item('extendedcrafting:material:19'), // The Ultimate Component
        E: item('minecraft:dragon_egg'),
        F: item('extrautils2:compressedcobblestone:4'), // Quintuple Compressed Cobblestone
        G: item('extrautils2:passivegenerator:8'), // Dragon Egg Mill
        H: item('extrautils2:simpledecorative:1'), // Block of Demon Metal
        I: item('extrautils2:rainbowgenerator'),
        J: item('extrautils2:rainbowgenerator:2'), // Rainbow Gen (Top Half)
        K: item('extrautils2:rainbowgenerator:1')  // Rainbow Gen (Bottom Half)
    ])
    .tierUltimate()
    .register()

tcrafting.shapelessBuilder() // Ultimate Ingot 
    .output(item('extendedcrafting:material:32'))
    .input(
        // -- Row 1 -- //
        item('minecraft:iron_ingot'),
        item('minecraft:gold_ingot'),
        item('advancedrocketry:productingot'),
        item('advancedrocketry:productingot:1'),
        item('draconicevolution:draconium_ingot'),
        item('draconicevolution:draconic_ingot'),
        item('enderio:item_alloy_ingot'),
        item('enderio:item_alloy_ingot:1'),
        item('enderio:item_alloy_ingot:2'),
        // -- Row 2 -- //
        item('enderio:item_alloy_ingot:3'),
        item('enderio:item_alloy_ingot:4'), 
        item('enderio:item_alloy_ingot:5'),
        item('enderio:item_alloy_ingot:6'),
        item('enderio:item_alloy_ingot:7'),
        item('enderio:item_alloy_ingot:8'),
        item('enderio:item_alloy_ingot:9'),
        item('enderio:item_alloy_endergy_ingot'),
        item('enderio:item_alloy_endergy_ingot:1'),
        // -- Row 3 -- //
        item('enderio:item_alloy_endergy_ingot:2'),
        item('enderio:item_alloy_endergy_ingot:3'),
        item('enderio:item_alloy_endergy_ingot:4'),
        item('enderio:item_alloy_endergy_ingot:5'),
        item('enderio:item_alloy_endergy_ingot:6'),
        item('extendedcrafting:material'),
        item('extendedcrafting:material:24'),
        item('extendedcrafting:material:36'),
        item('extendedcrafting:material:48'),
        // -- Row 4 -- //
        item('extrautils2:ingredients:11'),
        item('extrautils2:ingredients:12'),
        item('extrautils2:ingredients:17'),
        item('industrialforegoing:pink_slime_ingot'),
        item('mekanism:ingot'),
        item('mekanism:ingot:1'),
        item('mekanism:ingot:3'),
        item('mysticalagriculture:crafting:38'),
        item('tconstruct:ingots:2'),
        // -- Row 5 -- //
        item('libvulpes:productingot:7'),
        item('mysticalagriculture:crafting:34'),
        item('mysticalagriculture:crafting:35'),
        item('mysticalagriculture:crafting:36'),
        item('mysticalagriculture:crafting:37'),
        item('mysticalagradditions:insanium:2'),
        item('nuclearcraft:ingot:3'),
        item('nuclearcraft:ingot:5'),
        item('nuclearcraft:ingot:6'),
        // -- Row 6 -- //
        item('nuclearcraft:ingot:7'),
        item('nuclearcraft:ingot:8'),
        item('nuclearcraft:ingot:9'),
        item('nuclearcraft:ingot:10'),
        item('nuclearcraft:ingot:11'),
        item('nuclearcraft:ingot_oxide'),
        item('nuclearcraft:ingot_oxide:1'),
        item('nuclearcraft:ingot_oxide:2'),
        item('nuclearcraft:ingot_oxide:3'),
        // -- Row 7 -- //
        item('nuclearcraft:alloy:13'),
        item('nuclearcraft:alloy:15'),
        item('extrautils2:unstableingots:2'),
        item('plustic:alumiteingot'),
        item('plustic:osgloglasingot'),
        item('plustic:osmiridiumingot'),
        item('randomthings:ingredient:3'),
        item('techguns:itemshared:84'),
        item('thermalfoundation:material:160'),
        // -- Row 8 -- // 
        item('thermalfoundation:material:128'),
        item('thermalfoundation:material:129'),
        item('thermalfoundation:material:130'),
        item('thermalfoundation:material:131'),
        item('thermalfoundation:material:132'),
        item('thermalfoundation:material:133'),
        item('thermalfoundation:material:134'),
        item('thermalfoundation:material:135'),
        item('thermalfoundation:material:136'),
        // -- Row 9 -- //
        item('thermalfoundation:material:161'),
        item('thermalfoundation:material:162'),
        item('thermalfoundation:material:163'),
        item('thermalfoundation:material:164'),
        item('thermalfoundation:material:165'),
        item('thermalfoundation:material:166'),
        item('thermalfoundation:material:167'),
        item('tconstruct:ingots'),
        item('tconstruct:ingots:1')
    )
    .tierUltimate()
    .register()

// --- Avaritia Recipe Override --- //
tcrafting.shapelessBuilder() // Infinity Catalyst
    .output(item('avaritia:resource:5'))
    .input(
        item('avaritia:resource'), // Diamond Lattice
        item('avaritia:resource:1'), // Crystal Matrix
        item('avaritia:resource:2'), // Pile of Neutrons
        item('avaritia:resource:3'), // Neutronium Nugget
        item('avaritia:resource:4'), // Neutronium Ingot
        item('avaritia:ultimate_stew'),
        item('avaritia:cosmic_meatballs'),
        item('avaritia:endest_pearl'),
        item('avaritia:resource:7'), // Record Fragment
        item('extendedcrafting:singularity:0'), // Coal Singularity
        item('extendedcrafting:singularity:1'), // Iron Singularity
        item('extendedcrafting:singularity:2'), // Lapis Singularity
        item('extendedcrafting:singularity:3'), // Redstone Singularity
        item('extendedcrafting:singularity:5'), // Gold Singularity
        item('extendedcrafting:singularity:6'), // Diamond Singularity
        item('extendedcrafting:singularity:7'), // Emerald Singularity
        item('extendedcrafting:singularity:16'), // Aluminum Singularity
        item('extendedcrafting:singularity:17'), // Copper Singularity
        item('extendedcrafting:singularity:18'), // Tin Singularity
        item('extendedcrafting:singularity:22'), // Silver Singularity
        item('extendedcrafting:singularity:23'), // Lead Singularity
        item('extendedcrafting:singularity:25'), // Nickel Singularity
        item('extendedcrafting:singularity:32'), // Uranium Singularity
        item('extendedcrafting:singularity:34'), // Platinum Singularity
        item('extendedcrafting:singularity:35'), // Iridium Singularity
        item('extendedcrafting:singularity:64'), // Ardite Singularity
        item('extendedcrafting:singularity:65'), // Cobalt Singularity
        item('thermalfoundation:storage_alloy:0'), // Steel Block
        item('thermalfoundation:storage_alloy:1'), // Electrum Block
        item('thermalfoundation:storage_alloy:2'), // Invar Block
        item('thermalfoundation:storage_alloy:3'), // Bronze Block
        item('thermalfoundation:storage_alloy:4'), // Constantan Block
        item('thermalfoundation:storage_alloy:5'), // Signalum Block
        item('thermalfoundation:storage_alloy:6'), // Lumium Block
        item('thermalfoundation:storage_alloy:7'), // Enderium Block
        item('tconstruct:metal:2'), // Manyullyn Block
        item('libvulpes:metal0:7'), // Titanium Block
        item('mysticalagriculture:storage:4') // Supremium Essence Block
    )
    .tierElite()
    .register()

tcrafting.shapedBuilder() // Infinity Ingot
    .output(item('avaritia:resource:6'))
    .matrix('BBBBBBBBB',
            'BDAAEAADB',
            'BACCACCAB',
            'BDAAEAADB',
            'BBBBBBBBB',
            '         ',
            '         ',
            '         ',
            '         ')
    .key([
        A: item('avaritia:resource:5'), // Infinity Catalyst
        B: item('avaritia:resource:4'), // Neutronium Ingot
        C: item('avaritia:resource:2'), // Pile of Neutron
        D: item('avaritia:resource:1'), // Crystal Matrix Ingot
        E: item('appliedenergistics2:material:47') // AE2 Singularity
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Endest Pearl
    .output(item('avaritia:endest_pearl'))
    .matrix('   FFF   ',
            ' FFEEEFF ',
            ' FEDDDEF ',
            'FEDCBCDEF',
            'FEDBABDEF',
            'FEDCBCDEF',
            ' FEDDDEF ',
            ' FFEEEFF ',
            '   FFF   ')
    .key([
        A: item('minecraft:nether_star'),
        B: item('avaritia:resource:3'), // Neutronium Nugget
        C: item('avaritia:resource:2'), // Pile of Neutrons
        D: item('rftools:infused_enderpearl'),
        E: item('minecraft:ender_pearl'),
        F: item('minecraft:end_stone')
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Neutron Collector
    .output(item('avaritia:neutron_collector'))
    .matrix('FFGGGFF',
            'F CCC F',
            'GCBDBCG',
            'GCBABCG',
            'GCBEBCG',
            'F CCC F',
            'FFGGGFF')
    .key([
        A: item('enderio:block_vacuum_chest'),
        B: item('minecraft:redstone_block'),
        C: item('minecraft:redstone'),
        D: item('appliedenergistics2:material:47'), // AE2 Singularity
        E: item('minecraft:chest'),
        F: item('minecraft:iron_block'),
        G: item('minecraft:quartz_block')
    ])
    .tierElite()
    .register()

tcrafting.shapedBuilder() // Infinity Helmet
    .output(item('avaritia:infinity_helmet'))
    .matrix('  DDDDD  ',
            ' DCCCCCD ',
            ' D BAB D ',
            ' DCCCCCD ',
            ' DCCCCCD ',
            ' DC C CD ',
            '         ',
            '         ',
            '         ')
    .key([
        A: item('draconicevolution:draconic_helm'),
        B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4') // Neutronium Ingot
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Infinity Breastplate
    .output(item('avaritia:infinity_chestplate'))
    .matrix(' DD   DD ',
            'ECCDDDCCE',
            'ECCCCCCCE',
            ' DCCCCCD ',
            ' DCCACCD ',
            ' DCCCCCD ',
            ' DCCCCCD ',
            ' DCCCCCD ',
            '  DDDDD  ')
    .key([
        A: item('draconicevolution:draconic_chest'),
    //  B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4'), // Neutronium Ingot
        E: item('avaritia:block_resource:2')  // Crystal Matrix Block
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Infinity Leggings
    .output(item('avaritia:infinity_pants'))
    .matrix(' DDDDDDD ',
            ' DCCACCD ',
            ' DCDBDCD ',
            ' DCD DCD ',
            ' DCD DCD ',
            ' DCD DCD ',
            ' DCD DCD ',
            ' DCD DCD ',
            ' DD   DD ')
    .key([
        A: item('draconicevolution:draconic_legs'),
        B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4') // Neutronium Ingot
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Infinity Boots
    .output(item('avaritia:infinity_boots'))
    .matrix('         ',
            ' DB   BD ',
            ' DCD DCD ',
            ' DCD DCD ',
            ' DCDADCD ',
            'DCCD DCCD',
            'DDDD DDDD',
            '         ',
            '         ')
    .key([
        A: item('draconicevolution:draconic_boots'),
        B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4') // Neutronium Ingot
    ])
    .tierUltimate()
    .register()

tcrafting.shapelessBuilder() // Ultimate Stew
    .output(item('avaritia:ultimate_stew'))
    .input(
        item('minecraft:apple'),
        item('minecraft:cookie'),
        item('minecraft:melon'),
        item('minecraft:rotten_flesh'),
        item('minecraft:spider_eye'),
        item('minecraft:carrot'),
        item('minecraft:beetroot'),
        item('minecraft:potato'),
        item('minecraft:poisonous_potato'),
        item('minecraft:mushroom_stew'),
        item('minecraft:beetroot_soup'),
        item('avaritia:resource:2') // Pile of Neutrons
    )
    .tierAdvanced()
    .register()

tcrafting.shapelessBuilder() // Cosmic Meatballs
    .output(item('avaritia:cosmic_meatballs'))
    .input(
        item('minecraft:beef'),    item('minecraft:beef'), 
        item('minecraft:mutton'),  item('minecraft:mutton'), 
        item('minecraft:chicken'), item('minecraft:chicken'), 
        item('minecraft:rabbit'),  item('minecraft:rabbit'), 
        item('minecraft:fish'),    item('minecraft:fish'), 
        item('minecraft:fish:1'),  item('minecraft:fish:1'), 
        item('minecraft:fish:2'),  item('minecraft:fish:2'), 
        item('minecraft:fish:3'),  item('minecraft:fish:3'), 
        item('avaritia:resource:2') // Pile of Neutrons 
    )
    .tierAdvanced()
    .register()

tcrafting.shapedBuilder() // Sword of the Cosmos
    .output(item('avaritia:infinity_sword'))
    .matrix('       CC',
            '      CCC',
            '     CCC ',
            '    CCC  ',
            ' E CCC   ',
            '  EAC    ',
            '  DE     ',
            ' D  E    ',
            'B        ')
    .key([
        A: item('draconicevolution:draconic_staff_of_power'),
        B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4'), // Neutronium Ingot
        E: item('avaritia:block_resource:2') // Crystal Matrix Block
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Longbow of the Heavens
    .output(item('avaritia:infinity_bow'))
    .matrix('   CC    ',
            '  C F    ',
            ' C  F    ',
            'CC  F    ',
            'EA  F    ',
            'CC  F    ',
            ' C  F    ',
            '  C F    ',
            '   CC    ')
    .key([
        A: item('draconicevolution:draconic_bow'),
    //  B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
    //  D: item('avaritia:resource:4'), // Neutronium Ingot
        E: item('avaritia:block_resource:2'), // Crystal Matrix Block
        F: ore('blockWool') // Crystal Matrix Block
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // World Breaker
    .output(item('avaritia:infinity_pickaxe'))
    .matrix(' CCCECCC ',
            'CCCCACCCC',
            'CC  D  CC',
            '    D    ',
            '    D    ',
            '    D    ',
            '    D    ',
            '    D    ',
            '    D    ')
    .key([
        A: item('draconicevolution:draconic_pick'),
    //  B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4'), // Neutronium Ingot
        E: item('avaritia:block_resource:2') // Crystal Matrix Block
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Planet Eater
    .output(item('avaritia:infinity_shovel'))
    .matrix('      CCC',
            '     CCFC',
            '      ACC',
            '     D C ',
            '    D    ',
            '   D     ',
            '  D      ',
            ' D       ',
            'B        ')
    .key([
        A: item('draconicevolution:draconic_shovel'),
        B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4'), // Neutronium Ingot
    //  E: item('avaritia:block_resource:2'), // Crystal Matrix Block
        F: item('avaritia:block_resource:1')  // Infinity Block
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Nature's Ruin
    .output(item('avaritia:infinity_axe'))
    .matrix('   C     ',
            '  CCCCC  ',
            '   CCCA  ',
            '     CD  ',
            '      D  ',
            '      D  ',
            '      D  ',
            '      D  ',
            '      D  ')
    .key([
        A: item('draconicevolution:draconic_axe'),
    //  B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4'), // Neutronium Ingot
    //  E: item('avaritia:block_resource:2') // Crystal Matrix Block
    ])
    .tierUltimate()
    .register()

tcrafting.shapedBuilder() // Hoe of the Green Earth
    .output(item('avaritia:infinity_hoe'))
    .matrix('     D   ',
            ' CCCCCC  ',
            'CCCCCAC  ',
            'C    CC  ',
            '     D   ',
            '     D   ',
            '     D   ',
            '     D   ',
            '     D   ')
    .key([
        A: item('draconicevolution:draconic_hoe'),
    //  B: item('avaritia:resource:5'), // Infinity Catalyst
        C: item('avaritia:resource:6'), // Infinity Ingot
        D: item('avaritia:resource:4'), // Neutronium Ingot
    //  E: item('avaritia:block_resource:2') // Crystal Matrix Block
    ])
    .tierUltimate()
    .register()

// --- Reuse Recipes --- //
// e.g. to empty Creative Fluid Tank
crafting.addShapeless(item('mekanism:machineblock2:11').withNbt([tier:4]), [item('mekanism:machineblock2:11').withNbt([tier:4])])
crafting.addShapeless(item('mekanism:gastank').withNbt([tier:4]), [item('mekanism:gastank').withNbt([tier:4])])
crafting.addShapeless(item('storagedrawers:upgrade_creative') * 2, [item('storagedrawers:upgrade_creative')])

/*
tcrafting.shapedBuilder() // Template
    .output(item(''))
    .matrix()
    .key([

    ])
    .tierUltimate()
    .register()

tcrafting.shapelessBuilder() // Template
    .output(item(''))
    .input(
        
    )
    .tierUltimate()
    .register()
*/