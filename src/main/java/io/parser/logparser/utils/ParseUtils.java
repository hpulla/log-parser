package io.parser.logparser.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import io.parser.logparser.model.LineInfo;

@Component
public class ParseUtils {
	
	private final String ANONYMOUS_NAME = "anonymous";

	public LineInfo updateLineInfoWithNumberAndName(String input, LineInfo lineInfo) {
		
		char[] inputArray = input.toCharArray();
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while(i < inputArray.length && Character.isDigit(inputArray[i])) {
			sb.append(inputArray[i]);
			i++;
		}
				
		if(sb.length() > 0) {
			lineInfo.setLine_number(Integer.valueOf(sb.toString()));
		}
	
		if(input.endsWith("0")) {
			lineInfo.setName(ANONYMOUS_NAME);
			return lineInfo;
		}
		
		int lastIndex = input.length()-1;
		
		StringBuilder nameBuilder = new StringBuilder();
		
		while(lastIndex >=0 && inputArray[lastIndex]!= ' ') {
			nameBuilder.append(inputArray[lastIndex]);
			lastIndex--;
		}
		
		lineInfo.setName(StringUtils.reverse(nameBuilder.toString()));
		
		return lineInfo;
		
	}
	
	
}
