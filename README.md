# spring-doc-feedback is no longer actively maintained by VMware, Inc.

# Spring Doc Feedback

This project adds the ability to gather feedback from readers to the various Spring projects.

It consists of a Spring Data REST project that runs on Cloud Foundry (at https://spring-docs-feedback.cfapps.io/feedback) and a feedback-viewer HTML page. The readers (we hope) add feedback, including a rating and feedback text from within a document. That feedback gets stored in a MySQL database running behind the Spring Data REST application on Cloud Foundry. Then the feedback can be viewed in the viewer.
