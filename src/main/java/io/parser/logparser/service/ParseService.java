package io.parser.logparser.service;

import io.parser.logparser.model.LogResponse;

public interface ParseService {
	
	LogResponse parse(byte[] bytes);

}
