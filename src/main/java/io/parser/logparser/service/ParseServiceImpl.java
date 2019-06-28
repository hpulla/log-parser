package io.parser.logparser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.parser.logparser.model.LineInfo;
import io.parser.logparser.model.LogResponse;
import io.parser.logparser.utils.ParseUtils;

@Component
public class ParseServiceImpl implements ParseService {

	private final String ENTRY_OPERATION = "ENTER";

	private final String EXIT_OPERATION = "EXIT";
	
	@Autowired
	private ParseUtils parseUtils;

	@Override
	public LogResponse parse(byte[] bytes) {
		
		final LogResponse logResponse = new LogResponse();
		
		final List<LineInfo> lineList = new ArrayList<>();

		String content = new String(bytes);
		String[] lines = content.split(System.getProperty("line.separator"));

		for (String line : lines) {

			int entryIndex = line.indexOf(ENTRY_OPERATION);
			int exitIndex = line.indexOf(EXIT_OPERATION);

			if (entryIndex >= 0 || exitIndex >= 0) {
							
				final LineInfo info = new LineInfo();
				String operation = null;

				if(entryIndex >= 0) {
					operation = line.substring(entryIndex, entryIndex+ENTRY_OPERATION.length());				
				}else {
					operation = line.substring(exitIndex, exitIndex+EXIT_OPERATION.length());
				}			
				info.setOperation(operation);
				
				int startIndex = line.indexOf('/');
				int endIndex = line.lastIndexOf('/');
				
				int colonIndex = line.indexOf(":", endIndex);
				
				String fileName = line.substring(startIndex, colonIndex);
				info.setFilename(fileName);
							
				parseUtils.updateLineInfoWithNumberAndName(line.substring(colonIndex+1), info);
				
				lineList.add(info);

			}

		}
		
		logResponse.setResult(lineList);

		return logResponse;
	}

}
