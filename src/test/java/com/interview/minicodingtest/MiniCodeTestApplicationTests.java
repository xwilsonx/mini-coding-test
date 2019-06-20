package com.interview.minicodingtest;

import com.interview.minicodingtest.controller.KeypadController;
import com.interview.minicodingtest.exception.InvalidKeyException;
import com.interview.minicodingtest.pojo.KeypadPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Wilson
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MiniCodeTestApplicationTests {

    @Autowired
    KeypadController keypadController;

    @Test
    public void noNumber() throws InvalidKeyException {
        String[] arr = {};
        keypadController.printComplex(arr);
    }

    @Test
    public void oneNumberWithSingleDigit() throws InvalidKeyException {
        String[] arr = {"9"};
        keypadController.printComplex(arr);
    }

    @Test
    public void oneNumberWithtwoDigit() throws InvalidKeyException {
        String[] arr = {"99"};
        keypadController.printComplex(arr);
    }

	@Test
	public void twoNumberWithSingleDigit() throws InvalidKeyException {
        String[] arr = {"2", "3"};
        keypadController.printComplex(arr);
	}

	@Test
    public void twoNumberWithDoubleDigit() throws InvalidKeyException {
        String[] arr = {"22", "33"};
        keypadController.printComplex(arr);
    }

    @Test
    public void randomNumber() throws InvalidKeyException{
        String[] arr = new String[2];
        Random random = new Random();
        arr[0] = String.valueOf(random.nextInt(100));
        arr[1] = String.valueOf(random.nextInt(100));
        log.info(Arrays.asList(arr).toString());
        keypadController.printComplex(arr);
    }

}
