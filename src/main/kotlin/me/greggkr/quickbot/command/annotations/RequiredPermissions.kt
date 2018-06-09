package me.greggkr.quickbot.command.annotations

import net.dv8tion.jda.core.Permission

@Target(AnnotationTarget.CLASS)
annotation class RequiredPermissions(
        val allRequired: Boolean = false, // true -> all of the permissions are required. false -> only one is required
        val permissions: Array<Permission>
)