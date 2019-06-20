package com.interview.minicodingtest.controller;

import com.interview.minicodingtest.exception.InvalidKeyException;
import com.interview.minicodingtest.service.KeypadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilson
 */
@Controller
@Slf4j
public class KeypadController {
    @Autowired
    KeypadService keypadService;

    public void printComplex(String[] arr) throws InvalidKeyException {
        List<String> letterListOnKeyA = null;
        List<String> letterListOnKeyB = null;
        if (arr.length == 1) {
            letterListOnKeyA = convertMultipleLetterToList(arr[0]);
        } else if (arr.length == 2) {
            letterListOnKeyA = convertMultipleLetterToList(arr[0]);
            letterListOnKeyB = convertMultipleLetterToList(arr[1]);
        } else {
            throw new InvalidKeyException("E00002", "The length of keys is unsupported");
        }
        List<String> list = keypadService.listCombination(letterListOnKeyA, letterListOnKeyB);
        log.info(list.toString());
    }

    private List<String> convertMultipleLetterToList(String input) throws InvalidKeyException {
        List<String> strList = new ArrayList<>();
        String[] arr = input.split("");
        for (String str : arr) {
            strList.addAll(keypadService.getLetterOnKeypad(str));
        }
        return strList;
    }
}
