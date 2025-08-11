package com.example.graalvm.exercises.service.js;

import java.util.Arrays;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.springframework.stereotype.Service;

import com.example.graalvm.exercises.service.CalculatorService;

@Service
public class CalculatorServiceInJS implements CalculatorService {
	private final Context context = Context.create();
	
	@Override
	public Value run(String function, Object... params) {
          var jsFunction = context.eval("js", function);
          System.err.println(function);
          Arrays.stream(params).forEach(System.err::println);
          return jsFunction.execute(params);
	}

}
