/**
 * AdminLTE Demo Menu ------------------ You should not use this file in
 * production. This file is for demo purposes only.
 */
(function($, AdminLTE) {

	"use strict";

	setup();

	function setup() {

		$(".scrollbutton").click(function(e) {
			$(".box").scrollTop(1000);
		});

		$('#form').submit(function(e) {
			var status = true;
			console.log("submitForm");
			var libelle = $("#idlibelle");
			if (libelle.val().trim() == "") {
				libelle.css('border', "solid 1px red");
				status = false;
			}

			return status;
		});
		$("#idlibelle").keydown(function() {
			$(this).css('border', "solid 1px green");
		});
	}
})(jQuery, $.AdminLTE);
