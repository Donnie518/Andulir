package org.andulir.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ConcurrentModificationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(AndulirSystemException.class)
    public void systemExceptionHandler(AndulirSystemException systemException) {
        log.error("Andulir出现异常！ {}",systemException.toString());
    }

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        log.error("Andulir出现异常！ {}",e.toString());
    }


    @ExceptionHandler(NullPointerException.class)
    public void nullPointerExceptionHandler(NullPointerException nullPointerException){
        log.error("Andulir出现空指针异常！ {}", nullPointerException.toString());
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public void arrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
        log.error("Andulir出现数组下标越界异常！ {}", arrayIndexOutOfBoundsException.toString());
    }

    @ExceptionHandler(ArithmeticException.class)
    public void arithmeticExceptionHandler(ArithmeticException arithmeticException){
        log.error("Andulir出现算术运算异常！ {}", arithmeticException.toString());
    }
    @ExceptionHandler(ClassCastException.class)
    public void classCastExceptionHandler(ClassCastException classCastException){
        log.error("Andulir出现类型转换异常！ {}", classCastException.toString());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException){
        log.error("Andulir出现非法参数异常！ {}", illegalArgumentException.toString());
    }
    @ExceptionHandler(NumberFormatException.class)
    public void numberFormatExceptionHandler(NumberFormatException numberFormatException){
        log.error("Andulir出现数字格式异常！ {}", numberFormatException.toString());
    }
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public void indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException indexOutOfBoundsException){
        log.error("Andulir出现索引越界异常！ {}", indexOutOfBoundsException.toString());
    }
    @ExceptionHandler(ConcurrentModificationException.class)
    public void concurrentModificationExceptionHandler(ConcurrentModificationException concurrentModificationException){
        log.error("Andulir出现并发修改异常！ {}", concurrentModificationException.toString());
    }
}
