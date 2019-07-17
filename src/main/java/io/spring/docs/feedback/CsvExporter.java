package io.spring.docs.feedback;

import java.io.PrintWriter;
import java.util.List;

import com.opencsv.CSVWriter;

public class CsvExporter {

	static void writeToCsv(PrintWriter writer, List<Feedback> feedbackRecords) {
		String[] CSV_HEADER = {"id", "starNumber", "feedbackText", "email", "projectName", "pageId", "path",
				"heading", "browserName", "browserVersion", "osName", "osVersion", "dateString", "timestamp"};
		try (
			CSVWriter csvWriter = new CSVWriter(writer,
					CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);
		){
			csvWriter.writeNext(CSV_HEADER);
			for (Feedback feedback : feedbackRecords) {
				String[] data = {
						Long.toString(feedback.getId()),
						Short.toString(feedback.getStarNumber()),
						feedback.getFeedbackText(),
						feedback.getEmail(),
						feedback.getProjectName(),
						feedback.getPageId(),
						feedback.getPath(),
						feedback.getHeading(),
						feedback.getBrowserName(),
						feedback.getBrowserVersion(),
						feedback.getOsName(),
						feedback.getOsVersion(),
						feedback.getDateString(),
						Long.toString(feedback.getTimestamp())
				};

				csvWriter.writeNext(data);
			}
		} catch (Exception e) {
			System.out.println("Error while writing CSV.");
			e.printStackTrace();
		}
	}	
}
