package tristancamejo.pbs.events;

import tristancamejo.pbs.events.impl.LogHandler;
import tristancamejo.pbs.events.impl.SuccessHandler;
import tristancamejo.pbs.lib.WSUtil;
import tristancamejo.pbs.lib.WebsocketPayload;

import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private final Map<Event, EventHandler> eventHandlers = new HashMap<Event, EventHandler>();

    public EventManager() {
        register();
    }

    public void register() {
        eventHandlers.put(Event.Log, new LogHandler());
        eventHandlers.put(Event.Success, new SuccessHandler());
    }

    public void handlePayload(String payload) {
        System.out.println("Parsing payload!");

        WebsocketPayload event = WSUtil.parsePayload(payload);

        System.out.println("Attempting to handle event " + event.event.name());

        if (eventHandlers.containsKey(event.event)) {
            eventHandlers.get(event.event).handle(event.value);
        }
    }

}
