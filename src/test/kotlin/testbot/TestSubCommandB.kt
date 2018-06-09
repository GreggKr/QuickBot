package testbot

import me.greggkr.quickbot.command.Command
import me.greggkr.quickbot.command.Response
import me.greggkr.quickbot.command.annotations.CommandData
import me.greggkr.quickbot.command.annotations.RequiredPermissions
import me.greggkr.quickbot.command.annotations.SubCommand
import net.dv8tion.jda.core.Permission
import net.dv8tion.jda.core.entities.Message

@CommandData(
        name = "sub2",
        aliases = ["s2"],
        description = "does a thing 2?"
)
@RequiredPermissions(
        permissions = [Permission.ADMINISTRATOR, Permission.MANAGE_SERVER],
        allRequired = true
)
@SubCommand
class TestSubCommandB : Command {
    override fun execute(message: Message, args: Array<String>): Response? {
        message.channel.sendMessage("do you think it actually works lol").queue()
        return Response.SUCCESS
    }
}