package tristancamejo.pbs.lib;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class BMAPI {
    public static void chatLog(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§d[§bPBS§d]§r §7" + message));
    }
}
