package fr.rbb.bot.command;

import org.incendo.cloud.discord.jda6.JDA6CommandManager;
import org.incendo.cloud.discord.jda6.JDAInteraction;

public interface CommandBuilder {

  void register(final JDA6CommandManager<JDAInteraction> commandManager);
}
