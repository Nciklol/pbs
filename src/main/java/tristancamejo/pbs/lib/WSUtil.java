package tristancamejo.pbs.lib;

import tristancamejo.pbs.events.Event;

public class WSUtil {
    public static WebsocketPayload parsePayload(String payload) {
        String event = payload.split(" ")[0];
        String value = payload.substring(payload.indexOf(" ") + 1);

        return new WebsocketPayload(event, value);
    }

    public static Event parseEvent(String event) {
        for (Event e : Event.values()) {
            if (e.raw.equals(event)) {
                return e;
            }
        }
        return null;
    }

    public static WebsocketPayload constructPayload(Event event, String value) {
        return new WebsocketPayload(event.raw, value);
    }
}
