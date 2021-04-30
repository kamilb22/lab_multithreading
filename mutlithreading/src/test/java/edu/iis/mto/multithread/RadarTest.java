package edu.iis.mto.multithread;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(100)
    void launchOnePatriotWhenNoticesAScudMissileOneHundredTimes() {
        int RocketsToLaunch = 1;
        Executor executor = (Runnable r) -> r.run();
        BetterRadar radar = new BetterRadar(RocketsToLaunch, batteryMock, executor);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }

}
