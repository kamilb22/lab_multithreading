package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
    private final int rocketCount;
    private final PatriotBattery battery;
    Executor executor;

    public BetterRadar(int rocketCount, PatriotBattery battery, Executor executor) {
        this.rocketCount = rocketCount;
        this.battery = battery;
        this.executor = executor;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissle) {
        executor.execute(() -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        });
    }

}
