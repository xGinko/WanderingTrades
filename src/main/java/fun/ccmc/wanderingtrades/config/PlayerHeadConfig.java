package fun.ccmc.wanderingtrades.config;

import fun.ccmc.wanderingtrades.util.TextUtil;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@FieldNameConstants
public class PlayerHeadConfig {
    @Getter private int maxUses = 1;
    @Getter private final boolean experienceReward;
    @Getter private final boolean playerHeadsFromServer;
    @Getter private final double playerHeadsFromServerChance;
    @Getter private final int playerHeadsFromServerAmount;
    @Getter private final int amountOfHeadsPerTrade;
    @Getter private final String name;
    @Getter private final ArrayList<String> lore;
    @Getter private final ItemStack ingredient1;
    @Getter private final ItemStack ingredient2;

    public PlayerHeadConfig(FileConfiguration config) {
        playerHeadsFromServer = config.getBoolean(Fields.playerHeadsFromServer);
        playerHeadsFromServerChance = config.getDouble(Fields.playerHeadsFromServerChance);
        playerHeadsFromServerAmount = config.getInt(Fields.playerHeadsFromServerAmount);
        String prefix = "headTrade.";
        if (config.getInt(prefix + Fields.maxUses) != 0) {
            maxUses = config.getInt(prefix + Fields.maxUses);
        }
        experienceReward = config.getBoolean(prefix + Fields.experienceReward);
        ingredient1 = TradeConfig.getStack(config, prefix + "ingredients.1");
        ingredient2 = TradeConfig.getStack(config, prefix + "ingredients.2");
        amountOfHeadsPerTrade = config.getInt(prefix + "head.amount");
        name = TextUtil.colorize(config.getString(prefix + "head.customname"));
        lore = TextUtil.colorize(config.getStringList(prefix + "head.lore"));
    }
}