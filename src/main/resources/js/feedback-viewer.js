var json = getData("https://spring-docs-feedback.cfapps.io/feedback");
loadData(json);

function getData(rest_url) {
  var json = (function () {
      var json = null;
      $.ajax({
          'async': false,
          'global': false,
          'url': rest_url,
          'dataType': "json",
          'success': function (data) {
              json = data;
          }
      });
      return json;
  })();
  return json;
}

function loadData(json) {
  $(function() {

    const feedbacks = json._embedded.feedbacks;

    const trs = json._embedded.feedbacks
//      .filter(f => f.projectName === null)
      .map(f =>{
        return `<tr>
          <td>${f.dateString}</td>
          <td>${f.starNumber}</td>
          <td>${f.projectName}</td>
          <td>${f.feedbackText}</td>
          <td>${f.email}</td>
          <td>${f.pageId}</td>
          <td>${f.path}</td>
          <td>${f.heading}</td>
          <td>${f.browserName}</td>
          <td>${f.browserVersion}</td>
          <td>${f.osName}</td>
          <td>${f.osVersion}</td>
        </tr>`
      });
    $('#feedbackHolder').html(`
      <table id="feedbackTable">
        <tr>
        <th>Date</th>
        <th>Rating</th>
        <th>Project Name</th>
        <th>Feedback</th>
        <th>Email</th>
        <th>Page ID</th>
        <th>Path</th>
        <th>Heading</th>
        <th>Browser Name</th>
        <th>Browser Version</th>
        <th>OS Name</th>
        <th>OS Version</th>
        </tr>
        ${trs.join('')}
      </table>`);
  })
}

$(document).ready(function() {
  // Button handlers
  $("#firstButton").on("click", (function() {
    json = getData(json._links.first.href);
    loadData(json);
  }));
  $("#previousButton").on("click", (function() {
    if (typeof json._links.prev !== "undefined") {
      json = getData(json._links.prev.href);
      loadData(json);
    }
  }));
  $("#nextButton").on("click", (function() {
    if (typeof json._links.next !== "undefined") {
      json = getData(json._links.next.href);
      loadData(json);
    }
  }));
  $("#lastButton").on("click", (function() {
    json = getData(json._links.last.href);
    loadData(json);
  }));

  // Project selector handler
  $("#project").on('change', function() {
    var projectName = this.value
    var link = "https://spring-docs-feedback.cfapps.io/feedback/search/findByProjectName?projectName=" + projectName;
    if (projectName === "all") {
      link = "https://spring-docs-feedback.cfapps.io/feedback";
    }
    json = getData(link);
    loadData(json);
  });
});
