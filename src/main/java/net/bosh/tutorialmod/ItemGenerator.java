package net.bosh.tutorialmod;

import com.google.common.base.CaseFormat;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ItemGenerator {
    public ItemStack generateDrop() {
        List<Item> commonBases = new ArrayList<>();
        commonBases.add(Items.WOODEN_AXE);
        commonBases.add(Items.WOODEN_HOE);
        commonBases.add(Items.DIAMOND_PICKAXE);
        commonBases.add(Items.WOODEN_AXE);
        commonBases.add(Items.BOW);
        commonBases.add(Items.TRIDENT);
        commonBases.add(Items.CROSSBOW);
        commonBases.add(Items.LEATHER_HELMET);
        commonBases.add(Items.LEATHER_CHESTPLATE);
        commonBases.add(Items.LEATHER_BOOTS);
        commonBases.add(Items.LEATHER_LEGGINGS);
        commonBases.add(Items.SHIELD);
        commonBases.add(Items.WOODEN_PICKAXE);
        commonBases.add(Items.WOODEN_SHOVEL);
        commonBases.add(Items.WOODEN_HOE);

        List<Item> rareBases = new ArrayList<>();
        rareBases.add(Items.IRON_AXE);
        rareBases.add(Items.BOW);
        rareBases.add(Items.TRIDENT);
        rareBases.add(Items.CROSSBOW);
        rareBases.add(Items.IRON_HELMET);
        rareBases.add(Items.IRON_CHESTPLATE);
        rareBases.add(Items.IRON_BOOTS);
        rareBases.add(Items.IRON_LEGGINGS);
        rareBases.add(Items.SHIELD);
        rareBases.add(Items.IRON_PICKAXE);
        rareBases.add(Items.IRON_SHOVEL);
        rareBases.add(Items.IRON_HOE);

        List<Item> uncommonBases = new ArrayList<>();
        uncommonBases.add(Items.STONE_AXE);
        uncommonBases.add(Items.BOW);
        uncommonBases.add(Items.TRIDENT);
        uncommonBases.add(Items.CROSSBOW);
        uncommonBases.add(Items.CHAINMAIL_HELMET);
        uncommonBases.add(Items.CHAINMAIL_CHESTPLATE);
        uncommonBases.add(Items.CHAINMAIL_BOOTS);
        uncommonBases.add(Items.CHAINMAIL_LEGGINGS);
        uncommonBases.add(Items.SHIELD);
        uncommonBases.add(Items.STONE_PICKAXE);
        uncommonBases.add(Items.STONE_SHOVEL);
        uncommonBases.add(Items.STONE_HOE);

        List<Item> superbBases = new ArrayList<>();
        superbBases.add(Items.DIAMOND_AXE);
        superbBases.add(Items.BOW);
        superbBases.add(Items.TRIDENT);
        superbBases.add(Items.CROSSBOW);
        superbBases.add(Items.DIAMOND_HELMET);
        superbBases.add(Items.DIAMOND_CHESTPLATE);
        superbBases.add(Items.DIAMOND_BOOTS);
        superbBases.add(Items.DIAMOND_LEGGINGS);
        superbBases.add(Items.SHIELD);
        superbBases.add(Items.DIAMOND_PICKAXE);
        superbBases.add(Items.DIAMOND_SHOVEL);
        superbBases.add(Items.DIAMOND_HOE);

        List<Item> epicBases = new ArrayList<>();
        epicBases.add(Items.NETHERITE_AXE);
        epicBases.add(Items.BOW);
        epicBases.add(Items.TRIDENT);
        epicBases.add(Items.CROSSBOW);
        epicBases.add(Items.NETHERITE_HELMET);
        epicBases.add(Items.NETHERITE_CHESTPLATE);
        epicBases.add(Items.NETHERITE_BOOTS);
        epicBases.add(Items.NETHERITE_LEGGINGS);
        epicBases.add(Items.SHIELD);
        epicBases.add(Items.NETHERITE_PICKAXE);
        epicBases.add(Items.NETHERITE_SHOVEL);
        epicBases.add(Items.NETHERITE_HOE);
        //Pick Rarity
        //Default to None (White Wool)
        String rarity = "None";
        Random rgen = new Random();
        Integer i = rgen.nextInt(1, 10001);
        if(i > 9999){
            rarity = "Legendary";
        } else if(i > 9995){
            Integer i2 = rgen.nextInt(1, 3);
            if(i == 1){
                rarity = "Epic";
            } else if(i == 2){
                rarity = "Exalted";
            }
        } else if(i > 9975){
            rarity = "Superb";
        } else if(i > 9875){
            rarity = "Rare";
        } else if(i > 9375){
            rarity = "Uncommon";
        } else if(i > 6875){
            rarity = "Common";
        }

        //Determine Base
        Item base = Items.WHITE_WOOL;
        switch (rarity) {
            case "Legendary", "Epic" -> {
                base = epicBases.get(rgen.nextInt(1, epicBases.size() + 1));
            }
            case "Exalted", "Rare" -> {
                base = rareBases.get(rgen.nextInt(1, rareBases.size() + 1));
            }
            case "Superb" -> {
                base = superbBases.get(rgen.nextInt(1, superbBases.size() + 1));
            }
            case "Uncommon" -> {
                base = uncommonBases.get(rgen.nextInt(1, uncommonBases.size() + 1));
            }
            case "Common" -> {
                base = commonBases.get(rgen.nextInt(1, commonBases.size() + 1));
            }
        }

        //Create Item Stack
        ItemStack drop = new ItemStack(base);

        //Add enchantments TODO

        //Set custom name if an item drops
        String rarityprefix = switch (rarity) {
            case "Legendary" -> "§6Legendary";
            case "Epic" -> "§1Epic";
            case "Exalted" -> "§5Exalted";
            case "Superb" -> "§bSuperb";
            case "Rare" -> "§eRare";
            case "Uncommon" -> "§aUncommon";
            case "Common" -> "§7Common";
            default -> new String();
        };

        if(rarity != "None") {
            String name = WordUtils.capitalize(base.toString().replace("_", " "));
            drop.setCustomName(Text.literal((rarityprefix + " " + name)));
        }

        return drop;




/*
Swords
Axes
Bow
Trident
Crossbow
Helm
Chest
Boots
Legs
Shield

Wooden
Iron
Chain
Diamond
Netherite

Common - Wooden / Leather 0-1 Enchants
Uncommon - Chain Armour / Stone 1-2 Enchants
Rare - Iron 2-3 Enchanges
Superb - Diamond 3-4 Enchants
Epic - Netherite 4-5 Enchants
Legendary - Netherite Maxed 5 Enchants
Exalted - Diamond DoubleMax 1 Enchant


Establish rarity
    Generate a random number between 1 and 10000
    If number is greater than 9999 - Legendary
    elif number is greater than 9995 - Epic
    elif number is greater than 9975 - Superb
    elif number is greater than 9875 - Rare
    elif number is greater than 9375 - Uncommon
    elif number is greater than 6875 - Common
    else: - Gold nugget

Establish Item
    Generate a random number between 1 and 10
    1 - Weapons
        1 - Swords
        2 - Axes
        3 - Bow
        4 - Trident
        5 - Crossbow
    2 - Armour
        6 - Helm
        7 - Chest
        8 - Boots
        9 - Legs
        10 - Shield
    3 - Tools
        11 - Pickaxe
        12 - Shovel

Determine Number of Enchantments
    Generate a random number between 1 and 2
    1 - Lower Bound
    2 - Upper Bound

Determine Enchantments
    Assume unbreaking

Determine Enchantment Strength
    Assume Unbreaking 3

 */




    }
}
