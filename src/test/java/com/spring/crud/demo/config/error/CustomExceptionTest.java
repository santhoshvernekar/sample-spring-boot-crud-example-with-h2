package com.spring.crud.demo.config.error;

import com.spring.crud.demo.config.CustomException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CustomExceptionTest {
    private static final Logger log = LoggerFactory.getLogger(CustomExceptionTest.class);

    @Test(expected = CustomException.class)
    public void CustomExceptionTestWithoutParams() throws CustomException{
        log.info("Throw Base CustomException");
        throw new CustomException();
    }

    @Test(expected = CustomException.class)
    public void CustomExceptionTestWitMessage() throws CustomException{
        log.info("Throw CustomException WitMessage");
        throw new CustomException("Error");
    }

    @Test(expected = CustomException.class)
    public void CustomExceptionTestWitMessageAndThrowable() throws CustomException{
        log.info("Throw CustomException Wit Message and Throwable");
        throw new CustomException("Error", new CustomException());
    }
    @Test(expected = CustomException.class)
    public void CustomExceptionTestWithThrowable() throws CustomException{
        log.info("Throw CustomException With Throwable");
        throw new CustomException( new CustomException());
    }

    @Test(expected = CustomException.class)
    public void CustomExceptionTestWitMessageAndThrowableBooleans() throws CustomException{
        log.info("Throw CustomException With Message, Throwable and Booleans");
        throw new CustomException("Error", new CustomException(),true, true);
    }
}
