EWApp = {
	submitForm : function(form) {
		if (form.length) {
			EWApp.formObject = {};
			$.each(form.serializeArray(), function() {
				EWApp.formObject[this.name] = this.value;
			});
			$.ajax({
				type : "POST",
				url : "/json/noteTags",
				data : JSON.stringify(EWApp.formObject),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(data) {
					var errorBlock = $("#errorBlock");
					if (form.length) {
						if (data.error) {
							if (errorBlock.length) {
								errorBlock.text(data.error);
							} else {
								form.after("<div id='errorBlock'>" + data.error
										+ "</div>");
							}

						}else{
							form.remove(errorBlock);
							
						}
					}
				}

			});

		}
	}
};
initApp = function() {
	$.getJSON("/json/noteTags", function(response) {

		EWApp.noteTags = response;
		var noteTagSelect = $('#noteTag')
		if (noteTagSelect) {

			$(EWApp.noteTags).each(
					function() {

						noteTagSelect.append($("<option></option>").attr(
								"value", this.id).text(this.name));
					});

		} else {
			$.error('Cant find #noteTag element');
		}
	});

};
$(document).ready(initApp);