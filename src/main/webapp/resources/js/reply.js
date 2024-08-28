/**
* 댓글 ajax 처리용 javaScript 파일 분리
*/

console.log("댓글용 모듈 실행 중...");

var replyService = (function() { // 변수 생성
	function add(reply, callback, error) { // 외부에서 replyService.add(객체, 콜백)을 전달하는 형태
		console.log("댓글 추가용 함수......");

		$.ajax({
			type: "post", 		//@PostMapping
			url: "/replies/new",	//http://localhost:80/replies/nes
			data: JSON.stringify(reply),	//json으로 받아 객체로 넘김 
			contentType: "application/json; charset=UTF-8",
			success: function(result, status, xhr) { // 위 코드 성공시 함수 처리
				// result : 결과 // status : 200, 500
				//** xhr : xmlHttpRequest 객체(Servlet에서 요청 객체와 유사함.)
				if (callback) { // callback = true 이면, 아래 코드 실행
					callback(result);
				} // end if(callback)
			}, // end function(success)
			error: function(xhr, status, er) {
				if (error) { // error 가 있으면, 아래 코드 실행
					error(er);
				}// end if(error)

			}// end function(error)

		}) // end ajax

	} // end function(add)


	function getList(param, callback, error) {
		var bno = param.bno;
		var page = param.page || 1;

		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
			function(data) {
				if (callback) {
					callback(data.replyCnt, data.list);
				}
			}).fail(function(xhr, status, err) {
				if (error) {
					error();
				}
			});
	}

	function remove(rno, callback, error) {
		$.ajax({
			type: "delete",
			url: "/replies/" + rno,
			success: function(deleteResult, status, xhr) {
				if (callback) {
					callback(deleteResult);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function update(reply, callback, error) {
		console.log("rno : " + reply.rno);

		$.ajax({
			type: "put",
			url: "/replies/" + reply.rno,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=UTF-8",
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});

	}

	function get(rno, callback, error) {
		$.get("/replies/" + rno + ".json", function(result) {
			if (callback) {
				callback(result);
			}

		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	function displayTime(timeValue) {
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);
		var str = "";

		if (gap < (1000 * 60 * 60 * 24)) {
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();

			return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
				':', (ss > 9 ? '' : '0') + ss].join('');
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			return [yy, '/', (mm > 9 ? '' : '0') + mm, '/',
				(dd > 9 ? '' : '0') + dd].join('');
		}

	};

	return {
		add: add,
		getList: getList,
		remove: remove,
		update: update,
		get: get,
		displayTime: displayTime
	};
})();
