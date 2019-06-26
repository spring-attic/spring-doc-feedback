package io.spring.docs.feedback;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    private final short starNumber;
    private final String feedbackText;
    private final String email;
    private final String projectName;
    private final String pageId;
    private final String path;
	private final String heading;
	private final String browserName;
    private final String browserVersion;
    private final String osName;
    private final String osVersion;
	private final String dateString;
	private final Long timestamp;

    public Feedback() {
    	starNumber = 0;
    	feedbackText = "";
    	email="";
    	projectName = "";
    	pageId = "";
    	path = "";
    	heading ="";
    	browserName = "";
    	browserVersion = "";
    	osName = "";
    	osVersion = "";
    	dateString = "";
    	timestamp = 0L;
    }

    public short getStarNumber() {
		return starNumber;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public String getEmail() {
		return email;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getPageId() {
		return pageId;
	}

    public String getPath() {
		return path;
	}

	public String getHeading() {
		return heading;
	}

	public String getBrowserName() {
		return browserName;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public String getOsName() {
		return osName;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public String getDateString() {
		return dateString;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	
}
