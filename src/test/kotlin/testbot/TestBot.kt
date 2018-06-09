package testbot

import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

class TestBot {
    fun start() {
        JDABuilder(AccountType.BOT)
                .setToken("NDM1MDgyNDgzMjQ4MTM2MTky.DfxmQg.nUE0Y9cS0W5dbYZO0vMNQ8kqqTM")
                .addEventListener(TestListener())
                .buildBlocking()
    }
}

fun Array<String>.main() {
    TestBot().start()
}