import mods.jei.JEI.addDescription;

# Alternative Neutronium Recipe
mods.nuclearcraft.infuser.addRecipe(<advancedrocketry:productingot:1>, <liquid:neutron> * 500, <avaritia:resource:4>, 4500);

# Modular Machinery
recipes.addShapedMirrored("Advanced Metallurgic Fabricator", 
	<modularmachinery:itemblueprint>.withTag({dynamicmachine: "modularmachinery:advanced_metallurgic_fabricator"}), 
	[[<ore:ingotModularium>, <ore:circuitAdvanced>, <ore:ingotModularium>],
	[<ore:circuitAdvanced>, <ore:paper>, <ore:circuitAdvanced>], 
	[<ore:ingotModularium>, <ore:circuitAdvanced>, <ore:ingotModularium>]]
);

mods.modularmachinery.RecipeBuilder.newBuilder("advanced_metallurgic_fabricator_titanium_ingot", 'advanced_metallurgic_fabricator', 10)
	.addEnergyPerTickInput(50000)
	.addItemOutput(<ore:ingotTitanium>, 2)
	.addItemInput(<ore:oreMagnesium>, 2)
	.addItemInput(<ore:itemSalt>, 4)
	.addItemInput(<ic2:crafting:15>)
	.addFluidInput(<liquid:liquidchlorine> * 500)
	.build();

# Titanium Tooltip
addDescription(<libvulpes:productingot:7>, "Obtainable through the Advanced Metallurgic Fabricator.");
	<libvulpes:productingot:7>.addTooltip(format.red("(Obtainable through the Advanced Metallurgic Fabricator)"));