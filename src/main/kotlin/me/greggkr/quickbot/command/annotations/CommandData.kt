package me.greggkr.quickbot.command.annotations

@Target(AnnotationTarget.CLASS)
annotation class CommandData(val name: String,
                             val aliases: Array<String> = [],
                             val description: String = ""
)
