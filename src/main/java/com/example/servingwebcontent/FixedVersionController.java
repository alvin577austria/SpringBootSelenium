package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FixedVersionController {

	@RequestMapping("/fixedversion")
	public String getFixedVersion(@RequestParam(name="version", required=false, defaultValue="1.0") String version, Model model) {
		return "1.0";
	}

}
