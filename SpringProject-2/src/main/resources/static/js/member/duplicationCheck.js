function checkId() {
	const getId = $("#new-userid").val();
	
	$.ajax({
		type: "POST",
		url: "/member/checkId",
		data: {memberId : getId},
		success: function(res) {
			if(res === "true") { // 중복이 있을 때
				$("#id-msg").css("color", "red");
				$("#id-msg").text("사용 불가능한 아이디입니다.");
			} else { // 중복이 없을 때
				$("#id-msg").css("color", "green");
				$("#id-msg").text("사용 가능한 아이디입니다.");
			}
		},
		error: function(err) {
			
		}
	})
}