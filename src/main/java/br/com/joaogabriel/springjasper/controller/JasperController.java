package br.com.joaogabriel.springjasper.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaogabriel.springjasper.service.JasperService;

@RestController
@RequestMapping("/report")
public class JasperController {

	private final JasperService jasperService;
	
	public JasperController(JasperService jasperService) {
		this.jasperService = jasperService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<byte[]> generateReportByNumber(@RequestParam String code) {
		byte[] report = this.jasperService.exportToPDF(code);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentLength(report.length);
		headers.setContentDispositionFormData("attachment; filename=funcionarios-"+code+".pdf", "funcionarios-"+code+".pdf" );
		/**
		 * headers.setContentDispositionFormData("attachment; filename=\"" + image.getOriginalFileName() + "\"", 
				image.getOriginalFileName());
		 * */
		return new ResponseEntity<byte[]>(report, headers, HttpStatus.OK);
		
	}
}
