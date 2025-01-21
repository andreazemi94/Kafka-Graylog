package com.myproject.graylogpub.graylog;

import lombok.RequiredArgsConstructor;
import java.util.Map;
import java.util.stream.*;

@RequiredArgsConstructor
public enum LogLevel {
    EMERGENCY(7),
    ALERT(6),
    ERROR(5),
    CRITICAL(4),
    WARNING(3),
    NOTICE(2),
    INFO(1),
    DEBUG(0),
    DEFAULT(-1);

    final Integer level;

    private static final Map<Integer, LogLevel> LEVEL_MAP = Stream.of(values()).collect(Collectors.toMap(logLevel -> logLevel.level, logLevel -> logLevel));

    public static LogLevel fromLevel(Integer level) {
        return LEVEL_MAP.getOrDefault(level,DEFAULT);
    }
}
