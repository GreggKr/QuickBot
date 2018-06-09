package me.greggkr.quickbot.command

import me.greggkr.quickbot.command.annotations.*
import net.dv8tion.jda.core.entities.Message

interface Command {
    fun execute(message: Message, args: Array<String>): Response?

    fun getInfo(): CommandData? {
        return javaClass.getAnnotation(CommandData::class.java)
    }

    fun getData(): Data? {
        return javaClass.getAnnotation(Data::class.java)
    }

    fun getRequiredPermissions(): RequiredPermissions? {
        return javaClass.getAnnotation(RequiredPermissions::class.java)
    }

//    fun getRequiredRoles(): RequiredRoles? {
//        return javaClass.getAnnotation(RequiredRoles::class.java)
//    }

    fun hasSubCommands(): Boolean {
        return javaClass.getAnnotation(SubCommands::class.java) != null
    }

    fun getSubCommands(): List<Command>? {
        val annotation = javaClass.getAnnotation(SubCommands::class.java) ?: return null

        return annotation.commands.mapNotNull { CommandUtil.getCommand(it) }
    }

    fun isSubCommand(): Boolean {
        return javaClass.getAnnotation(SubCommand::class.java) != null
    }

    fun isTrigger(trigger: String): Boolean {
        return getInfo()?.name.equals(trigger, true) || getInfo()?.aliases?.any { it.equals(trigger, true) } ?: false
    }

    fun hasAttrib(name: String): Boolean {
        return javaClass.getAnnotation(Data::class.java)?.data?.any { it.key.equals(name, true) } ?: false
    }

    fun getAttrib(name: String): String? {
        return getData()?.data?.firstOrNull { it.key.equals(name, true) }?.value
    }
}