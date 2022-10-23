package tristancamejo.pbs.events.impl;

import net.minecraft.client.Minecraft;
import tristancamejo.pbs.Pbs;
import tristancamejo.pbs.events.Event;
import tristancamejo.pbs.events.EventHandler;
import tristancamejo.pbs.lib.BMAPI;
import tristancamejo.pbs.lib.WSUtil;

public class SuccessHandler extends EventHandler {
    @Override
    public void handle(String value) {
        Pbs.client.send(WSUtil.constructPayload(Event.Username, Minecraft.getMinecraft().thePlayer.getName()).raw);
        BMAPI.chatLog("Successfully connected to the server!");
    }
}
