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

package com.github.scotsguy.nowplaying.sound;

import com.github.scotsguy.nowplaying.config.Config;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static com.github.scotsguy.nowplaying.util.Localization.localized;

public class Sound {
    public static Component getSoundName(SoundInstance instance) {
        String soundLocation = instance.getSound().getLocation().toString();
        String[] splitSoundLocation = soundLocation.split("/");
        String soundName = splitSoundLocation[splitSoundLocation.length - 1];
        return localized("music", soundName);
    }

    public static Item getMusicDisc(String music) {
        if (Config.options().onlyCat) return Items.MUSIC_DISC_CAT;
        if (music.startsWith("C418")) {
            return Items.MUSIC_DISC_BLOCKS;
        } else if (music.startsWith("Lena Raine")) {
            return Items.MUSIC_DISC_OTHERSIDE;
        } else if (music.startsWith("Aaron Cherof")) {
            return Items.MUSIC_DISC_RELIC;
        } else if (music.startsWith("Kumi Tanioka")) {
            return Items.MUSIC_DISC_MALL;
        } else {
            return Items.MUSIC_DISC_CAT;
        }
    }
}
