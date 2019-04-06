package io.manebot.plugin.audio;

import io.manebot.artifact.ManifestIdentifier;
import io.manebot.plugin.Plugin;
import io.manebot.plugin.PluginLoadException;
import io.manebot.plugin.PluginType;
import io.manebot.plugin.audio.command.AudioCommand;
import io.manebot.plugin.audio.command.MixerCommand;
import io.manebot.plugin.java.PluginEntry;

public class Entry implements PluginEntry {
    @Override
    public void instantiate(Plugin.Builder builder) throws PluginLoadException {
        builder.setType(PluginType.DEPENDENCY);
        builder.requirePlugin(ManifestIdentifier.fromString("io.manebot.plugin:media"));
        builder.setInstance(AudioPlugin.class, registration -> new AudioPlugin());
        builder.addCommand("audio", AudioCommand::new);
        builder.addCommand("mixer", MixerCommand::new);
    }

    @Override
    public void destruct(Plugin plugin) {
        throw new UnsupportedOperationException();
    }
}