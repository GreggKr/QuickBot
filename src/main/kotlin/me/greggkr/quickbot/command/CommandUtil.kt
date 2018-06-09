package me.greggkr.quickbot.command

import net.dv8tion.jda.core.entities.Message

object CommandUtil {
    private val commands = HashSet<Command>()

    fun getCommand(trigger: String): Command? {
        return commands.firstOrNull {
            val info = it.getInfo() ?: return@firstOrNull false

            info.name.equals(trigger, true) || info.aliases.any { it.equals(trigger, true) }
        }
    }

    fun addCommands(vararg commands: Command) {
        this.commands.addAll(commands)
    }

    fun execute(command: Command, message: Message, a: Array<String>, executedAsSubCommand: Boolean = false): Response {
        if (command.getInfo() == null) return Response.NO_COMMAND_DATA
        if (!executedAsSubCommand && command.isSubCommand()) return Response.SUB_COMMAND

        val member = message.member
        val perms = command.getRequiredPermissions()

        if (perms != null) {
            if (perms.allRequired) {
                if (!member.hasPermission(*perms.permissions)) return Response.NO_PERMISSION
            } else {
                if (perms.permissions.any { !member.hasPermission(it) }) return Response.NO_PERMISSION
            }
        }

//        val roles = command.getRequiredRoles()
//
//        if (roles != null) {
//            if (roles.allRequired) {
//                val allowed = roles.roleIds
//                        .mapNotNull { message.guild.getRoleById(it) }
//                        .any { !member.roles.contains(it) }
//
//                if (!allowed) return Response.NO_PERMISSION
//            } else {
//                val allowed = roles.roleIds
//                        .mapNotNull { message.guild.getRoleById(it) }
//                        .any { member.roles.contains(it) }
//
//                if (!allowed) return Response.NO_PERMISSION
//            }
//        }

        if (command.hasSubCommands() && a.size > 1) {
            command.getSubCommands()?.forEach {
                if (it.isTrigger(a[0])) {
                    return CommandUtil.execute(it, message, a.toList().subList(1, a.size).toTypedArray(), true)
                }
            }
        }

        return command.execute(message, a) ?: Response.SUCCESS
    }
}