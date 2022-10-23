package tristancamejo.pbs.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.apache.commons.lang3.StringUtils;
import tristancamejo.pbs.Pbs;

import java.util.ArrayList;
import java.util.List;

public class DebugSendRaw implements ICommand {

    @Override
    public String getCommandName() {
        return "dsr";
    }

    @Override
    public String getCommandUsage(ICommandSender var1) {
        return "dsr <payload>";
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<String>();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] argString) {
        Pbs.client.send(StringUtils.join(argString, " "));
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