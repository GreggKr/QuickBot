package me.greggkr.quickbot.command.annotations

@Target(AnnotationTarget.CLASS)
annotation class CommandAttrib(
        val key: String,
        val value: String = ""
)