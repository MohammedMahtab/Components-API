package com.api.component.util;

import java.util.StringTokenizer;
//check the string
public class StringTokenizerTest {
	
	public static void main(String... args) 
	{ String name = "API,Services "; 
	StringTokenizer tokenizer = new StringTokenizer(name, ",");
	while (tokenizer.hasMoreTokens()) 
	{ System.out.println(tokenizer.nextToken());
	}
	}

	

}
