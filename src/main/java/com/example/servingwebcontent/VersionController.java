package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VersionController {

	@GetMapping("/version")
	public String getVersion(@RequestParam(name="version", required=false, defaultValue="1.0") String version, Model model) {
		model.addAttribute("version", version);
		return "version";
	}

}
