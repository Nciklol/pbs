package tristancamejo.pbs.lib;

import tristancamejo.pbs.events.Event;

public class WebsocketPayload {
    public final Event event;
    public final String value;
    public final String raw;

    public WebsocketPayload(String event, String value) {
        this.event = WSUtil.parseEvent(event);
        this.value = value;
        
        this.raw = event + " " + value;
    }
}
