import net.minecraftforge.fluids.capability.CapabilityFluidHandler
import com.cleanroommc.groovyscript.helper.ingredient.GroovyScriptCodeConverter
import net.minecraftforge.event.entity.player.ItemTooltipEvent

def oredictElements = [
    /* Iron */           'Fe':  [ 'blockIron', 'oreIron', 'oreNetherIron', 'oreEndIron', 'nuggetIron', 'ingotIron', 'shardIron', 'crystalIron', 'clumpIron', 'dustIron', 'dustDirtyIron', 'crushedIron', 'crushedPurifiedIron', 'dustTinyIron', 'dustSmallIron' ],
    /* Gold */           'Au':  [ 'blockGold', 'oreGold', 'oreNetherGold', 'oreEndGold', 'nuggetGold', 'ingotGold', 'shardGold', 'crystalGold', 'clumpGold', 'dustGold', 'dustDirtyGold', 'crushedGold', 'crushedPurifiedGold', 'dustTinyGold', 'dustSmallGold' ],
    /* Carbon */         'C' :  [ 'blockCoal', 'oreCoal', 'oreNetherCoal', 'oreEndCoal', 'nuggetCoal', 'gemCoal', 'dustCoal', 'dustTinyCoal', 'dustSmallCoal',
    /* Diamond */                 'blockDiamond', 'oreDiamond', 'oreNetherDiamond', 'oreEndDiamond', 'nuggetDiamond', 'gemDiamond', 'dustSmallDiamond', 'dustTinyDiamond',
    /* Graphite */                'blockGraphite', 'ingotGraphite', 'dustGraphite',
    /* Hard Carbon */             'ingotHardCarbon'],
    /* Copper */         'Cu':  [ 'blockCopper', 'oreCopper', 'oreNetherCopper', 'oreEndCopper', 'nuggetCopper', 'ingotCopper', 'shardCopper', 'crystalCopper', 'clumpCopper', 'dustCopper', 'dustDirtyCopper', 'crushedCopper', 'crushedPurifiedCopper', 'dustTinyCopper', 'dustSmallCopper' ],
    /* Zinc */           'Zn':  [ 'oreNetherZinc', 'oreEndZinc' ],
    /* Titanium */       'Ti':  [ /*'oreTitanium',*/ 'nuggetTitanium', 'ingotTitanium', 'shardTitanium', 'crystalTitanium', 'clumpTitanium', 'dustTitanium', 'dustDirtyTitanium', 'crushedTitanium', 'crushedPurifiedTitanium', 'dustTinyTitanium', 'dustSmallTitanium' ],
    /* Rutile */         'TiO₂':
                                [ 'oreRutile' ],
    /* Aluminum */       'Al':  [ 'blockAluminum', 'oreAluminum', 'oreNetherAluminum', 'oreEndAluminum', 'nuggetAluminum', 'ingotAluminum', 'shardAluminum', 'crystalAluminum', 'clumpAluminum', 'dustAluminum', 'dustDirtyAluminum', 'crushedAluminum', 'crushedPurifiedAluminum', 'dustTinyAluminum', 'dustSmallAluminum' ],
    /* Iridium */        'Ir':  [ 'blockIridium', 'oreIridium', 'oreNetherIridium', 'oreEndIridium', 'nuggetIridium', 'ingotIridium', 'shardIridium', 'crystalIridium', 'clumpIridium', 'dustIridium', 'dustDirtyIridium', 'crushedIridium', 'crushedPurifiedIridium', 'dustTinyIridium', 'dustSmallIridium' ],
    /* Lead */           'Pb':  [ 'blockLead', 'oreLead', 'oreNetherLead', 'oreEndLead', 'nuggetLead', 'ingotLead', 'shardLead', 'crystalLead', 'clumpLead', 'dustLead', 'dustDirtyLead', 'crushedLead', 'crushedPurifiedLead', 'dustTinyLead', 'dustSmallLead' ],
    /* Mithril */        'Mi':  [ 'blockMithril', 'oreMithril', 'oreNetherMithril', 'oreEndMithril', 'nuggetMithril', 'ingotMithril', 'shardMithril', 'crystalMithril', 'clumpMithril', 'dustMithril', 'crushedMithril', 'crushedPurifiedMithril', 'dustTinyMithril', 'dustSmallMithril' ],
    /* Nickel */         'Ni':  [ 'blockNickel', 'oreNickel', 'oreNetherNickel', 'oreEndNickel', 'nuggetNickel', 'ingotNickel', 'shardNickel', 'crystalNickel', 'clumpNickel', 'dustNickel', 'dustDirtyNickel', 'crushedNickel', 'crushedPurifiedNickel', 'dustTinyNickel', 'dustSmallNickel' ],
    /* Platinum */       'Pt':  [ 'blockPlatinum', 'orePlatinum', 'oreNetherPlatinum', 'oreEndPlatinum', 'nuggetPlatinum', 'ingotPlatinum', 'shardPlatinum', 'crystalPlatinum', 'clumpPlatinum', 'dustPlatinum', 'dustDirtyPlatinum', 'crushedPlatinum', 'crushedPurifiedPlatinum', 'dustTinyPlatinum', 'dustSmallPlatinum' ],
    /* Silver */         'Ag':  [ 'blockSilver', 'oreSilver', 'oreNetherSilver', 'oreEndSilver', 'nuggetSilver', 'ingotSilver', 'shardSilver', 'crystalSilver', 'clumpSilver', 'dustSilver', 'dustDirtySilver', 'crushedSilver', 'crushedPurifiedSilver', 'dustTinySilver', 'dustSmallSilver' ],
    /* Tin */            'Sn':  [ 'blockTin', 'oreTin', 'oreNetherTin', 'oreEndTin', 'nuggetTin', 'ingotTin', 'shardTin', 'crystalTin', 'clumpTin', 'dustTin', 'dustDirtyTin', 'crushedTin', 'crushedPurifiedTin', 'dustTinyTin', 'dustSmallTin' ],
    /* Certus */         'Cq':  [ 'oreCertusQuartz', 'oreNetherCertusQuartz', 'oreEndCertusQuartz', 'gemCertusQuartz', 'gemChargedCertusQuartz', 'dustCertusQuartz', 'crystalPureCertusQuartz', '' ],
    /* Osmium */         'Os':  [ 'blockOsmium', 'oreOsmium', 'oreNetherOsmium', 'oreEndOsmium', 'nuggetOsmium', 'ingotOsmium', 'shardOsmium', 'crystalOsmium', 'clumpOsmium', 'dustOsmium', 'dustDirtyOsmium', 'crushedOsmium', 'crushedPurifiedOsmium', 'dustTinyOsmium', 'dustSmallOsmium' ],
    /* Uranium */        'U' :  [ 'blockUranium', 'oreUranium', 'oreNetherUranium', 'oreEndUranium', 'nuggetUranium', 'ingotUranium', 'shardUranium', 'crystalUranium', 'clumpUranium', 'dustUranium', 'dustDirtyUranium', 'crushedUranium', 'crushedPurifiedUranium', 'dustTinyUranium', 'dustSmallUranium' ],
    /* Thorium */        'Th':  [ 'blockThorium', 'oreThorium', 'nuggetThorium', 'ingotThorium', 'shardThorium', 'crystalThorium', 'clumpThorium', 'dustThorium', 'dustDirtyThorium', 'crushedThorium', 'crushedPurifiedThorium', 'dustTinyThorium', 'dustSmallThorium' ],
    /* Boron */          'B' :  [ 'blockBoron', 'oreBoron', 'nuggetBoron', 'ingotBoron', 'shardBoron', 'crystalBoron', 'clumpBoron', 'dustBoron', 'dustDirtyBoron', 'crushedBoron', 'crushedPurifiedBoron', 'dustTinyBoron', 'dustSmallBoron' ],
    /* Lithium */        'Li':  [ 'blockLithium', 'oreLithium', 'nuggetLithium', 'ingotLithium', 'shardLithium', 'crystalLithium', 'clumpLithium', 'dustLithium', 'dustDirtyLithium', 'crushedLithium', 'crushedPurifiedLithium', 'dustTinyLithium', 'dustSmallLithium' ],
    /* Magnesium */      'Mg':  [ 'blockMagnesium', 'oreMagnesium', 'nuggetMagnesium', 'ingotMagnesium', 'shardMagnesium', 'crystalMagnesium', 'clumpMagnesium', 'dustMagnesium', 'dustDirtyMagnesium', 'crushedMagnesium', 'crushedPurifiedMagnesium', 'dustTinyMagnesium', 'dustSmallMagnesium' ],
    /* Beryllium */      'Be':  [ 'blockBeryllium', 'ingotBeryllium', 'dustBeryllium'],
    /* Zirconium */      'Zr':  [ 'blockZirconium', 'ingotZirconium', 'dustZirconium'],
    /* Manganese */      'Mn':  [ 'blockManganese', 'ingotManganese', 'dustManganese'],
    /* Arsenic */        'As':  [ 'dustArsenic' ],
    /* Draconium */      'Dr':  [ 'blockDraconium', 'oreDraconium', 'nuggetDraconium' , 'ingotDraconium', 'shardDraconium', 'crystalDraconium', 'clumpDraconium', 'dustDraconium', 'dustDirtyDraconium', 'crushedDraconium', 'crushedPurifiedDraconium', 'dustTinyDraconium', 'dustSmallDraconium'],
    /* Dilithium */      'Dl':  [ 'blockDilithium', 'oreDilithium', 'oreNetherDilithium', 'oreEndDilithium', 'nuggetDilithium', 'gemDilithium', 'dustDilithium', 'dustTinyDilithium', 'dustSmallDilithium' ],
    /* Emerald */        'Be₃Al₂(SiO₃)₆':
                                [ 'blockEmerald', 'oreEmerald', 'oreNetherEmerald', 'oreEndEmerald', 'nuggetEmerald', 'gemEmerald', 'dustEmerald', 'dustTinyEmerald', 'dustSmallEmerald' ],
    /* Lapis */          'Lp':  [ 'blockLapis', 'oreLapis', 'oreNetherLapis', 'oreEndLapis', 'nuggetLapis', 'gemLapis', 'dustLapis', 'dustTinyLapis', 'dustSmallLapis' ],
    /* Redstone */       'Rs':  [ 'blockRedstone', 'oreRedstone', 'oreNetherRedstone', 'oreEndRedstone', 'dustRedstone', 'dustTinyRedstone', 'dustSmallRedstone' ],
    /* Quartz */         'SiO₂' :
                                [ 'blockQuartz', 'oreQuartz', 'nuggetQuartz', 'gemQuartz', 'dustQuartz', 'dustTinyQuartz', 'dustSmallQuartz',
    /* Obsidian */                'dustObsidian', 'dustTinyObsidian',
    /* IC2 SiO₂ */                'dustSiliconDioxide' ],
    /* Glowstone */      'Gs':  [ 'blockGlowstone', 'dustGlowstone' ],
    /* Ender */          'En':  [ 'materialEnderPearl', 'dustEnder' ],
    /* Cobalt */         'Co':  [ 'blockCobalt', 'oreCobalt', 'nuggetCobalt', 'ingotCobalt', 'shardCobalt', 'crystalCobalt', 'clumpCobalt', 'dustCobalt', 'dustDirtyCobalt', 'crushedCobalt', 'crushedPurifiedCobalt', 'dustTinyCobalt', 'dustSmallCobalt' ],
    /* Ardite */         'Ad':  [ 'blockArdite', 'oreArdite', 'nuggetArdite', 'ingotArdite', 'shardArdite', 'crystalArdite', 'clumpArdite', 'dustArdite', 'dustDirtyArdite', 'crushedArdite', 'crushedPurifiedArdite', 'dustTinyArdite', 'dustSmallArdite' ],
    /* Silicon */        'Si':  [ 'nuggetSilicon', 'itemSilicon', 'dustSilicon' ],
    /* Neutronium */     'Nu':  [ 'blockCosmicNeutronium', 'nuggetCosmicNeutronium', 'ingotCosmicNeutronium' ],

    /* --- Alloys --- */
    /* Steel */ 'Fe•C':
                    [ 'blockSteel', 'nuggetSteel', 'ingotSteel', 'dustSteel' ],
    /* Electrum */ 'Au•Ag':
                    [ 'blockElectrum', 'nuggetElectrum', 'ingotElectrum', 'dustElectrum' ],
    /* Invar */ 'Fe•Ni':
                    [ 'blockInvar', 'nuggetInvar', 'ingotInvar', 'dustInvar' ],
    /* Bronze */ 'Cu•Sn':
                    [ 'blockBronze', 'nuggetBronze', 'ingotBronze', 'dustBronze' ],
    /* Constantan */ 'Cu•Ni':
                    [ 'blockConstantan', 'nuggetConstantan', 'ingotConstantan', 'dustConstantan' ],
    /* Signalum */ 'Cu•Ag•Rs':
                    [ 'blockSignalum', 'nuggetSignalum', 'ingotSignalum', 'dustSignalum' ],
    /* Lumium */ 'Cu•Sn•Gs':
                    [ 'blockLumium', 'nuggetLumium', 'ingotLumium', 'dustLumium' ],
    /* Enderium */ 'Pb•Pt•En':
                    [ 'blockEnderium', 'nuggetEnderium', 'ingotEnderium', 'dustEnderium' ],
    /* Tough Alloy */ '(Fe•B)•Li':
                    [ 'ingotTough' ],
    /* Ferroboron */ 'Fe•B':
                    [ 'ingotFerroboron' ],
    /* Shibuichi */ 'Ag•Cu':
                    [ 'ingotShibuichi' ],
    /* Tin Silver */ 'Sn•Ag':
                    [ 'ingotTinSilver' ],
    /* Lead Platinum */ 'Pb•Pt':
                    [ 'ingotLeadPlatinum' ],
    /* Extreme Alloy */ 'C•((Fe•B)•Li)':
                    [ 'ingotExtreme' ],
    /* Thermoconducting Alloy */ '(C•((Fe•B)•Li)•(B•As)':
                    [ 'ingotThermoconducting' ],
    /* Zircaloy */ 'Zr•Sn':
                    [ 'ingotZircaloy' ],
    /* HSLA Steel */ 'Fe•(C•Mn)':
                    [ 'ingotHSLASteel' ],
    /* Enderium Base */ '~(Pb•Pt•En)':
                    [ 'ingotEnderiumBase' ],
    /* Electrical Steel */ '(Fe•C)•Si':
                    [ 'blockElectricalSteel', 'nuggetElectricalSteel', 'ingotElectricalSteel' ],
    /* Energetic Alloy */ 'Rs•Au•Gs':
                    [ 'blockEnergeticAlloy', 'nuggetEnergeticAlloy', 'ingotEnergeticAlloy', 'dustEnergetic' ],
    /* Vibrant Alloy */ '(Rs•Au•Gs)•En':
                    [ 'blockVibrantAlloy', 'nuggetVibrantAlloy', 'ingotVibrantAlloy' ],
    /* Redstone Alloy */ 'Rs•Si':
                    [ 'blockRedstoneAlloy', 'nuggetRedstoneAlloy', 'ingotRedstoneAlloy' ],
    /* Conductive Iron */ 'Rs•Fe':
                    [ 'blockConductiveIron', 'nuggetConductiveIron', 'ingotConductiveIron' ],
    /* Pulsating Iron */ 'Fe•En':
                    [ 'blockPulsatingIron', 'nuggetPulsatingIron', 'ingotPulsatingIron' ],
    /* Dark Steel */ '(Fe•C)•SiO₂':
                    [ 'blockDarkSteel', 'nuggetDarkSteel', 'ingotDarkSteel',
                      'ingotObsidianSteel' ],
    /* Soularium */ '??•Au':
                    [ 'blockSoularium', 'nuggetSoularium', 'ingotSoularium', 'dustSoularium' ],
    /* End Steel */ '??•((Fe•C)•SiO₂)•SiO₂':
                    [ 'blockEndSteel', 'nuggetEndSteel', 'ingotEndSteel' ],
    /* Iron Alloy */ '(Cu/Pb)•Fe•(Al/Ag/Cu/Sn/Ni/Pt/Os/Ad/Co/Ti/Mg/Pb)':
                    [ 'blockConstructionAlloy', 'nuggetConstructionAlloy', 'ingotConstructionAlloy' ],
    /* Crude Steel */ '~(Fe•C)':
                    [ 'blockCrudeSteel', 'nuggetCrudeSteel', 'ingotCrudeSteel' ],
    /* Energetic Silver */ 'Ag•(Rs•Gs)':
                    [ 'blockEnergeticSilver', 'nuggetEnergeticSilver', 'ingotEnergeticSilver' ],
    /* Vivid Alloy */ '(Ag•(Rs•Gs))•En':
                    [ 'blockVividAlloy', 'nuggetVividAlloy', 'ingotVividAlloy' ],
    /* Manyullyn */ 'Co•Ad':
                    [ 'blockManyullyn', 'nuggetManyullyn', 'ingotManyullyn' ],
    /* Osgloglas */ '(Gs•Os)•(SiO₂•Os)•Os':
                    [ 'blockOsgloglas', 'nuggetOsgloglas', 'ingotOsgloglas' ],
    /* Osmiridium */ 'Os•Ir':
                    [ 'blockOsmiridium', 'nuggetOsmiridium', 'ingotOsmiridium' ],
    /* Alumite */ 'Al•Fe•SiO₂':
                    [ 'blockAlumitelas', 'nuggetAlumite', 'ingotAlumite' ],
    /* Titanium Iridium */ 'Ti•Ir':
                    [ 'blockTitaniumIridium', 'nuggetTitaniumIridium', 'ingotTitaniumIridium', 'dustTitaniumIridium' ],
    /* Titanium Aluminide */ 'Ti•Al':
                    [ 'blockTitaniumAluminide', 'nuggetTitaniumAluminide', 'ingotTitaniumAluminide', 'dustTitaniumAluminide' ],

    /* --- Compounds --- */
    /* Thorium Oxide */ 'ThO₂':
                    [ 'ingotThoriumOxide', 'dustThoriumOxide' ],
    /* Uranium Oxide */ 'UO₂':
                    [ 'ingotUraniumOxide', 'dustUraniumOxide' ],
    /* Manganese Oxide */ 'MnO':
                    [ 'ingotManganeseOxide', 'dustManganeseOxide' ],
    /* Manganese Dioxide */ 'MnO₂':
                    [ 'ingotManganeseDioxide', 'dustManganeseDioxide' ],
    /* Magnesium Diboride */ 'MgB₂':
                    [ 'ingotMagnesiumDiboride' ],
    /* Silicon Carbide */ 'SiC':
                    [ 'ingotSiliconCarbide' ],
    /* SiC-SiC Ceramic Matrix Composite */ 'SiC⊕SiC':
                    [ 'ingotSiCSiCCMC' ],
    /* Boron Nitride */ 'BN':
                    [ 'gemBoronNitride', 'dustBoronNitride' ],
    /* Villiaumite */ 'NaF':
                    [ 'gemVilliaumite', 'dustVilliaumite' ],
    /* Carobbiite */ 'KF':
                    [ 'gemCarobbiite', 'dustCarobbiite' ],
    /* Calcium Sulfate */ 'CaSO₄':
                    [ 'dustCalciumSulfate' ],
    /* Rhodochrosite */ 'MnCO₃':
                    [ 'gemRhodochrosite', 'dustRhodochrosite' ],
    /* Sodium Fluoride */ 'NaF':
                    [ 'dustSodiumFluoride' ],
    /* Potassium Fluoride */ 'KF':
                    [ 'dustPotassiumFluoride' ],
    /* Sodium Hydroxide */ 'NaOH':
                    [ 'dustSodiumHydroxide' ],
    /* Potassium Hydroxide */ 'KOH':
                    [ 'dustPotassiumHydroxide' ],
    /* Borax */ 'Na₂B₄O₇•10H₂O':
                    [ 'dustBorax' ],
    /* Salt */ 'NaCl':
                    [ 'blockSalt', 'itemSalt' ],
    /* Fluorite */ 'CaF₂':
                    [ 'gemFluorite', 'dustFluorite' ],
    /* Sugar */ 'C₁₂H₂₂O₁₁':
                    [ 'itemSugar' ],

    /* --- Composite --- */
    /* Refined Glowstone */ 'Gs•Os':
                    [ 'blockRefinedGlowstone', 'nuggetRefinedGlowstone', 'ingotRefinedGlowstone' ],
    /* Refined Obsidian */ '(SiO₂)•Os':
                    [ 'blockRefinedObsidian', 'nuggetRefinedObsidian', 'ingotRefinedObsidian', 'dustRefinedObsidian' ],
    /* Carbon-Manganese Blend */ 'C•Mn':
                    [ 'dustCarbonManganese' ],

    /* --- NuclearCraft --- */
    /* - Usable - */
    '²³⁰Th'   : [                              'ingotThorium230',     'nuggetThorium230'    ], '²³⁰ThO₂': [                                        'ingotThorium230Oxide',     'nuggetThorium230Oxide'    ],                                                                        /* - Usable Oxides - */
    '²³²Th'   : ['fuelTBU',                    'ingotThorium232',     'nuggetThorium232'    ], '²³²ThO₂': ['fuelTBUOxide',                         'ingotThoriumOxide',        'nuggetThoriumOxide'       ],
    '²³³U'    : ['fuelHEU233',  'fuelLEU233',  'ingotUranium233',     'nuggetUranium233'    ], '²³³UO₂' : ['fuelHEU233Oxide',  'fuelLEU233Oxide',  'ingotUranium233Oxide',     'nuggetUranium233Oxide'    ],
    '²³⁵U'    : ['fuelHEU235',  'fuelLEU235',  'ingotUranium235',     'nuggetUranium235'    ], '²³⁵UO₂' : ['fuelHEU235Oxide',  'fuelLEU235Oxide',  'ingotUranium235Oxide',     'nuggetUranium235Oxide'    ],
    '²³⁸U'    : [                              'ingotUranium238',     'nuggetUranium238'    ], '²³⁸UO₂' : [                                        'ingotUranium238Oxide',     'nuggetUranium238Oxide'    ],
    '²³⁶Np'   : ['fuelLEN236',  'fuelHEN236',  'ingotNeptunium236',   'nuggetNeptunium236'  ], '²³⁶NpO₂': ['fuelLEN236Oxide',  'fuelHEN236Oxide',  'ingotNeptunium236Oxide',   'nuggetNeptunium236Oxide'  ],
    '²³⁷Np'   : [                              'ingotNeptunium237',   'nuggetNeptunium237'  ], '²³⁷NpO₂': [                                        'ingotNeptunium237Oxide',   'nuggetNeptunium237Oxide'  ],
    '²³⁸Pu'   : [                              'ingotPlutonium238',   'nuggetPlutonium238'  ], '²³⁸PuO₂': [                                        'ingotPlutonium238Oxide',   'nuggetPlutonium238Oxide'  ],
    '²³⁹Pu'   : ['fuelLEP239',  'fuelHEP239',  'ingotPlutonium239',   'nuggetPlutonium239'  ], '²³⁹PuO₂': ['fuelLEP239Oxide',  'fuelHEP239Oxide',  'ingotPlutonium239Oxide',   'nuggetPlutonium239Oxide'  ],
    '²⁴¹Pu'   : ['fuelLEP241',  'fuelHEP241',  'ingotPlutonium241',   'nuggetPlutonium241'  ], '²⁴¹PuO₂': ['fuelLEP241Oxide',  'fuelHEP241Oxide',  'ingotPlutonium241Oxide',   'nuggetPlutonium241Oxide'  ],
    '²⁴²Pu'   : [                              'ingotPlutonium242',   'nuggetPlutonium242'  ], '²⁴²PuO₂': [                                        'ingotPlutonium242Oxide',   'nuggetPlutonium242Oxide'  ],
    '²⁴¹Am'   : [                              'ingotAmericium241',   'nuggetAmericium241'  ], '²⁴¹AmO₂': [                                        'ingotAmericium241Oxide',   'nuggetAmericium241Oxide'  ],
    '²⁴²Am'   : ['fuelLEA242',  'fuelHEA242',  'ingotAmericium242',   'nuggetAmericium242'  ], '²⁴²AmO₂': ['fuelLEA242Oxide',  'fuelHEA242Oxide',  'ingotAmericium242Oxide',   'nuggetAmericium242Oxide'  ],
    '²⁴³Am'   : [                              'ingotAmericium243',   'nuggetAmericium243'  ], '²⁴³AmO₂': [                                        'ingotAmericium243Oxide',   'nuggetAmericium243Oxide'  ],
    '²⁴³Cm'   : ['fuelHECm243', 'fuelLECm243', 'ingotCurium243',      'nuggetCurium243'     ], '²⁴³CmO₂': ['fuelHECm243Oxide', 'fuelLECm243Oxide', 'ingotCurium243Oxide',      'nuggetCurium243Oxide'     ],
    '²⁴⁵Cm'   : ['fuelHECm245', 'fuelLECm245', 'ingotCurium245',      'nuggetCurium245'     ], '²⁴⁵CmO₂': ['fuelHECm245Oxide', 'fuelLECm245Oxide', 'ingotCurium245Oxide',      'nuggetCurium245Oxide'     ],
    '²⁴⁶Cm'   : [                              'ingotCurium246',      'nuggetCurium246'     ], '²⁴⁶CmO₂': [                                        'ingotCurium246Oxide',      'nuggetCurium246Oxide'     ],
    '²⁴⁷Cm'   : ['fuelHECm247', 'fuelLECm247', 'ingotCurium247',      'nuggetCurium247'     ], '²⁴⁷CmO₂': ['fuelHECm247Oxide', 'fuelLECm247Oxide', 'ingotCurium247Oxide',      'nuggetCurium247Oxide'     ],
    '²⁴⁷Bk'   : [                              'ingotBerkelium247',   'nuggetBerkelium247'  ], '²⁴⁷BkO₂': [                                        'ingotBerkelium247Oxide',   'nuggetBerkelium247Oxide'  ],
    '²⁴⁸Bk'   : ['fuelHEB248',  'fuelLEB248',  'ingotBerkelium248',   'nuggetBerkelium248'  ], '²⁴⁸BkO₂': ['fuelHEB248Oxide',  'fuelLEB248Oxide',  'ingotBerkelium248Oxide',   'nuggetBerkelium248Oxide'  ],
    '²⁴⁹Cf'   : ['fuelHECf249', 'fuelLECf249', 'ingotCalifornium249', 'nuggetCalifornium249'], '²⁴⁹CfO₂': ['fuelHECf249Oxide', 'fuelLECf249Oxide', 'ingotCalifornium249Oxide', 'nuggetCalifornium249Oxide'],
    '²⁵⁰Cf'   : [                              'ingotCalifornium250', 'nuggetCalifornium250'], '²⁵⁰CfO₂': [                                        'ingotCalifornium250Oxide', 'nuggetCalifornium250Oxide'],
    '²⁵¹Cf'   : ['fuelLECf251', 'fuelHECf251', 'ingotCalifornium251', 'nuggetCalifornium251'], '²⁵¹CfO₂': ['fuelLECf251Oxide', 'fuelHECf251Oxide', 'ingotCalifornium251Oxide', 'nuggetCalifornium251Oxide'],
    '²⁵²Cf'   : [                              'ingotCalifornium252', 'nuggetCalifornium252'], '²⁵²CfO₂': [                                        'ingotCalifornium252Oxide', 'nuggetCalifornium252Oxide'],

    /* - Depleted - */                                                                         /* - Depleted Oxides - */
    '~(²⁵¹Cf)': ['depletedFuelLECf251', 'depletedFuelHECf251'],                                '~(²⁵¹Cf)O₂': ['depletedFuelLECf251Oxide', 'depletedFuelHECf251Oxide'],
    '~(²³⁵U)' : ['depletedFuelHEU235',  'depletedFuelLEU235' ],                                '~(²³⁵U)O₂' : ['depletedFuelHEU235Oxide',  'depletedFuelLEU235Oxide'],
    '~(²⁴²Am)': ['depletedFuelLEA242',  'depletedFuelHEA242' ],                                '~(²⁴²Am)O₂': ['depletedFuelLEA242Oxide',  'depletedFuelHEA242Oxide'],
    '~(²³⁶Np)': ['depletedFuelLEN236',  'depletedFuelHEN236' ],                                '~(²³⁶Np)O₂': ['depletedFuelLEN236Oxide',  'depletedFuelHEN236Oxide'],
    '~(²³²Th)': ['depletedFuelTBU'],                                                           '~(²³²Th)O₂': ['depletedFuelTBUOxide'],
    '~(²⁴³Cm)': ['depletedFuelHECm243', 'depletedFuelLECm243'],                                '~(²⁴³Cm)O₂': ['depletedFuelHECm243Oxide', 'depletedFuelLECm243Oxide'],
    '~(²⁴⁷Cm)': ['depletedFuelLECm247', 'depletedFuelHECm247'],                                '~(²⁴⁷Cm)O₂': ['depletedFuelLECm247Oxide', 'depletedFuelHECm247Oxide'],
    '~(²⁴⁸Bk)': ['depletedFuelLEB248',  'depletedFuelHEB248' ],                                '~(²⁴⁸Bk)O₂': ['depletedFuelLEB248Oxide',  'depletedFuelHEB248Oxide'],
    '~(²³³U)' : ['depletedFuelHEU233',  'depletedFuelLEU233' ],                                '~(²³³U)O₂' : ['depletedFuelHEU233Oxide',  'depletedFuelLEU233Oxide'],
    '~(²⁴⁵Cm)': ['depletedFuelLECm245', 'depletedFuelHECm245'],                                '~(²⁴⁵Cm)O₂': ['depletedFuelLECm245Oxide', 'depletedFuelHECm245Oxide'],
    '~(²³⁹Pu)': ['depletedFuelHEP239',  'depletedFuelLEP239' ],                                '~(²³⁹Pu)O₂': ['depletedFuelHEP239Oxide',  'depletedFuelLEP239Oxide'],
    '~(²⁴¹Pu)': ['depletedFuelLEP241',  'depletedFuelHEP241' ],                                '~(²⁴¹Pu)O₂': ['depletedFuelLEP241Oxide',  'depletedFuelHEP241Oxide'],
    '~(²⁴⁹Cf)': ['depletedFuelHECf249', 'depletedFuelLECf249'],                                '~(²⁴⁹Cf)O₂': ['depletedFuelHECf249Oxide', 'depletedFuelLECf249Oxide'],
]

def liquidsElements = [
    /* Water */ 'water': 'H₂O',
    /* Lava */ 'lava': 'SiO₂⊕Al₂O₃⊕FeO⊕MgO⊕CaO',
    /* Protein */ 'if.protein': '',
    /* Enriched Lava */ 'enrichedlava': 'SiO₂⊕Al₂O₃⊕FeO⊕MgO⊕CaO',
//  /* Vapor of Levity */ '': '',
    /* Manganese Dioxide */ 'manganese_dioxide': 'MnO₂',
    /* Arsenic */ 'arsenic': 'As',
    /* Corium */ 'corium': 'U•Zr•Si•O',
    /* Sodium */ 'sodium': 'Na',
    /* Aluminum Brass */ 'alubrass': 'Al•(Cu•Zn)',
    /* IC2 Steam */ 'ic2steam': 'H₂O(g)',
    /* Mek Steam */ 'steam': 'H₂O(g)',
    /* Redstone Alloy */ 'redstone_alloy': 'Rs•Si',
    /* Nitrogen */ 'nitrogen': 'N',
    /* Liquid Nitrogen */ 'liquid_nitrogen': 'N₂',
    /* Gold */ 'gold': 'Au',
    /* Constantan */ 'constantan': 'Cu•Ni',
    /* Deuterium */ 'deuterium': '²H',
    /* Vivid */ 'vivid_alloy': '(Ag•(Rs•Gs))•En',
    /* Emerald */ 'emerald': 'Be₃Al₂(SiO₃)₆',
    /* Draconium */ 'draconium': 'Dr',
    /* Tritium */ 'tritium': '³H',
    /* Boric Acid */ 'boric_acid': 'H₃BO₃',
    /* Fluoromethane */ 'fluoromethane': 'CH₃F',
    /* Refined Fuel */ 'refined_fuel': '(C₇H₁₆)•S',
    /* Sulfuric Acid */ 'sulfuric_acid': 'H₂SO₄',
    /* Lithium-7 */ 'lithium7': '⁷Li',
    /* Distilled Water */ 'ic2distilled_water': 'H₂O',
    /* Nickel */ 'nickel': 'Ni',
    /* Concentrated Cloud Seed */ 'cloud_seed_concentrated': 'Ag•[Ag/(Au•Ag)/NaCl/Al₂Si₂O₅(OH)₄](aq)',
    /* Fluorine */ 'fluorine': 'F₂',
    /* Fluorite Water */ 'fluorite_water': 'CaF₂(aq)',
    /* Neutron Fluid */ 'neutron': 'Nu(aq)',
    /* Silicon Carbide Vapor */ 'sic_vapor': 'SiC(g)',
    /* Refined Obsidian */ 'refinedobsidian': '(SiO₂)•Os',
    /* Lithium-6 */ 'lithium6': '⁶Li',
    /* Electrum */ 'electrum': 'Au•Ag',
    /* Quartz */ 'quartz': 'SiO₂',
    /* Lithium Fluoride */ 'lif': 'LiF',
    /* Lead */ 'lead': 'Pb',
    /* Naphtha */ 'refined_oil': 'C₇H₁₆',
    /* IC2 Heavy Water */ 'ic2heavy_water': 'D₂O',
    /* Mek Heavy Water */ 'heavywater': 'D₂O',
    /* Energetic Silver */ 'energetic_silver': 'Ag•(Rs•Gs)',
    /* Invar */ 'invar': 'Fe•Ni',
    /* RadAway */ 'radaway': 'Gs₃(C₂H₆O)',
    /* Iridium */ 'iridium': 'Ir',
    /* Tin */ 'tin': 'Sn',
    /* Air */ 'ic2air': 'N₂•O₂•Ar•CO₂',
    /* Low Pressure Steam */ 'low_pressure_steam': 'H₂O(g)',
    /* Potassium Hydroxide Solution */ 'potassium_hydroxide_solution': 'KOH(aq)',
    /* Potassium Hydroxide */ 'koh': 'KOH',
    /* Glass */ 'glass': 'SiO₂',
    /* Obsidian */ 'obsidian': 'SiO₂',
    /* Rocket Fuel */ 'rocketfuel': 'H₂+O₂',
    /* Rocket Fuel */ 'rocket_fuel': '??•(Rs+(KNO₃+C+S))(aq)',
    /* Pahoehoe Lava */ 'ic2pahoehoe_lava': 'SiO₂•FeO•MgO',
    /* Hard Carbon */ 'hard_carbon': 'C',
    /* Sulfur Dioxide */ 'sulfur_dioxide': 'SO₂',
    /* Diborane */ 'diborane': 'B₂H₆',
    /* Ardite */ 'ardite': 'Ad',
    /* Sulfur */ 'sulfur': 'S',
    /* Preheated Water */ 'preheated_water': 'H₂O',
    /* Boron-10 */ 'boron10': '¹⁰B',
    /* Destabilized Redstone */ 'redstone': 'Rs',
    /* Diamond */ 'diamond': 'C',
    /* Crude Oil */ 'crude_oil': 'C₈H₁₈',
    /* Bronze */ 'bronze': 'Cu•Sn',
    /* Aluminum */ 'aluminum': 'Al',
    /* Boron Arsenide */ 'bas': 'BAs',
    /* Magnesium */ 'magnesium': 'Mg',
    /* IC2 Coolant */ 'ic2coolant': 'H₂O+Lp',
    /* Osgloglas */ 'osgloglas': '(Gs•Os)•(SiO₂•Os)•Os',
    /* Helium-3 */ 'helium3': '³He',
    /* Boron */ 'boron': 'B',
    /* Carbon Dioxide */ 'carbon_dioxide': 'CO₂',
    /* Cobalt */ 'cobalt': 'Co',
    /* Borax Solution */ 'borax_solution': 'Na₂B₄O₇•10H₂O(aq)',
    /* NC Lithium */ 'lithium': 'Li',
    /* Mek Lithium */ 'liquidlithium': 'Li',
    /* Methanol */ 'methanol': 'CH₃OH',
    /* Uranium */ 'uranium': 'U',
    /* Slow-Acting RadAway */ 'radaway_slow': '(Gs₃(C₂H₆O))+Rs',
    /* Brine */ 'brine': 'NaCl(aq)',
    /* Titanium */ 'titanium': 'Ti',
    /* Copper */ 'copper': 'Cu',
    /* FLiBe */ 'flibe': 'LiF•BeF₂',
    /* IC2 Hydrogen */ 'ic2hydrogen': 'H₂',
    /* NC Hydrogen */ 'hydrogen': 'H₂',
    /* Ammonia */ 'ammonia': 'NH₃',
    /* Alumite */ 'alumite': 'Al•Fe•SiO₂',
    /* Creosote */ 'ic2creosote': 'C₁₀H₈O',
    /* Conductive Iron */ 'conductive_iron': 'Rs•Fe',
    /* Cloud Seed */ 'cloud_seed': 'Ag•[Ag/(Au•Ag)/NaCl/Al₂Si₂O₅(OH)₄](aq)',
    /* Boron-11 */ 'boron11': '¹¹B',
    /* Osmiridium */ 'osmiridium': 'Os•Ir',
    /* Steel */ 'steel': 'Fe•C',
    /* Ethanol */ 'ethanol': 'C₂H₅OH',
    /* Condensate Water */ 'condensate_water': 'H₂O(l)',
    /* Liq Helium */ 'liquidhelium': 'He',
    /* Gas Helium */ 'helium': 'He',
    /* Platinum */ 'platinum': 'Pt',
    /* Refined Glowstone */ 'refinedglowstone': 'Gs•Os',
    /* Oxygen */ 'oxygen': 'O₂',
    /* Silver */ 'silver': 'Ag',
    /* Superheated Steam */ 'ic2superheated_steam': 'H₂O',
    /* Manyullyn */ 'manyullyn': 'Co•Ad',
    /* Sulfur Trioxide */ 'sulfur_trioxide': 'SO₃',
    /* Iron Alloy */ 'construction_alloy': '(Cu/Pb)•Fe•(Al/Ag/Cu/Sn/Ni/Pt/Os/Ad/Co/Ti/Mg/Pb)',
    /* Potassium */ 'potassium': 'K',
    /* Energized Glowstone */ 'glowstone': 'Gs',
    /* Enderium */ 'enderium': 'Pb•Pt•En',
    /* Hydrofluoric Acid */ 'hydrofluoric_acid': 'HF',
    /* Sodium Hydroxide */ 'naoh': 'NaOH',
    /* Sodium Hydroxide Solution */ 'sodium_hydroxide_solution': 'NaOH(aq)',
    /* Potassium Fluoride */ 'potassium_fluoride_solution': 'KF',
    /* Vibrant Alloy */ 'vibrant_alloy': '(Rs•Au•Gs)•En',
    /* Energetic Alloy */ 'energetic_alloy': 'Rs•Au•Gs',
    /* Low Quality Steam */ 'low_quality_steam': 'H₂O(g)',
    /* Purified Water */ 'purifiedwater': 'H₂O',
    /* Iron */ 'iron': 'Fe',
    /* Carbon Monoxide */ 'carbon_monoxide': 'CO',
    /* Electrical Steel */ 'electrical_steel': '(Fe•C)•Si',
    /* Boron Nitride */ 'boron_nitride_solution': 'BN',
    /* Calcium Sulfate */ 'calsium_sulfate_solution': 'CaSO₄',
    /* Biogas */ 'ic2biogas': 'CH₄•CO₂',
    /* Crude Steel */ 'crude_steel': '~(Fe•C)',
    /* Lapis */ 'lapis': 'Lp',
    /* Creosote Oil */ 'creosote': 'C₁₀H₈O',
    /* End Steel */ 'end_steel': '??•((Fe•C)•SiO₂)•SiO₂',
    /* Sodium Fluoride */ 'sodium_fluoride_solution': 'NaF(aq)',
    /* Osmium */ 'osmium': 'Os',
    /* Liquifacted Coal */ 'coal': 'C',
    /* Lumium */ 'lumium': 'Cu•Sn•Gs',
    /* Tough Alloy */ 'tough': '(Fe•B)•Li',
    /* Ethylene */ 'ethene': 'C₂H₄',
    /* Signalum */ 'signalum': 'Cu•Ag•Rs',
    /* Ferroboron */ 'ferroboron': 'Fe•B',
    /* Oxygen Difluoride */ 'oxygen_difluoride': 'OF₂',
    /* Clay */ 'clay': 'Al₂Si₂O₅(OH)₄',
    /* Latex */ 'latex': '(C₅H₈)n',
    /* Mithril */ 'mithril': 'Mi',
    /* Pulsating Iron */ 'pulsating_iron': 'Fe•En',
    /* Dark Steel */ 'dark_steel': '(Fe•C)•SiO₂',
    /* Beryllium */ 'beryllium': 'Be',
    /* Beryllium Fluoride */ 'bef2': 'BeF₂'
]

// Capabiltiies = [ nak, hot nak ]
def nakCapable = [
    'emerald':            'Be₃Al₂(SiO₃)₆',
    'quartz':             'SiO₂',
    'gold':               'Au',
    'diamond':            'C' ,
    'tin':                'Sn',
    'magnesium':          'Mg',
    'glowstone':          'Gs',
    'liquidhelium':       'He',
    'cryotheum':          '??'  ,
    'iron':               'Fe',
    'copper':             'Cu',
    'lapis':              'Lp',
    'redstone':           'Rs',
    'ender':              'En'
]

// Capabilities: [ flibe, fluoride, molten ]
def isotopes = [
    'americium_241':    '²⁴¹Am',
    'plutonium_238':    '²³⁸Pu',
    'plutonium':        'Pu'   ,
    'plutonium_242':    '²⁴²Pu',
    'curium_246':       '²⁴⁶Cm',
    'californium_250':  '²⁵⁰Cf',
    'thorium':          'Th'   ,
    'uranium_235':      '²³⁵U' ,
    'californium_252':  '²⁵²Cf',
    'americium_242':    '²⁴²Am',
    'plutonium_239':    '²³⁹Pu',
    'uranium_238':      '²³⁸U' ,
    'curium_247':       '²⁴⁷Cm',
    'californium_249':  '²⁴⁹Cf',
    'plutonium_241':    '²⁴¹Pu',
    'curium_245':       '²⁴⁵Cm',
    'californium_251':  '²⁵¹Cf',
    'uranium':          'U'    ,
    'americium_243':    '²⁴³Am',
    'thorium_230':      '²³⁰Th',
    'berkelium_247':    '²⁴⁷Bk',
    'neptunium_237':    '²³⁷Np',
    'curium_243':       '²⁴³Cm',
    'uranium_233':      '²³³U' ,
    'neptunium_236':    '²³⁶Np',
    'berkelium_248':    '²⁴⁸Bk'
]

// Capabilities: [ depleted, molten, flibe(f), depleted flibe, fluoride, depleted fluoride ]
def ncFuel = [
    'fuel_lecf_251': '²⁵¹Cf',
    'fuel_heu_235' : '²³⁵U' ,
    'fuel_lea_242' : '²⁴²Am',
    'fuel_leu_235' : '²³⁵U' ,
    'fuel_len_236' : '²³⁶Np',
    'fuel_hecf_251': '²⁵¹Cf',
    'fuel_tbu'     : '²³²Th',
    'fuel_hecm_243': '²⁴³Cm',
    'fuel_lecm_243': '²⁴³Cm',
    'fuel_lecm_247': '²⁴⁷Cm',
    'fuel_leb_248' : '²⁴⁸Bk',
    'fuel_heu_233' : '²³³U' ,
    'fuel_hecm_247': '²⁴⁷Cm',
    'fuel_lecm_245': '²⁴⁵Cm',
    'fuel_heb_248' : '²⁴⁸Bk',
    'fuel_hep_239' : '²³⁹Pu',
    'fuel_leu_233' : '²³³U' ,
    'fuel_hecm_245': '²⁴⁵Cm',
    'fuel_lep_241' : '²⁴¹Pu',
    'fuel_lep_239' : '²³⁹Pu',
    'fuel_hecf_249': '²⁴⁹Cf',
    'fuel_hea_242' : '²⁴²Am',
    'fuel_hep_241' : '²⁴¹Pu',
    'fuel_hen_236' : '²³⁶Np',
    'fuel_lecf_249': '²⁴⁹Cf'
]

@groovy.transform.Field def toUnicode = [
        '⁰': '\u2070',
        '¹': '\u00B9',
        '²': '\u00B2',
        '³': '\u00B3',
        '⁴': '\u2074',
        '⁵': '\u2075',
        '⁶': '\u2076',
        '⁷': '\u2077',
        '⁸': '\u2078',
        '⁹': '\u2079',
        '₀': '\u2080',
        '₁': '\u2081',
        '₂': '\u2082',
        '₃': '\u2083',
        '₄': '\u2084',
        '₅': '\u2085',
        '₆': '\u2086',
        '₇': '\u2087',
        '₈': '\u2088',
        '₉': '\u2089',
        '•': '\u2022',
        '⊕': '\u2295'
]

@groovy.transform.Field def tooltipMap = [:]

String resolveUnicode(String str) {
    toUnicode.each { key, value ->
        str.replaceAll(key, value)
    }
    return str
}

def addTooltip(ItemStack itemStack, String line) {
    tooltipMap[itemStack] = line
}

def addOredictTooltip(String oreDict, String line) {
    for (def iStack in ore(oreDict)) {
        addTooltip(iStack, line)
    }
}

event_manager.listen { ItemTooltipEvent event ->
    for (def entry in tooltipMap) {
        if (event.getItemStack() in entry.key) {
            event.getToolTip().add(1, entry.value)
        }
    }

    if (!event.getItemStack().hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) return
    def handler = event.getItemStack().getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)
    if (handler == null) return
    handler.getTankProperties().each {
        def content = it.getContents()
        if (content != null) {
            event.getToolTip() << GroovyScriptCodeConverter.asGroovyCode(content, true)

            // Other Liquids
            def fluidName = content.getFluid().getName()
            if (liquidsElements.containsKey(fluidName)) {
                event.getToolTip().add(1, resolveUnicode("\u00A7e" + liquidsElements[fluidName]))
                return
            }

            // NaK Liquids
            if (fluidName.endsWith('nak_hot') || fluidName.endsWith('nak')) {
                boolean isHot = fluidName.endsWith('nak_hot')
                if (fluidName == 'nak' || fluidName == 'nak_hot') {
                    event.getToolTip().add(1, "\u00A7eNaK")
                    return
                }

                event.getToolTip().add(1, resolveUnicode("\u00A7eNaK•" + nakCapable[fluidName.replace(isHot ? '_nak_hot' : '_nak', '')]))
                return
            }

            // FLiBe Liquids
            if (fluidName.endsWith('flibe')) {
                def actualFluid = fluidName.replace('_fluoride_flibe', '').replace('depleted_', '')
                def element = isotopes.containsKey(actualFluid) ? isotopes[actualFluid] : ncFuel[actualFluid]
                boolean depleted = fluidName.startsWith('depleted')

                event.getToolTip().add(1, resolveUnicode(depleted ? "\u00A7eFLiBe•~(" + element + "F₃)" : "\u00A7eFLiBe•" + element + "F₃"))
                return
            }

            // Fluorides
            if (fluidName.endsWith('fluoride')) {
                def actualFluid = fluidName.replace('_fluoride', '').replace('depleted_', '')
                def element = isotopes.containsKey(actualFluid) ? isotopes[actualFluid] : ncFuel[actualFluid]
                boolean depleted = fluidName.startsWith('depleted')

                event.getToolTip().add(1, resolveUnicode(depleted ? "\u00A7e~(" + element + "F₃)" : "\u00A7e" + element + "F₃"))
                return
            }

            // Isotopes
            if (isotopes.containsKey(fluidName)) {
                event.getToolTip().add(1, resolveUnicode("\u00A7e" + isotopes[fluidName]))
                return
            }
        }
    }
}

oredictElements.each { key, value ->
    for (oredict in value) {
        addOredictTooltip(oredict, resolveUnicode("\u00A7e" + key))
    }
}