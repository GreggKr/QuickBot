package me.greggkr.quickbot.command.annotations

@Target(AnnotationTarget.CLASS)
annotation class SubCommands(
        /**
         * List of sub commands associated with this
         * <main> <sub> <args>
         */
        val commands: Array<String>
)