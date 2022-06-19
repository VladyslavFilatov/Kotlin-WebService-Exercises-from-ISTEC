import club.minnced.discord.webhook.WebhookClientBuilder
import club.minnced.discord.webhook.receive.ReadonlyMessage
import club.minnced.discord.webhook.send.WebhookEmbedBuilder
import club.minnced.discord.webhook.send.WebhookMessageBuilder


fun main() {

// Using the builder
    // Using the builder

    var url = myurl
    val builder = WebhookClientBuilder(url) // or id, token

    builder.setThreadFactory { job: Runnable? ->
        val thread = Thread(job)
        thread.name = "Hello"
        thread.isDaemon = true
        thread
    }
    builder.setWait(true)
    val client = builder.build()

    // Send and forget
    // Send and forget
    client.send("Hello World")

/*
// Send and log (using embed)

// Send and log (using embed)
    val embed = WebhookEmbedBuilder()
        .setColor(0xFF00EE)
        .setDescription("Hello World")
        .build()

    client.send(embed)
        .thenAccept { message: ReadonlyMessage ->
            System.out.printf(
                "Message with embed has been sent [%s]%n",
                message.id
            )
        }

// Change appearance of webhook message

// Change appearance of webhook message
    val builder = WebhookMessageBuilder()
    builder.setUsername("Minn") // use this username

    builder.setAvatarUrl(avatarUrl) // use this avatar

    builder.setContent("Hello World")
    client.send(builder.build())
*/
}