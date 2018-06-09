package testbot

import me.greggkr.quickbot.command.CommandUtil
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

class TestListener : ListenerAdapter() {

    init {
        CommandUtil.addCommands(TestCommand(), TestSubCommandA(), TestSubCommandB())
    }

    override fun onMessageReceived(e: MessageReceivedEvent) {
        if (e.author.isBot) return

        val prefix = "="

        val text = e.message.contentRaw.substringAfter(prefix)

        val args = text.split(Regex("\\s+"))
        val trigger = args[0]

        val command = CommandUtil.getCommand(trigger)

        if (command == null) {
            println("command not found")
            return
        }

        val ret = CommandUtil.execute(command, e.message, args.toTypedArray())
        println("${command.getInfo()?.name}: " + ret)
    }
}