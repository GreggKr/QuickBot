package testbot

import me.greggkr.quickbot.command.Command
import me.greggkr.quickbot.command.Response
import me.greggkr.quickbot.command.annotations.CommandData
import me.greggkr.quickbot.command.annotations.RequiredPermissions
import me.greggkr.quickbot.command.annotations.SubCommands
import net.dv8tion.jda.core.Permission
import net.dv8tion.jda.core.entities.Message

@CommandData(
        name = "ping",
        aliases = ["p"],
        description = "Displays pong"
)
@RequiredPermissions(
        permissions = [Permission.ADMINISTRATOR, Permission.MANAGE_SERVER],
        allRequired = true
)
@SubCommands(
        ["sub", "sub2"]
)
class TestCommand : Command {
    override fun execute(message: Message, args: Array<String>): Response? {
        message.channel.sendMessage("Pong").queue()
        return Response.SUCCESS
    }
}