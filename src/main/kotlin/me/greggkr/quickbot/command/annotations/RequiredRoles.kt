package me.greggkr.quickbot.command.annotations

@Target(AnnotationTarget.CLASS)
annotation class RequiredRoles(
        val allRequired: Boolean = false, // true -> all of the permissions are required. false -> only one is required
        val roleIds: Array<String> // case sensetive
)