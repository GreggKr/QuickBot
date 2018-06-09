package me.greggkr.quickbot.command.annotations

@Target(AnnotationTarget.CLASS)
annotation class Data(
        val data: Array<CommandAttrib> // custom data used in custom
)