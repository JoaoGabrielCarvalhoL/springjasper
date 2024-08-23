package br.com.joaogabriel.springjasper.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class JasperService {

	private final String JASPER_DIRECTORY = "classpath:jasper/";
	private final String JASPER_PREFIX = "funcionarios-";
	private final String JASPER_SUFIX = ".jasper";
	private final Connection connection;
	
	public JasperService(Connection connection) {
		this.connection = connection;
	}
	
	private Map<String, Object> parameters = new HashMap<>();
	
	public void addParameter(String key, Object value) {
		this.parameters.put(key, value);
	}
	
	public String getFullnameByNumber(String code) {
		return JASPER_DIRECTORY.concat(JASPER_PREFIX).concat(code).concat(JASPER_SUFIX);
	}
	
	public byte[] exportToPDF(String code) {
		try {
			File file = ResourceUtils.getFile(getFullnameByNumber(code));
			JasperPrint jasperPrint = JasperFillManager.fillReport(file.getAbsolutePath(), parameters, connection);
			return JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (JRException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
