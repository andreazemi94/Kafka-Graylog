package com.myproject.graylogpub.graylog;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LogMessage {
    private String facility;
    private String source;
    private String infoLevel;
    private Integer level;
    private String message;
}
