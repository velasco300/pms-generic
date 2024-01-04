package com.zzz.pms.pmsgeneric.util;

import lombok.Data;

@Data
public class Watch {
    private final String id;
    private boolean running;
    private long startTimeMillis;
    private long totalTimeMillis;
    private String statusMsg = "";

    public Watch() {
        this("");
    }

    public Watch(String id) {
        this.id = id;
    }

    public double getTotalTimeSeconds() {
        return this.totalTimeMillis / 1000.0;
    }

    public String logMsg(String msg) {
        return "#" + getId() + "#" + " " + msg;
    }

    public String startSummary() {
        return "start Watch #" + getId() + "#";
    }

    public String finishSummary() {
        return "finish Watch #" + getId() + "# status(" + statusMsg + ") running time (sec)=" + getTotalTimeSeconds();
    }

    public void start() throws IllegalStateException {
        if (this.running) {
            throw new IllegalStateException("Can't start Watch: it's already running");
        }
        this.running = true;
        this.startTimeMillis = System.currentTimeMillis();
    }

    public void stop() throws IllegalStateException {
        if (!this.running) {
            throw new IllegalStateException("Can't stop Watch: it's not running");
        }
        long lastTime = System.currentTimeMillis() - this.startTimeMillis;
        this.totalTimeMillis += lastTime;
        this.running = false;
    }

}
