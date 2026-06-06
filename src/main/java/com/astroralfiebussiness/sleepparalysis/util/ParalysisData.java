package com.astroralfiebussiness.sleepparalysis.util;

public class ParalysisData {
    public static final String PARALYSIS_KEY = "IsParalyzed";
    public static final String PARALYSIS_END_TICK_KEY = "ParalysisEndTick";
    public static final String NIGHT_COUNT_KEY = "ParalysisNightCount";
    
    public static final int BASE_DURATION_SECONDS = 5;
    public static final int DURATION_INCREASE_PER_NIGHT = 1;
    public static final int TICKS_PER_SECOND = 20;

    public static int calculateDurationTicks(int nightCount) {
        int durationSeconds = BASE_DURATION_SECONDS + (nightCount - 1) * DURATION_INCREASE_PER_NIGHT;
        return durationSeconds * TICKS_PER_SECOND;
    }
}
