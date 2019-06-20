package com.interview.minicodingtest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Wilson
 */
@Getter
@Setter
@AllArgsConstructor
public class InvalidKeyException extends Exception {
    String errorCode;
    String errorMsg;
}
