package tristancamejo.pbs;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import tristancamejo.pbs.commands.DebugSendRaw;
import tristancamejo.pbs.commands.LoginCommand;
import tristancamejo.pbs.commands.RunCommand;
import tristancamejo.pbs.lib.BMAPI;

import java.net.URI;

@Mod(modid = Pbs.MODID, version = Pbs.VERSION)
public class Pbs {
    public static final String MODID = "pbs";
    public static final String VERSION = "1.0";
    private static final String SERVER = "wss://gateway.ybot.rocks";
    public static WebSocketClient client;
    private final tristancamejo.pbs.events.EventManager eventManager = new tristancamejo.pbs.events.EventManager();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new DebugSendRaw());
        ClientCommandHandler.instance.registerCommand(new LoginCommand());
        ClientCommandHandler.instance.registerCommand(new RunCommand());

        System.out.println("Connecting to " + SERVER);

        try {
            client = new WebSocketClient(new URI(SERVER)) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    System.out.println("Connected to " + SERVER);
                    BMAPI.chatLog("Connected to " + SERVER);
                }

                @Override
                public void onMessage(String message) {
                    eventManager.handlePayload(message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("Disconnected from " + SERVER + " attempting to reconnect...");
                    BMAPI.chatLog("Disconnected from " + SERVER + " attempting to reconnect...");
                    client.connect();
                }

                @Override
                public void onError(Exception ex) {
    
                }
            };

            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
