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
        commonBases.add(Items.LEATHER_HELMET);
        commonBases.add(Items.LEATHER_CHESTPLATE);
        commonBases.add(Items.LEATHER_BOOTS);
        commonBases.add(Items.LEATHER_LEGGINGS);
        commonBases.add(Items.WOODEN_PICKAXE);
        commonBases.add(Items.WOODEN_SHOVEL);
        commonBases.add(Items.WOODEN_HOE);
        commonBases.add(Items.WOODEN_SWORD);

        List<Item> rareBases = new ArrayList<>();
        rareBases.add(Items.IRON_AXE);
        rareBases.add(Items.BOW);
        rareBases.add(Items.CROSSBOW);
        rareBases.add(Items.IRON_HELMET);
        rareBases.add(Items.IRON_CHESTPLATE);
        rareBases.add(Items.IRON_BOOTS);
        rareBases.add(Items.IRON_LEGGINGS);
        rareBases.add(Items.SHIELD);
        rareBases.add(Items.IRON_PICKAXE);
        rareBases.add(Items.IRON_SHOVEL);
        rareBases.add(Items.IRON_HOE);
        rareBases.add(Items.IRON_SWORD);

        List<Item> uncommonBases = new ArrayList<>();
        uncommonBases.add(Items.STONE_AXE);
        uncommonBases.add(Items.BOW);
        uncommonBases.add(Items.CHAINMAIL_HELMET);
        uncommonBases.add(Items.CHAINMAIL_CHESTPLATE);
        uncommonBases.add(Items.CHAINMAIL_BOOTS);
        uncommonBases.add(Items.CHAINMAIL_LEGGINGS);
        uncommonBases.add(Items.STONE_PICKAXE);
        uncommonBases.add(Items.STONE_SHOVEL);
        uncommonBases.add(Items.STONE_HOE);
        uncommonBases.add(Items.STONE_SWORD);

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
        superbBases.add(Items.DIAMOND_SWORD);

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
        epicBases.add(Items.NETHERITE_SWORD);

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
                base = epicBases.get(rgen.nextInt(0, epicBases.size() ));
            }
            case "Exalted", "Rare" -> {
                base = rareBases.get(rgen.nextInt(0, rareBases.size() ));
            }
            case "Superb" -> {
                base = superbBases.get(rgen.nextInt(0, superbBases.size() ));
            }
            case "Uncommon" -> {
                base = uncommonBases.get(rgen.nextInt(0, uncommonBases.size() ));
            }
            case "Common" -> {
                base = commonBases.get(rgen.nextInt(0, commonBases.size() ));
            }
        }

        //Create Item Stack
        ItemStack drop = new ItemStack(base);

        //Add enchantments TODO


        // Enchantments based off enchanttarget TODO
        // for e

        List<Enchantment> coreEnchantments = new ArrayList<>();
        coreEnchantments.add(Enchantments.MENDING);
        coreEnchantments.add(Enchantments.UNBREAKING);
        coreEnchantments.add(Enchantments.PROTECTION);
        coreEnchantments.add(Enchantments.PROJECTILE_PROTECTION);
        coreEnchantments.add(Enchantments.FIRE_PROTECTION);
        coreEnchantments.add(Enchantments.BLAST_PROTECTION);
        coreEnchantments.add(Enchantments.THORNS);
        coreEnchantments.add(Enchantments.AQUA_AFFINITY);
        coreEnchantments.add(Enchantments.RESPIRATION);
        coreEnchantments.add(Enchantments.SWIFT_SNEAK);
        coreEnchantments.add(Enchantments.FEATHER_FALLING);
        coreEnchantments.add(Enchantments.SOUL_SPEED);
        coreEnchantments.add(Enchantments.FROST_WALKER);
        coreEnchantments.add(Enchantments.DEPTH_STRIDER);
        coreEnchantments.add(Enchantments.FIRE_ASPECT);
        coreEnchantments.add(Enchantments.LOOTING);
        coreEnchantments.add(Enchantments.KNOCKBACK);
        coreEnchantments.add(Enchantments.SWEEPING);
        coreEnchantments.add(Enchantments.SHARPNESS);
        coreEnchantments.add(Enchantments.SMITE);
        coreEnchantments.add(Enchantments.BANE_OF_ARTHROPODS);
        coreEnchantments.add(Enchantments.EFFICIENCY);
        coreEnchantments.add(Enchantments.FORTUNE);
        coreEnchantments.add(Enchantments.SILK_TOUCH);
        coreEnchantments.add(Enchantments.LURE);
        coreEnchantments.add(Enchantments.LUCK_OF_THE_SEA);
        coreEnchantments.add(Enchantments.IMPALING);
        coreEnchantments.add(Enchantments.CHANNELING);
        coreEnchantments.add(Enchantments.LOYALTY);
        coreEnchantments.add(Enchantments.RIPTIDE);
        coreEnchantments.add(Enchantments.QUICK_CHARGE);
        coreEnchantments.add(Enchantments.PIERCING);
        coreEnchantments.add(Enchantments.MULTISHOT);
        coreEnchantments.add(Enchantments.INFINITY);
        coreEnchantments.add(Enchantments.POWER);
        coreEnchantments.add(Enchantments.PUNCH);
        coreEnchantments.add(Enchantments.FLAME);

        List<Enchantment> usableEnchantments = new ArrayList<>();

        for (Enchantment e:coreEnchantments){
            if(e.isAcceptableItem(drop)){
                usableEnchantments.add(e);
            }
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

        int availEnchants = usableEnchantments.size();
        int rolls = 0;

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
                rolls = Math.min(availEnchants, 5);
                for(int i = 0; i < rolls; i++){
                    // get usableEnchentments.size
                    // use bigger value, usableEnchantments size or "Epic" value (5)

                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(0, (usableEnchantments.size())));
                    drop.addEnchantment(e, rgen.nextInt(1, 5));
                    usableEnchantments.remove(e);
                }
                break;
            case "Superb":
                rolls = Math.min(availEnchants, 4);
                for(int i = 0; i < rolls; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(0, (usableEnchantments.size())));
                    drop.addEnchantment(e, rgen.nextInt(1, 4));
                    usableEnchantments.remove(e);
                }
                break;
            case "Rare":
                rolls = Math.min(availEnchants, 3);
                for(int i = 0; i < rolls; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(0, (usableEnchantments.size())));
                    drop.addEnchantment(e, rgen.nextInt(1, 3));
                    usableEnchantments.remove(e);
                }
                break;
            case "Uncommon":
                rolls = Math.min(availEnchants, 2);
                for(int i = 0; i < rolls; i++){
                    if( usableEnchantments.size() < 1) {
                        break;
                    }
                    Enchantment e = usableEnchantments.get(rgen.nextInt(0,(usableEnchantments.size())));
                    drop.addEnchantment(e, rgen.nextInt(1, 2));
                    usableEnchantments.remove(e);
                }
                break;
            case "Common":
                drop.addEnchantment(usableEnchantments.get(rgen.nextInt(0,(usableEnchantments.size()))), rgen.nextInt(1, 2));
                break;
            case "Exalted":
                Enchantment e = Enchantments.UNBREAKING;
                drop.addEnchantment(Enchantments.UNBREAKING, 10);
                usableEnchantments.remove(e);
                drop.addEnchantment(usableEnchantments.get(rgen.nextInt(0,(usableEnchantments.size()))), 10);
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


