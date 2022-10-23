package tristancamejo.pbs.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.apache.commons.lang3.StringUtils;
import tristancamejo.pbs.Pbs;
import tristancamejo.pbs.events.Event;
import tristancamejo.pbs.lib.WSUtil;

import java.util.ArrayList;
import java.util.List;

public class RunCommand implements ICommand {

    @Override
    public String getCommandName() {
        return "run";
    }

    @Override
    public String getCommandUsage(ICommandSender var1) {
        return "run <command>";
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<String>();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] argString) {
        Pbs.client.send(WSUtil.constructPayload(Event.RunCommand, StringUtils.join(argString, " ")).raw);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender var1) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] strings, BlockPos blockPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] var1, int var2) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}