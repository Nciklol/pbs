package tristancamejo.pbs.events.impl;

import tristancamejo.pbs.events.EventHandler;
import tristancamejo.pbs.lib.BMAPI;

public class LogHandler extends EventHandler {
    @Override
    public void handle(String value) {
        BMAPI.chatLog(value);
    }
}

