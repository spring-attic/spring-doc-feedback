package io.spring.docs.feedback;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/feedback/download/{projectName}")
public class CsvExportController {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	 
	@GetMapping("/feedback/download/{projectName}")
	public void downloadCSV(@PathVariable String projectName, HttpServletResponse response) throws IOException{
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=feedback.csv");
	    
		List<Feedback> feedbackRecords;
		if (projectName.equals("All")) {
			feedbackRecords = (List<Feedback>) feedbackRepository.findAll();
		} else {
			feedbackRecords = (List<Feedback>) feedbackRepository.findByProjectName(projectName);
		}
		CsvExporter.writeToCsv(response.getWriter(), feedbackRecords);
	}
}
