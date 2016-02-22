package com.java.parser;

import java.io.File;
import java.util.ArrayList;

public class WordReduce {
	ArrayList<String> frontlist=new ArrayList<String>(); // 뒷조사
	ArrayList<String> endlist=new ArrayList<String>(); //앞조사
	ArrayList<String> notlist=new ArrayList<String>(); //예외
	void defaultList(){
    /*
    ex)
    있고
    있다
    했다
    했고
     */
		//기호
		endlist.add(".");
		endlist.add(":");
		endlist.add("-");
		endlist.add("!");
		endlist.add("\"");
		//그외
		endlist.add("인");
		endlist.add("가");
		endlist.add("의");
		endlist.add("와");
		endlist.add("를");
		endlist.add("로");
		endlist.add("이");
		endlist.add("다");
		endlist.add("는");
		endlist.add("을");
		endlist.add("및");
		endlist.add("고");
		endlist.add("있다");
		endlist.add("하고");
		frontlist.add("\"");
		endlist.add(",");
		endlist.add("?");
		endlist.add("에서");
		endlist.add("수");
		notlist.add("온라인");
	}

	public WordReduce() {
		defaultList();
	}
	public WordReduce(File file){
		defaultList();
	}
	public String simplify(String content){
		for(String temp : notlist){
			if(content.equals(temp))
				return content;
		}
		for(String temp : frontlist){
			if(content.startsWith((temp))) {
				content = content.substring(temp.length(), content.length());
			}
		}
		for(String temp:endlist){
			if(content.endsWith((temp))) {
				content = content.substring(0, content.length() - temp.length());
			}
		}

		if(content.equals(""))
			return null;
		return content;
	}

}