package com.practice.spring.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition  implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		List<String> profiles = Arrays.asList(context.getEnvironment().getActiveProfiles());
		if(profiles.contains("Prod"))
			return true;
		else
			return false;
	}
	
}
