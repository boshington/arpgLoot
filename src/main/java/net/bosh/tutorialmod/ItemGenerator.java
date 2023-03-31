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
import java.util.stream.Stream;


public class ItemGenerator {
    public ItemStack generateDrop() {
        List<Item> commonBases = new ArrayList<>();
        commonBases.add(Items.WOODEN_AXE);
        commonBases.add(Items.WOODEN_HOE);
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
        Integer r = rgen.nextInt(1, 10001);
        if(r > 7000){ //9999 TODO
            rarity = "Legendary";
        } else if(r > 5000){ //9995 TODO
            Integer i2 = rgen.nextInt(1, 3);
            if(i2 == 1){
                rarity = "Epic";
            } else if(i2 == 2){
                rarity = "Exalted";
            }
        } else if(r > 4000){ //9975 TODO
            rarity = "Superb";
        } else if(r > 3000){ //9875 TODO
            rarity = "Rare";
        } else if(r > 2000){ //9375 TODO
            rarity = "Uncommon";
        } else if(r > 1){ //6875 TODO
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

        List<Enchantment> coreEnchantments = new ArrayList<>();
        coreEnchantments.add(Enchantments.MENDING);
        coreEnchantments.add(Enchantments.UNBREAKING);

        List<Enchantment> armourEnchantments = new ArrayList<>();
        armourEnchantments.add(Enchantments.PROTECTION);
        armourEnchantments.add(Enchantments.PROJECTILE_PROTECTION);
        armourEnchantments.add(Enchantments.FIRE_PROTECTION);
        armourEnchantments.add(Enchantments.BLAST_PROTECTION);
        armourEnchantments.add(Enchantments.THORNS);

        List<Enchantment> helmEnchantments = new ArrayList<>();
        helmEnchantments.add(Enchantments.AQUA_AFFINITY);
        helmEnchantments.add(Enchantments.RESPIRATION);

        List<Enchantment> leggingEnchantments = new ArrayList<>();
        leggingEnchantments.add(Enchantments.SWIFT_SNEAK);

        List<Enchantment> bootsEnchantments = new ArrayList<>();
        bootsEnchantments.add(Enchantments.FEATHER_FALLING);
        bootsEnchantments.add(Enchantments.SOUL_SPEED);
        bootsEnchantments.add(Enchantments.FROST_WALKER);
        bootsEnchantments.add(Enchantments.DEPTH_STRIDER);

        List<Enchantment> swordEnchantments = new ArrayList<>();
        swordEnchantments.add(Enchantments.FIRE_ASPECT);
        swordEnchantments.add(Enchantments.LOOTING);
        swordEnchantments.add(Enchantments.KNOCKBACK);
        swordEnchantments.add(Enchantments.SWEEPING);

        List<Enchantment> axeSwordEnchantments = new ArrayList<>();
        axeSwordEnchantments.add(Enchantments.SHARPNESS);
        axeSwordEnchantments.add(Enchantments.SMITE);
        axeSwordEnchantments.add(Enchantments.BANE_OF_ARTHROPODS);

        List<Enchantment> toolEnchantments = new ArrayList<>();
        toolEnchantments.add(Enchantments.EFFICIENCY);
        toolEnchantments.add(Enchantments.FORTUNE);
        toolEnchantments.add(Enchantments.SILK_TOUCH);

        List<Enchantment> rodEnchantments = new ArrayList<>();
        rodEnchantments.add(Enchantments.LURE);
        rodEnchantments.add(Enchantments.LUCK_OF_THE_SEA);

        List<Enchantment> tridentEnchantments = new ArrayList<>();
        tridentEnchantments.add(Enchantments.IMPALING);
        tridentEnchantments.add(Enchantments.CHANNELING);
        tridentEnchantments.add(Enchantments.LOYALTY);
        tridentEnchantments.add(Enchantments.RIPTIDE);

        List<Enchantment> crossbowEnchantments = new ArrayList<>();
        crossbowEnchantments.add(Enchantments.QUICK_CHARGE);
        crossbowEnchantments.add(Enchantments.PIERCING);
        crossbowEnchantments.add(Enchantments.MULTISHOT);

        List<Enchantment> bowEnchantments = new ArrayList<>();
        bowEnchantments.add(Enchantments.INFINITY);
        bowEnchantments.add(Enchantments.POWER);
        bowEnchantments.add(Enchantments.PUNCH);
        bowEnchantments.add(Enchantments.FLAME);

        List<Enchantment> usableEnchantments = new ArrayList<>();
        usableEnchantments.addAll(coreEnchantments);

        if(base.toString().contains("sword")){
            usableEnchantments.addAll(swordEnchantments);
            usableEnchantments.addAll(axeSwordEnchantments);

        } else if(base.toString().contains("hoe") || base.toString().contains("pickaxe") || base.toString().contains("shovel")){
            usableEnchantments.addAll(toolEnchantments);

        } else if(base.toString().contains("axe")){
            usableEnchantments.addAll(toolEnchantments);
            usableEnchantments.addAll(axeSwordEnchantments);

        } else if(base.toString().contains("crossbow")){
            usableEnchantments.addAll(bowEnchantments);

        } else if(base.toString().contains("bow")) {
            usableEnchantments.addAll(crossbowEnchantments);

        } else if(base.toString().contains("trident")){
            usableEnchantments.addAll(tridentEnchantments);

        } else if(base.toString().contains("rod")){
            usableEnchantments.addAll(rodEnchantments);

        } else if(base.toString().contains("helmet")){
            usableEnchantments.addAll(armourEnchantments);
            usableEnchantments.addAll(helmEnchantments);

        } else if(base.toString().contains("chestplate")){
            usableEnchantments.addAll(armourEnchantments);

        } else if(base.toString().contains("leggings")){
            usableEnchantments.addAll(armourEnchantments);
            usableEnchantments.addAll(leggingEnchantments);

        } else if(base.toString().contains("boots")){
            usableEnchantments.addAll(armourEnchantments);
            usableEnchantments.addAll(bootsEnchantments);
        }

        //Determine number of enchantments based on rarity

        /*Integer numberofenchants = switch(rarity){
            case "Epic" -> rgen.nextInt(1, 5);
            case "Superb" -> rgen.nextInt(1, 4);
            case "Rare" -> rgen.nextInt(1, 3) ;
            case "Uncommon" -> rgen.nextInt(1, 2) ;
            case "Common" -> 1 ;
            default -> new Integer(0);
        };*/

        switch(rarity){
            case "Legendary":
                Enchantment _e = Enchantments.UNBREAKING;
                drop.addEnchantment(Enchantments.UNBREAKING, 10);
                usableEnchantments.remove(_e);
                for (Enchantment e:usableEnchantments){
                     drop.addEnchantment(e, e.getMaxLevel());
                }
                break;
            case "Epic":
                for(int i = 0; i < 5; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(1, (usableEnchantments.size() + 1)));
                    drop.addEnchantment(e, rgen.nextInt(1, 5));
                    usableEnchantments.remove(e);
                }
                break;
            case "Superb":
                for(int i = 0; i < 4; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(1, (usableEnchantments.size() + 1)));
                    drop.addEnchantment(e, rgen.nextInt(1, 4));
                    usableEnchantments.remove(e);
                }
                break;
            case "Rare":
                for(int i = 0; i < 3; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(1, (usableEnchantments.size() + 1)));
                    drop.addEnchantment(e, rgen.nextInt(1, 3));
                    usableEnchantments.remove(e);
                }
                break;
            case "Uncommon":
                for(int i = 0; i < 2; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(1,(usableEnchantments.size()+1)));
                    drop.addEnchantment(e, rgen.nextInt(1, 2));
                    usableEnchantments.remove(e);
                }
                break;
            case "Common":
                drop.addEnchantment(usableEnchantments.get(rgen.nextInt(1,(usableEnchantments.size()+1))), rgen.nextInt(1, 2));
                break;
            case "Exalted":
                Enchantment e = Enchantments.UNBREAKING;
                drop.addEnchantment(Enchantments.UNBREAKING, 10);
                usableEnchantments.remove(e);
                drop.addEnchantment(usableEnchantments.get(rgen.nextInt(1,(usableEnchantments.size()+1))), 10);
                break;
            }

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

    }
}
