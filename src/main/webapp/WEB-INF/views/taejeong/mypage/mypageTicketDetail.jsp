<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/header.jsp" />

<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
.header {
	background-color: #f1f1f1;
	padding: 30px;
	text-align: center;
	font-size: 35px;
}

/* Create three unequal columns that floats next to each other */
.column {
	float: left;
	padding: 10px;
}

/* Left and right column */
.column.side {
	width: 20%;
}

/* Middle column */
.column.middle {
	width: 60%;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
.footer {
	background-color: #f1f1f1;
	padding: 10px;
	text-align: center;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media ( max-width : 600px) {
	.column.side, .column.middle {
		width: 100%;
	}
}

th {
	font-size: 14px;
	color: #666666;
	background-color: #f8f8f8;
	text-align: center;
	padding: 14px 0px;
	border-top: 1px solid #e1e4e6;
	border-bottom: 1px solid #e1e4e6;
}

td {
	font-size: 13px;
	text-align: center;
	padding: 10px 0px;
	border-top: 1px solid #e1e4e6;
	border-bottom: 1px solid #e1e4e6;
}

.divider {
	height: 30px;
	width: 100%;
}

.selectFrom {
	float: right;
}

.selectBtn {
	display: inline-block;
	padding: 6px 12px;
}

select, option {
	font-size: 14px;
	padding: 0 12px;
}

.titleZone {
	border-bottom: 2px solid #999;
}

.main_wrapper {
	padding: 38px 39px 100px;
}

.cancelBtn {
	text-align: center;
}
</style>

<div class="row" style="margin: 0px;">
	<div class="column side" style="background-color: #f4f4f4;"></div>
	<div class="column middle">
		<div class="row">
			<div class="side_wrapper col-2">
				<jsp:include
					page="/WEB-INF/views/taejeong/include/mypageSideNav.jsp" />
			</div>
			<div class="main_wrapper col-10">
				<div class="titleZone">
					<h3>์๋งคํ์ธ/์ทจ์</h3>
				</div>
				<div class="main_content">
					<p style="font-size: 13px; color: #999; margin: 36px 0 26px;">
						์ทจ์ํ๊ธฐ๋ฅผ ๋๋ฌ์ ์๋งค๋ฅผ ์ทจ์ํ์ธ์.</p>

					<div class="selectZone"></div>
					<div class="divider"></div>
					<h5>์๋งคํ ํฐ์ผ์?๋ณด</h5>
					<div>
						<table>
							<colgroup>
								<col style="width: 100px;">
								<col style="width: 150px;">
								<col style="width: 100px;">
								<col style="width: 150px;">
							</colgroup>
							<tbody>
								<c:forEach items="${ticketList }" var="ticketList"
									varStatus="status">
									<tr>
										<th>ํฐ์ผ๋ช</th>
										<td>KIA Tigers vs ${ticketList.rival }</td>
										<th>์๋งค์</th>
										<td>${ticketList.buyer }</td>
									</tr>
									<tr>
										<th>๊ฒฝ๊ธฐ์ผ์</th>
										<td>${ticketList.gameDate } ${ticketList.gameTime }</td>
										<th>๊ฒฐ์?์๋จ</th>
										<td>์?์ฉ์นด๋</td>
									</tr>
									<tr>
										<th>์ข์</th>
										<td>${ticketList.baseballZone }</td>
										<th>ํ์ฌ์ํ</th>
										<td>${empty ticketList.refund ? "๊ฒฐ์?์๋ฃ" : "๊ฒฐ์?์ทจ์" }</td>
									</tr>
									<tr>
										<th>์๋งค์ผ</th>
										<td>${ticketList.buyDate }</td>
										<th></th>
										<td></td>
										
									</tr>
									<input type="hidden" id="baseballNo" value="${ticketList.baseballNo}">
								</c:forEach>
							</tbody>
						</table>
						<div class="cancelBtn">
							<button type="button" class="btn btn-secondary" id="cancelBtnA" onclick="confirmCheck()">์ทจ์ํ๊ธฐ</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="column side" style="background-color: #f4f4f4;"></div>
</div>
<script>
	/* ์๋งค์ทจ์ alert */
	function confirmCheck(){
		var baseballNo = $("#baseballNo").val();
		var con = confirm("์๋งค๋ฅผ ์ทจ์ ํ์๊ฒ?์ต๋๊น?");
		if(con){
			alert("์๋งค๊ฐ ์ทจ์๋์์ต๋๋ค.");
			location.href = "/ticket/ticketCancel?baseballNo=" + baseballNo;
		}
	}

	/* ์๋งค์ทจ์ ๊ฐ๋ฅ์ผ ๊ณ์ฐ */
	function calCancelDate() {
		var strDate = $("gameDate").val();
		var arr = strDate.split('-');
		var dat = new Date(arr[0], arr[1], arr[2]);
		dat.setDate(dat.getDate() - 1);
		$(".cancelDate").text(dat);
	}

	$(function() {
		$('td[onload]').trigger('onload');
	});

	$(".btn-outline-secondary").click(function() {
		$(".btn-outline-secondary").removeClass("active");
		$(this).addClass("active");
	});
	
	
</script>


<jsp:include page="/WEB-INF/views/include/footer.jsp" />