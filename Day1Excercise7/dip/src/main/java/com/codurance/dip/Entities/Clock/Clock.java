package com.codurance.dip.Entities.Clock;

import java.time.MonthDay;

public class Clock implements ClockInterface {
    @Override
    public MonthDay monthDay(){
        return MonthDay.now();
    }
}