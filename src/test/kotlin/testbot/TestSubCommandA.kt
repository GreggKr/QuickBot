package testbot

import me.greggkr.quickbot.command.Command
import me.greggkr.quickbot.command.Response
import me.greggkr.quickbot.command.annotations.CommandData
import me.greggkr.quickbot.command.annotations.RequiredPermissions
import me.greggkr.quickbot.command.annotations.SubCommand
import net.dv8tion.jda.core.Permission
import net.dv8tion.jda.core.entities.Message
import java.util.*

@CommandData(
        name = "sub",
        aliases = ["s"],
        description = "does a thing?"
)
@RequiredPermissions(
        permissions = [Permission.ADMINISTRATOR, Permission.MANAGE_SERVER],
        allRequired = true
)
@SubCommand
class TestSubCommandA : Command {
    override fun execute(message: Message, args: Array<String>): Response? {
        message.channel.sendMessage(Arrays.toString(args)).queue()
        return Response.SUCCESS
    }
}