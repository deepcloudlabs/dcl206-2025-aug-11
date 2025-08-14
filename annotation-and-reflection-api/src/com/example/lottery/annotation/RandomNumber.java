package com.example.lottery.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
	ElementType.FIELD,
	ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RandomNumber {

	int min() default 1;

	int max();

	int size();

	boolean distinct() default true;

	boolean sorted() default true;

}
