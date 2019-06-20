package com.interview.minicodingtest.service.impl;

import com.interview.minicodingtest.exception.InvalidKeyException;
import com.interview.minicodingtest.pojo.KeypadPO;
import com.interview.minicodingtest.service.KeypadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wilson
 */
@Service
@Slf4j
public class KeypadServiceImpl implements KeypadService {
    @Autowired
    KeypadPO keypadPO;

    @Override
    public List<String> listCombination(List<String> letterListA, List<String> letterListB) {
        List<String> printList = new ArrayList<>();
        if (letterListA == null || letterListA.size() == 0) {
            printList = letterListB;
        } else if (letterListB == null || letterListB.size() == 0) {
            printList = letterListA;
        } else {
            List<String> finalPrintList = printList;
            letterListA.stream().forEach(letterOuter -> {
                letterListB.stream().forEach(letterInner -> {
                    finalPrintList.add(letterOuter.toString() + letterInner.toString());
                });
            });
        }

        return printList;
    }

    @Override
    public List<String> getLetterOnKeypad(String key) throws InvalidKeyException {
        try{
            String lettersOnKey = keypadPO.getMap().get(key);
            List<String> lettersListOnKey = new ArrayList<>();
            if(!StringUtils.isEmpty(lettersOnKey)){
                return Arrays.asList(lettersOnKey.split(","));
            } else {
                return lettersListOnKey;
            }
        } catch (Exception e){
            throw new InvalidKeyException("E00001", "key is not valid");
        }


    }


}
