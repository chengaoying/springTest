package cn.jackey.expression;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELTest {
	
	@Test
	public void spelTest(){
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("('hello' + 'world').concat(#end)");
		EvaluationContext elContext = new StandardEvaluationContext();
		elContext.setVariable("end","!");
		Assert.assertEquals("helloworld!", expression.getValue(elContext));
	}
}
