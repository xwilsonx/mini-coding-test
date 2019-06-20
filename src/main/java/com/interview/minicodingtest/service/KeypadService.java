package com.interview.minicodingtest.service;

import com.interview.minicodingtest.exception.InvalidKeyException;

import java.util.List;

/**
 * @author Wilson
 */
public interface KeypadService {
    /**
     * get the combinations of letters
     * @param letterListA
     * @param letterListB
     * @return
     */
    List<String> listCombination(List<String> letterListA, List<String> letterListB);

    /**
     * get letters on keypad
     * @param key
     * @return
     * @throws InvalidKeyException
     */
    List<String> getLetterOnKeypad(String key) throws InvalidKeyException;
}
