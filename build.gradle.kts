plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:6.5.0")
    implementation("org.incendo:cloud-jda6:1.0.0-beta.4")
    implementation("ch.qos.logback:logback-classic:1.5.13")
    implementation("org.xerial:sqlite-jdbc:3.50.1.0")
}

application {
    mainClass.set("fr.rbb.bot.Main")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}