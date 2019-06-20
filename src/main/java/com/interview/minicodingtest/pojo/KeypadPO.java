package com.interview.minicodingtest.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Wilson
 */
@Component
@Data
@ConfigurationProperties(prefix = "keypad")
public class KeypadPO {
    private Map<String, String> map;
}
