package io.parser.logparser.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.parser.logparser.model.LogResponse;
import io.parser.logparser.service.ParseService;

@RestController
@RequestMapping("/api/v1/parser")
public class LogParserController {

	@Autowired
	private ParseService parseService;

	private Logger LOG = LoggerFactory.getLogger(LogParserController.class);
	
	/**
	 * End point for handling single file, parse it and send it back
	 * @param uploadedFile
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {

		try {
			final LogResponse logResponse = parseService.parse(uploadedFile.getBytes());
			return new ResponseEntity<>(logResponse, HttpStatus.OK);

		} catch (IOException e1) {
			return new ResponseEntity<>("Failed to process files", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * End point for handling multiple files, parse it and send it back
	 * @param uploadedFile
	 * @return
	 */
	@PostMapping("/multi")
	public ResponseEntity<Object> uploadMultiFiles(
			@RequestParam("files") MultipartFile[] uploadingFiles) {

		for (MultipartFile uploadedFile : uploadingFiles) {

			LOG.info("Processing file " + uploadedFile);

			// Create Executor Service of java concurrency with some fixed thread pool and
			// handover the file to each
			// available thread that can call parse service . In the end , we join all the
			// results and send back to the
			// client.

		}

		return new ResponseEntity<>(new LogResponse(), HttpStatus.OK);

	}

}
