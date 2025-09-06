import com.cleanroommc.groovyscript.event.LootTablesLoadedEvent
import net.minecraft.world.storage.loot.LootContext
import net.minecraft.world.storage.loot.RandomValueRange

event_manager.listen { LootTablesLoadedEvent event ->
    lostCitiesLoot(event)
}

@groovy.transform.Field def lostCityLootTable = [
    /* COMMON */
    common: [
        'minecraft:stone': [ /* Granite */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:stonebrick': [ /* Cracked Stone Bricks */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:tnt': [ /* TNT */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:cactus': [ /* Cactus */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:leather': [ /* Leather */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:cookie': [ /* Cookie */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:hay_block': [ /* Hay Bale */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:redstone': [ /* Redstone Dust */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:saddle': [ /* Saddle */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:glowstone_dust': [ /* Glowstone Dust */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:rotten_flesh': [ /* Rotten Flesh */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 5]
        ],
        'minecraft:potato': [ /*  Potato */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:apple': [ /* Apple */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:glass_bottle': [ /* Glass Bottle */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:paper': [ /* Paper */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 5]
        ],
        'minecraft:feather': [ /* Feather */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:beef': [ /* Raw Beef */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:pumpkin': [ /* Pumpkin */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:lit_pumpkin': [ /* Jack o'Lantern */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:book': [ /* Book */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 5]
        ],
        'minecraft:planks': [ /* Oak Wood Planks */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 8]
        ],
        'minecraft:planks': [ /* Spruce Wood Planks */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 8]
        ],
        'minecraft:planks': [ /* Birch Wood Planks */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 9]
        ],
        'minecraft:planks': [ /* Dark Oak Wood Plank */
            meta: 5,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 8]
        ],
        'minecraft:planks': [ /* Acacia Wood Planks */
            meta: 4,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 7]
        ],
        'minecraft:planks': [ /* Jungle Wood Planks */
            meta: 3,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:dirt': [ /* Dirt */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:sand': [ /* Sand */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 10]
        ],
        'minecraft:chest': [ /* Chest */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:brown_mushroom': [ /* Brown Mushroom */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:red_mushroom': [ /*Red Mushroom */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:web': [ /* Cobweb */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:bread': [ /* Bread */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:furnace': [ /* Furnace */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:crafting_table': [ /* Crafting Table */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:clay_ball': [ /* Clay */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:wheat_seeds': [ /* Seeds */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:gunpowder': [ /* Gunpowder */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:wheat': [ /* Wheat */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:pumpkin_seeds': [ /* Pumpkin Seeds */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:melon_seeds': [ /* Melon Seeds */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:fish': [ /* Pufferfish */
            meta: 3,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:fish': [ /* Raw Fish */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:fish': [ /* Raw Salmon */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:log': [ /* Birch Log */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:log': [ /* Oak Log */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 8]
        ],
        'minecraft:log': [ /* Spruce Log */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 8]
        ],
        'minecraft:log': [ /* Jungle Log */
            meta: 3,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:log2': [ /* Acacia Log */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:gravel': [ /* Gravel */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:iron_bars': [ /* Iron Bars */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:bed': [ /* Black Bed */
            meta: 15,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:bed': [ /* Cyan Bed */
            meta: 9,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:bed': [ /* Green Bed */
            meta: 13,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:bed': [ /* Oranage Bed */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:bed': [ /* White Bed */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:redstone_ore': [ /* Redstone Ore */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:melon': [ /* Melon */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:poisonous_potato': [ /* Poisonous Potato */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ]
    ],

    /* UNCOMMON */
    uncommon: [
        'minecraft:golden_horse_armor': [ /* Golden Horse Armor */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:writable_book': [ /* Book n Quill */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:mutton': [ /* Raw Mutton */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 4]
        ],
        'minecraft:enchanted_book': [ /* Curse of Vanishing */
            meta: 0,
            nbt: ['StoredEnchantments': [['id': (short) 71, 'lvl': (short) 1]]],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:record_ward': [ /* Disc: Ward */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'dynamictrees:cactusseed': [ /* Cactus Seed */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:flint': [ /* Flint */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 4]
        ],
        'minecraft:wheat': [ /* Wheat */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 3]
        ],
        'minecraft:bread': [ /* Bread */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:piston': [ /* Piston */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:chainmail_leggings': [ /* Chainmail Leggings */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:arrow': [ /* Arrow */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 6, max: 11]
        ],
        'minecraft:sugar': [ /* Sugar */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 3]
        ],
        'minecraft:book': [ /* Book */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 6]
        ],
        'minecraft:lead': [ /* Lead */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:pumpkin': [ /* Pumpkin */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:torch': [ /* Torch */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 4, max: 10]
        ],
        'minecraft:leather': [ /* Leather */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 3]
        ],
        'minecraft:skull': [ /* Skeleton Skull */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:minecart': [ /* Minecart */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:experience_bottle': [ /* Bottle o' Enchanting */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:egg': [ /* Egg */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:slime_ball': [ /* Slimeball */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:dye': [ /* Ink Sac */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:fish': [ /* Raw Fish */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:ender_pearl': [ /* Ender Pearl */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:beef': [ /* Raw Beef */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:chicken': [ /* Raw Chicken */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 5]
        ],
        'minecraft:rabbit': [ /* Raw Rabbit */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:baked_potato': [ /* Baked Potato */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:coal': [ /* Charcoal */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:coal': [ /* Coal */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 4]
        ],
        'minecraft:bow': [ /* Bow */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:chainmail_chestplate': [ /* Chain Chestplate */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:chainmail_helmet': [ /* Chain Helmet */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:chainmail_boots': [ /* Chain Boots */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:lever': [ /* Lever */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:shears': [ /* Shears */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:clock': [ /* Clock */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:dye': [ /* Bone Meal */
            meta: 15,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 4]
        ],
        'minecraft:bookshelf': [ /* Bookshelf */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 6]
        ],
        'minecraft:beetroot': [ /* Beetroot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 3]
        ],
        'minecraft:potato': [ /* Potato */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 4]
        ],
        'minecraft:paper': [ /* Paper */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 4]
        ],
        'minecraft:iron_ingot': [ /* Iron Ingot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:rail': [ /* Rail */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:shield': [ /* Shield */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:string': [ /* String */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 4, max: 8]
        ],
        'minecraft:enchanted_book': [ /* Enchanted Book (Shimmer) */
            meta: 0,
            nbt: ['StoredEnchantments': [['id': (short) 30, 'lvl': (short) 1]]],
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'techguns:itemshared': [ /* Pistol Rounds */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'techguns:itemshared': [ /* Shotgun Rounds */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'techguns:itemshared': [ /* Pistol Magazine */
            meta: 12,
            weight: 1,
            quality: 1,
            amount: 1
        ]
    ],

    /* RARE */
    rare: [
        'minecraft:name_tag': [ /* Name Tag */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:spider_eye': [ /* Spider Eye */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:carrot': [ /* Carrot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'techguns:pistol': [ /* Pistol */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'techguns:sawedoff': [ /* Double Barrel Shotgun */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'techguns:revolver': [ /* Revolver */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:brick_block': [ /* Bricks */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:anvil': [ /* Very Damaged Anvil */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:anvil': [ /* Anvil */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:torch': [ /* Torch */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:golden_apple': [ /* Golden Apple */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:dye': [ /* Lapis Lazuli */
            meta: 4,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 5]
        ],
        'minecraft:bone': [ /* Bone */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:dye': [ /* Cyan Dye */
            meta: 6,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:fish': [ /* Clownfish */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:gold_ingot': [ /* Gold Ingot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:flint_and_steel': [ /* FLINT AND STEEL */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:coal': [ /* Coal */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 7]
        ],
        'minecraft:dye': [ /* Rose Red */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:brick': [ /* Brick */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'minecraft:iron_ingot': [ /* Iron Ingot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 4]
        ],
        'minecraft:compass': [ /* Compass */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:beetroot': [ /* Beetroot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:record_cat': [ /* Disc: Cat */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:record_chirp': [ /* Disc: Chirp */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:record_mall': [ /* Disc: Mall */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:iron_horse_armor': [ /* Iron Horse Armor */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:fishing_rod': [ /* Fishing Rod */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:ender_pearl': [ /* Ender Pearl */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'appliedenergistics2:material': [ /* Certus Quartz Crystal */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'appliedenergistics2:sky_stone_block': [ /* Sky Stone */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'randomthings:timeinabottle': [ /* Time in a Bottle */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:obsidian': [ /* Obsidian */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:sponge': [ /* Sponge */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'appliedenergistics2:material': [ /* Charged Certus Quartz Crystal */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'thermalfoundation:material': [ /* Wooden Gear */
            meta: 22,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:cauldron': [ /* Cauldron */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:brewing_stand': [ /* Brewing Stand */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'enderio:item_dark_steel_sword': [ /* The Ender */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],

        'minecraft:potion': [ /* Potion of Poison (Poison II) */
            meta: 0,
            nbt: ['Potion': 'minecraft:strong_poison'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:potion': [ /* Potion of Strength */
            meta: 0,
            nbt: ['Potion': 'minecraft:strength'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:potion': [ /* Potion of Swiftness */
            meta: 0,
            nbt: ['Potion': 'minecraft:swiftness'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:potion': [ /* Mundane Potion */
            meta: 0,
            nbt: ['Potion': 'minecraft:mundane'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:potion': [ /* Potion of Weakness*/
            meta: 0,
            nbt: ['Potion': 'minecraft:weakness'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:potion': [ /* Potion of Night Vision */
            meta: 0,
            nbt: ['Potion': 'minecraft:night_vision'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:potion': [ /* Potion of Slowness */
            meta: 0,
            nbt: ['Potion': 'minecraft:slowness'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:enchanted_book': [ /* Enchanted Book (XP Boost I) */
            meta: 0,
            nbt: ['StoredEnchantments': [['id': (short) 26, 'lvl': (short) 1]]],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:enchanted_book': [ /* Enchanted Book (Repellent I) */
            meta: 0,
            nbt: ['StoredEnchantments': [['id': (short) 36, 'lvl': (short) 1]]],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'techguns:itemshared': [ /* Rifle Rounds */
            meta: 3,
            weight: 1,
            quality: 1,
            amount: [min: 8, max: 19]
        ]
    ],

    /* LEGENDARY */
    legendary: [
        'minecraft:totem_of_undying': [ /* Totem of Undying */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'techguns:itemshared': [ /* Pistol Rounds */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: [min: 6, max: 34]
        ],
        'techguns:itemshared': [ /* Shotgun Rounds */
            meta: 2,
            weight: 1,
            quality: 1,
            amount: [min: 4, max: 8]
        ],
        'techguns:itemshared': [ /* Rifle Rounds Stack */
            meta: 8,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 6]
        ],
        'techguns:itemshared': [ /* Sniper Rounds */
            meta: 4,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 5]
        ],
        'techguns:itemshared': [ /* AR Magazine */
            meta: 14,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'techguns:itemshared': [ /* AS50 Magazine */
            meta: 20,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'techguns:as50': [ /* AS50 Sniper Rifle */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],

        'minecraft:bone_block': [ /* Bone Block */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:anvil': [ /* Anvil */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:anvil': [ /* Slightly Damaged Anvil */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:diamond': [ /* Diamond */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:iron_ingot': [ /* Iron Ingot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 6]
        ],
        'minecraft:gold_ingot': [ /* Gold Ingot */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 7]
        ],
        'minecraft:cooked_porkchop': [ /* Cooked Porkchop */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 2, max: 5]
        ],
        'minecraft:bucket': [ /* Bucket */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:ender_pearl': [ /* Ender Pearl */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 6]
        ],
        'minecraft:leather': [ /* Leather */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 6]
        ],
        'minecraft:golden_apple': [ /* Enchanted Golden Apple */
            meta: 1,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:speckled_melon': [ /* Glistering Melon */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 3]
        ],
        'minecraft:spectral_arrow': [ /* Spectral Arrow */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 4]
        ],
        'minecraft:iron_nugget': [ /* Iron Nugget */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 5, max: 12]
        ],
        'minecraft:record_11': [ /* Disc: 11 */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:record_wait': [ /* Disc: Wait */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:emerald': [ /* Emerald */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:redstone_block': [ /* Block of Redstone */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: [min: 1, max: 2]
        ],
        'minecraft:dye': [ /* Lapis Lazuli */
            meta: 4,
            weight: 1,
            quality: 1,
            amount: [min: 3, max: 7]
        ],
        'minecraft:potion': [ /* Potion of Second Chance */
            meta: 0,
            nbt: ['Potion': 'extrautils2:xu2.second.chance'],
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:diamond_horse_armor': [ /* Diamond Horse Armor */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:experience_bottle': [ /* Bottle o' Enchanting */
            meta: 0,
            weight: 1,
            quality: 2,
            amount: [min: 2, max: 4]
        ],
        'enderio:item_rod_of_return': [ /* Rod of Return */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'enderio:item_travel_staff': [ /* Staff of Travelling */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:iron_helmet': [ /* Iron Helmet */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:iron_chestplate': [ /* Iron Chestplate */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:iron_leggings': [ /* Iron Leggings */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'minecraft:iron_boots': [ /* Iron Boots */
            meta: 0,
            weight: 1,
            quality: 1,
            amount: 1
        ],
        'bq_standard:loot_chest': [ /* Loot Chest */
            meta: 101,
            nbt: ['hideLootInfo': (byte) 1],
            weight: 1,
            quality: 1,
            amount: 1
        ]
    ]
]

@groovy.transform.Field def weightModifier = [
    common: 8,
    uncommon: 5,
    rare: 3,
    legendary: 1
]

int getRandomInt(int min, int max) {
    return new Random().nextInt(max - min) + min
}

def lostCitiesLoot(event) {
    def lostCitiesChests = event.loot.getTable('lostcities:chests/lostcitychest').getPool('lostcities:lostcitychest')

    def nameList = []
    lostCitiesChests.setRolls(new RandomValueRange(2, 8))
    lostCityLootTable.each { rarity, contents ->
        contents.each { name, prop ->
            def hasNbt = prop.containsKey('nbt')
            def itemStack = hasNbt 
                ? item(name, prop['meta']).withNbt(prop['nbt']) 
                : item(name, prop['meta']) 
            def amount = (prop["amount"] instanceof Map) 
                ? [prop["amount"]["min"], prop["amount"]["max"]]
                : [prop["amount"], prop["amount"]]
            def extra = ''

            if (nameList.contains(name)) {
                // might be the same meta, but diff NBTs
                extra = (String) (nameList.countBy { it }.count { k, v -> v > 1 })
            }
            nameList << name

            lostCitiesChests.addEntry(event.loot.entryBuilder()
                .name("${name}:${prop['meta']}" + extra)
                .item(itemStack)
                .setCount(amount[0], amount[1])
                .weight(prop['weight'] * weightModifier[rarity])
                .quality(prop['quality'])
                .build()
            )
        }
    }
}