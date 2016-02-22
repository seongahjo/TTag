package com.java.parser;

public class WordReduce {
	public static String simplify(String content){
		if(content.endsWith("에서"))
			content=content.substring(0, content.length()-2);
		if(content.startsWith("\""))
			content=content.substring(1,content.length());
		switch(content.charAt(content.length()-1)){
			case '인':
			case '가':
			case '의':
			case '와':
			case '를':
			case '로':
			case '이':
			case '는':
			case '을':
			case '.':
			case ':':
			case '-':
			case '"':
			case '!':
			case ',':
			case '?':
				content=content.substring(0, content.length()-1);
				return content;
				
		}
		
		return content;
	}
	
}
