package com.interview.minicodingtest.controller;

import com.interview.minicodingtest.exception.InvalidKeyException;
import com.interview.minicodingtest.service.KeypadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilson
 */
@Controller
@Slf4j
@RequestMapping("keys")
@ResponseBody
public class KeypadController {
    @Autowired
    KeypadService keypadService;

    @PostMapping("/key")
    public String printComplex(@RequestBody List<String> keyPress) throws InvalidKeyException {
        List<String> letterListOnKeyA = null;
        List<String> letterListOnKeyB = null;
        if (keyPress.size() == 1) {
            letterListOnKeyA = convertMultipleLetterToList(keyPress.get(0));
        } else if (keyPress.size() == 2) {
            letterListOnKeyA = convertMultipleLetterToList(keyPress.get(0));
            letterListOnKeyB = convertMultipleLetterToList(keyPress.get(1));
        } else {
            throw new InvalidKeyException("E00002", "The length of keys is unsupported");
        }
        List<String> list = keypadService.listCombination(letterListOnKeyA, letterListOnKeyB);
        log.info(list.toString());
        return list.toString();
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
