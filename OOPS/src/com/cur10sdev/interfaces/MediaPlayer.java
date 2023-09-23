package com.cur10sdev.interfaces;

import com.cur10sdev.interfaces.Media;

public class MediaPlayer implements Media {
    @Override
    public void start() {
        System.out.println("Media Player Starts");
    }

    @Override
    public void stop() {
        System.out.println("Media Player Stops");
    }
}
