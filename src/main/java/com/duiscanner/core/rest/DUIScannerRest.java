package com.duiscanner.core.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DUICheckPoint;
import com.example.demo.webExtractor.DUIDataExtractor;

@RestController("duiAPIs")
public class DUIScannerRest {

	@GetMapping("/listAll")
	public List<DUICheckPoint> listAll() throws IOException {
		try {
			return DUIDataExtractor.processScan("http://www.duiblock.com/dui_checkpoint_locations/california/?page=", 3);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
