/*
 * Copyright (c) 2022-2025 AppleTheGolden
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.scotsguy.nowplaying.gui.screen;

import com.github.scotsguy.nowplaying.config.Config;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;

import static com.github.scotsguy.nowplaying.util.Localization.localized;

public class ClothScreenProvider {
    /**
     * Builds and returns a Cloth Config options screen.
     * @param parent the current screen.
     * @return a new options {@link Screen}.
     * @throws NoClassDefFoundError if the Cloth Config API mod is not
     * available.
     */
    static Screen getConfigScreen(Screen parent) {
        Config.Options options = Config.options();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(localized("screen", "options"))
                .setSavingRunnable(Config::save);

        ConfigEntryBuilder eb = builder.entryBuilder();
        ConfigCategory modSettings = builder.getOrCreateCategory(localized("config", "options"));

        modSettings.addEntry(eb.startBooleanToggle(
                        localized("option", "music_only_keybind"), options.onlyKeybind)
                .setTooltip(localized("option", "music_only_keybind.tooltip"))
                .setDefaultValue(Config.Options.defaultOnlyKeybind)
                .setSaveConsumer(val -> options.onlyKeybind = val)
                .build());

        modSettings.addEntry(eb.startEnumSelector(
                localized("option", "music_style"),
                        Config.Options.Style.class, options.musicStyle)
                .setEnumNameProvider(Config.Options.Style::name)
                .setDefaultValue(Config.Options.defaultMusicStyle)
                .setSaveConsumer(val -> options.musicStyle = val)
                .build());

        modSettings.addEntry(eb.startEnumSelector(
                        localized("option", "jukebox_style"),
                        Config.Options.Style.class, options.jukeboxStyle)
                .setEnumNameProvider(Config.Options.Style::name)
                .setDefaultValue(Config.Options.defaultJukeboxStyle)
                .setSaveConsumer(val -> options.jukeboxStyle = val)
                .build());

        modSettings.addEntry(eb.startBooleanToggle(
                        localized("option", "fallback_toast"), options.fallbackToast)
                .setTooltip(localized("option", "fallback_toast.tooltip"))
                .setDefaultValue(Config.Options.defaultFallbackToast)
                .setSaveConsumer(val -> options.fallbackToast = val)
                .build());

        modSettings.addEntry(eb.startBooleanToggle(
                localized("option", "silence_woosh"), options.silenceWoosh)
                .setTooltip(localized("option", "silence_woosh.tooltip"))
                .setDefaultValue(Config.Options.defaultSilenceWoosh)
                .setSaveConsumer(val -> options.silenceWoosh = val)
                .build());

        modSettings.addEntry(eb.startFloatField(
                        localized("option", "toast_scale"), options.toastScale)
                .setTooltip(localized("option", "toast_scale.tooltip"))
                .setDefaultValue(Config.Options.defaultToastScale)
                .setMin(0.25F)
                .setMax(2F)
                .setSaveConsumer(val -> options.toastScale = val)
                .build());

        modSettings.addEntry(eb.startBooleanToggle(
                        localized("option", "simple_toast"), options.simpleToast)
                .setTooltip(localized("option", "simple_toast.tooltip"))
                .setDefaultValue(Config.Options.defaultSimpleToast)
                .setSaveConsumer(val -> options.simpleToast = val)
                .build());

        modSettings.addEntry(eb.startBooleanToggle(
                        localized("option", "only_cat"), options.onlyCat)
                .setTooltip(localized("option", "only_cat.tooltip"))
                .setDefaultValue(Config.Options.defaultOnlyCat)
                .setSaveConsumer(val -> options.onlyCat = val)
                .build());

        modSettings.addEntry(eb.startIntField(
                localized("option", "toast_time"), options.toastTime)
                .setTooltip(localized("option", "toast_time.tooltip"))
                .setDefaultValue(Config.Options.defaultToastTime)
                .setMin(1)
                .setMax(60)
                .setSaveConsumer(val -> options.toastTime = val)
                .build());

        modSettings.addEntry(eb.startIntField(
                        localized("option", "hotbar_time"), options.hotbarTime)
                .setTooltip(localized("option", "hotbar_time.tooltip"))
                .setDefaultValue(Config.Options.defaultHotbarTime)
                .setMin(1)
                .setMax(60)
                .setSaveConsumer(val -> options.hotbarTime = val)
                .build());

        modSettings.addEntry(eb.startBooleanToggle(
                localized("option", "narrate"), options.narrate)
                .setTooltip(localized("option", "narrate.tooltip"))
                .setDefaultValue(Config.Options.defaultNarrate)
                .setSaveConsumer(val -> options.narrate = val)
                .build());

        return builder.build();
    }
}
