package com.masciar.service;

import java.io.IOException;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.MSG;

public class ScreenshotService {
    public void initService() {
        new Thread(() -> {
            User32.INSTANCE.RegisterHotKey(null, 1, 0, 0x7B); // F12
            MSG msg = new MSG();
            while (User32.INSTANCE.GetMessage(msg, null, 0, 0) != 0) {
                if (msg.message == WinUser.WM_HOTKEY) {
                    System.out.println("reconoce");
                    String name = String.valueOf(Math.random() + ".png");
                    ProcessBuilder pb = new ProcessBuilder(
                            "ffmpeg.exe",
                            "-f", "gdigrab",
                            "-i", "desktop",
                            "-frames:v", "1",
                            name);

                    pb.inheritIO();

                    Process p;
                    try {
                        p = pb.start();
                        p.waitFor();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
