package tristancamejo.pbs.events;

public enum Event {
    Identify("IDENTIFY"),
    Success("SUCCESS"),
    NoAuth("NOAUTH"),
    Username("USERNAME"),
    Log("LOG"),
    RunCommand("RUN");

    public final String raw;

    Event(String raw) {
        this.raw = raw;
    }
}