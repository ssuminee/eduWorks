<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<link href="${pageContext.request.contextPath}/resources/css/schedule.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<jsp:include page="../common/header.jsp" />
	
	<div>
	    
	    <div class="su_contentArea">
	        <div class="su_content_header">
	            <h2 class="su_sub_menu_name" style="color: black;">상담 일정 상세</h2>
	
	            <hr class="hr_line_top" style="margin-bottom: 0px;">
	            <form action="update.cn" method="post" id="updateForm">
		            <div style="display: flex;">
		                <div class="su_content_body" style="width: 80%;">
		    
		                    <table id="eventForm">
		                        <tr>
		                            <td width="5%;"><span class="fas fa-star-of-life fontRed">&nbsp;</span></td>
		                            <td><span>&nbsp;내담자명</span></td>
		                            <td style="width: 80%;">
		                            &ensp; &ensp;<input type="text" name="cnslnTitle" placeholder="내담자명 입력" style="width:300px;" value="${ c.cnslnTitle }" required>
		                            </td>
		                        </tr>
		
		                        <tr>
		                            <td width="5%;"><span class="fas fa-star-of-life fontRed">&nbsp;</span></td>
		                             <td><span>&nbsp;상담 시간</span></td>
		                             <td>
		                                 &ensp; &ensp;<input type="date" id="cnslnStartD" required>&nbsp;
		                                 <input type="time"  id="cnslnStartT"  required>
		                                 <span> ~ </span>
		                                 &nbsp;<input type="time" name="cnslnEndT" id="cnslnEndT" required>
		                                 
		                                 <span style="display: none;" id="sDT">${ c.cnslnStartDate }</span>
		                                <span style="display: none;" id="eDT">${ c.cnslnEndDate }</span>
		                                 <input type="hidden" name="cnslnStartDate">
		                                <input type="hidden" name="cnslnEndDate">
		                             </td>
		                        </tr>
		
		                        <tr>
		                            <td width="5%;"><span>&nbsp;</span></td>
		                            <td><span>&nbsp;담당자</span></td>
		                            <td id="chargeArea">
		                                <!-- 선택한 담당자 영역 -->
		
		                                <span style="cursor: pointer;" id="addAttendee"> &ensp;&ensp;+ 담당자 추가</span>
		                            </td>
		                        </tr>
		
		                        <tr>
		                            <td width="5%;"><span class="fas fa-star-of-life fontRed">&nbsp;</span></td>
		                             <td><span>&nbsp;전화번호</span></td>
		                             <td width="670px;">
		                             &ensp;&ensp;&ensp;<input type="text" name="cnslnPhone" id="cnslnPhone" value="${ c.cnslnPhone }" style="width: 640px;" placeholder="학생의 전화번호를 입력해주세요"></span>
		                             </td>
		                        </tr>
		
		                        <tr>
		                            <td style="padding-top: 13px; vertical-align: top;"><span class="fas fa-star-of-life fontRed">&nbsp;</span></td>
		                             <td style="vertical-align: top;">
		                                 <span style="display: inline-block; margin-top: 10px;">&nbsp;상담 주제</span>
		                             </td>
		                             <td>
		                             &ensp;&ensp;&ensp;<textarea style="width: 640px;" name="cnslnTopic" id="cnslnTopic" placeholder="상담 주제를 입력해주세요">${ c.cnslnTopic }</textarea>
		                             </td>
		                        </tr>
		
		                    </table>
		                    
		                    <!-- 담당자 추가 창 -->
	                     <div class="su_ph_div dis_no ui-draggable" id="attCalList" style="top: 195px; left: 1070px;">
	                         <aside class="ph_aside">
	                             <div class="su_ph_header" style="position: static">
	                                 <div class="su_ph_title">
	                                     <h5 class="mt-1 mb-2" id="moveCal" style="color: black;">담당자 추가<span class="fas fa-xmark" id="xBtn" style="cursor: pointer;"></span></h5>
	                                 </div>
	                             </div>
	                         </aside>
	                         <div style="text-align: center;">
	                             <input type="text" id="chargeKeyword" name="suPhKeyword" placeholder="이름/직책">
	                             <button type="button" class="su_btn_border btn-sm" onclick="searchCharge();">검색</button>
	                         </div>
	                         
	                         <hr class="hr_line">
	
	                         <div class="su_ph_body">
	                             <div class="div_left_line" id="listArea" style="margin-top: -1rem;">
	                             
	                             	<c:forEach var="m" items="${ mList }">
	                               		<c:if test="${ m.deptCode eq 'DN' }">
	                               			<div class="su_ph_line ph_padding" onclick="chooseCharge(${ m.memNo });">
			                                    <span style="font-size: 20px;">&nbsp;</span>
			                                    <span class="fas fa-user"></span>
			                                    <span>&nbsp; ${ m.memName } &nbsp; ${ m.jobName }</span>
			                                </div>
		                                </c:if>
		                            </c:forEach>
	                                 
	                                 <!-- 운영부 주소록 -->
	                                 <div class="su_ph_line">
	                                     <div class="collapsed ph_padding" data-toggle="collapse" data-target="#promoList" aria-expanded="true" aria-controls="collapseTwo">
	                                         <span style="font-size: 20px;">-&nbsp;</span>
	                                         <span style="font-size: 20px;">+&nbsp;</span>
	                                         <span>&nbsp; 홍보팀</span>
	                                     </div>
	
	                                     <!-- 홍보팀 리스트 -->
	                                     <div id="promoList" class="collapse div_left_line" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
	                                         <table class="su_Tb">
	                                         
	                                         	<c:forEach var="m" items="${ mList }">
	                                        		<c:if test="${ m.deptCode eq 'D3' }">
			                                            <tr style="width: 100%;" class="ph_padding">
			                                                <td width="90%;">
			                                                    <div class="su_ph_line" onclick="chooseCharge(${ m.memNo });">
			                                                        <span style="font-size: 20px;">-&nbsp;</span>
			                                                        <span class="fas fa-user"></span>
			                                                        <span>&nbsp; ${ m.memName } &nbsp; ${ m.jobName }</span>
			                                                    </div>
			                                                </td>
			                                            </tr>
			                                        </c:if>
			                                    </c:forEach>
	                                             
	                                         </table>
	                                     </div>
	                                 </div>
	                             </div>
	                         </div>    
	                     </div>    
		
		                    <br><br>
		
		                    <div class="su_btn_two_center">
		                    	<c:if test="${ loginUser.memNo == c.cnslnWriter }">
		                        	<button type="button" class="btn su_btn_two su_btn_border" id="updateBtn" data-toggle="modal" data-target="#noContent">수정</button>
		                        	<button type="button" class="btn su_btn_two su_btn_border" id="deleteBtn" data-toggle="modal" data-target="#delete">삭제</button>
		                        </c:if>
		                        <c:if test="${ loginUser.memNo != c.cnslnWriter }">
		                        	<button type="button" class="btn su_btn_two su_btn_border" id="updateBtn" disabled>수정</button>
		                        	<button type="button" class="btn su_btn_two su_btn_border" id="deleteBtn" data-toggle="modal" data-target="#delete" disabled>삭제</button>
		                        </c:if>
		                        
		                        <button type="button" class="btn su_btn_two su_btn_border" onclick="location.href='list.cn';">돌아가기</button>
		                    </div>
		                    
		                     <script>
		                    	$(document).ready(function(){
		                    		
		                         	// 참석자 추가 창 display
		                            $(document).on("click", "#addAttendee", function(){
		                                $("#attCalList").removeClass("dis_no");
		                                $("#attCalList").addClass("dis_bl");
		                            });
		
		                            $(document).on("click", "#xBtn", function(){
		                                $("#attCalList").removeClass("dis_bl");
		                                $("#attCalList").addClass("dis_no");
		                            });
		                            
		                            // 시작일 종료일 시간 value 설정
		                            var sDT = new Array();
		                            var eDT = new Array();
		                            var sDtStr = $("#sDT").text();
		                            var eDtStr = $("#eDT").text();
		                            sDT = sDtStr.split(" ");
		                            eDT = eDtStr.split(" ");
		                            
		                            var sD = sDT[0];
		                            var sT = sDT[1];
		                            //console.log(sD);
		                            var eD = eDT[0];
		                            var eT = eDT[1];
		                            
		                            $("#cnslnStartD").val(sD);
		                            $("#cnslnStartT").val(sT);
		                            $("#cnslnEndT").val(eT);
		                            
		                         	// 참석자가 있을 경우 화면에 표시
		                         	if( $("#chargeNo2").text() != "" ){
		                         		// 맨 뒤 콤마 제거
		                         		var no = $("#chargeNo2").text();
		                         		var li = $("#chargeList2").text();
			                    		//$("#atndNo2").text(no.substring(0, no.lastIndexOf(",")));
			                    		//$("#atndList2").text(li.substring(0, li.lastIndexOf(",")));
			                    		
			                    		var no2 = no.substring(0, no.lastIndexOf(","));
			                    		var li2 = li.substring(0, li.lastIndexOf(","));
			                    		
		                         		var anArr = new Array();
		                         		var alArr = new Array();
		                         		var anStr = no2;
		                         		var alStr = li2;
		                         		anArr = anStr.split(",");
		                         		alArr = alStr.split(",");
		                         		
		                         		//console.log(anArr);
		                         		var val = $("#chargeArea").html();
		                         		
		                         		for(let i = 0; i < anArr.length; i++){
		                         			val += ' <div class="su_atndDiv" id="atnd' + anArr[i] + '">'
													+ '<span>' + alArr[i] + '</span>';
												if( ${ loginUser.memNo == c.cnslnWriter }){
													val += '<button class="btn" type="button" onclick="back(' + anArr[i] + ');">X</button>';
												} 
													val += '</div> &nbsp;';
		                         		}
		                         		$("#chargeArea").html(val);
		                         		
		                         	}
		                         	
		                    	})
	                         	
	                            // 선택한 담당자 추가
                            function chooseCharge(mNo){
	                        	var value = $("#chargeArea").html();
	                        	var chargeNoStr = $("#chargeNo2").val();
	                        	var chargeListStr = $("#chargeList2").val();
	                        	
                            	$.ajax({
                            		url: "chcharge.cn",
                            		data: {memNo: mNo},
                            		success: function(m){
                            			//console.log(m);	// 멤버 객체
                            			var chargeNo = m.memNo;
                            			var chargeList = m.memName + " " + m.jobName;
                            			chargeNoStr += chargeNo + ",";
                            			chargeListStr += chargeList + ",";
                            			
                            			$("#chargeNo2").val(chargeNoStr);	// 담당자 번호 리스트
                            			$("#chargeList2").val(chargeListStr);	// 담당자 명단 리스트
                            			$("#cnslnChargeNo").val($("#chargeNo2").val());
                            			$("#cnslnChargeList").val($("#chargeList2").val());
                            			
                            			var noList = chargeNo + chargeList;
                            			
										value += ' <div class="su_atndDiv" id="charge' + chargeNo + '">'
												+ '<span>' + chargeList + '</span>'  
												+ '<button class="btn" type="button" onclick="back(' + chargeNo + ');">X</button>'
											   + '</div> &nbsp;';
											   
										$("#chargeArea").html(value);
                            		}, error: function(){
                            			console.log("ajax 참석차 추가 실패");
                            		}
                            	});
                                
                            }
	                        
	                        // 담당자 번호 리스트 삭제 클릭 이벤트
	                        function back(no){
	                        	// no : 선택한 멤버 변호
	                        	var id="charge" + no;
	                        	var nolist = $("#chargeNo2").val();
	                        	//console.log(nolist);
	                        	
	                        	//console.log($("#" + id).children().eq(0).text());
	                        	var name = $("#" + id).children().eq(0).text();
	                        	
	                        	$("#" + id).remove();
	                        	
	                        	no = no + ",";
	                        	nolist = nolist.replace(no, "");
	                        	$("#chargeNo2").val(nolist);
	                        	$("#cnslnChargeNo").val($("#chargeNo2").val());
	                        	//console.log($("#atndNo2").val());
	                        	backList(name);
	                        }
	                        
	                        // 담당자 이름 리스트 삭제 이벤트
	                        function backList(name){
	                        	//console.log(name);
	                        	var namelist = $("#chargeList2").val();
	                        	
	                        	name = name + ",";
	                        	//console.log(name);
	                        	namelist = namelist.replace(name, "");
	                        	console.log(namelist);
	                        	$("#chargeList2").val(namelist);
	                        	$("#cnslnChargeList").val($("#chargeList2").val());
	                        }
	                        
	                        // 담당자 검색 이벤트
	                        function searchCharge(){
	                        	var key = $("#chargeKeyword").val();
	                        	var value = "";
	                        	var pCount = 0;	// 홍보
	                        	$.ajax({
	                        		url: "search.cn",
	                        		data: {keyword: key},
	                        		success: function(list){
	                        			console.log(list);
	                        			
	                        			for(let i = 0; i < list.length; i++){
	                        				if(list[i].deptCode == 'DN'){
	                        					value += '<div class="su_ph_line ph_padding" onclick="chooseCharge(' + list[i].memNo + ');">'
	                        								+ '<span style="font-size: 20px;">&nbsp;</span>'
	                        								+ '<span class="fas fa-user"></span>'
	            		                                    + '<span>&nbsp; ' + list[i].memName + ' &nbsp; ' + list[i].jobName + '</span>'
	            		                                    + '</div>';
	                        				}
	                        			}
                            			
	                                            
										for(let i = 0; i < list.length; i++){
	                        				if(list[i].deptCode == 'D3'){
	                        					pCount++;
	                        				}
	                        			}  
										
										if(pCount > 0){
											value += '<div class="su_ph_line"><div class="collapsed ph_padding" data-toggle="collapse" data-target="#promoList" aria-expanded="true" aria-controls="collapseTwo">'
	                                        			+ '<span style="font-size: 20px;">-&nbsp;</span>'
	                                        			+ '<span style="font-size: 20px;">+&nbsp;</span>'
	                                        			+ '<span>&nbsp; 홍보팀</span>'
	                                    		   + '</div>'

	                                			   + '<div id="promoList" class="collapse div_left_line" aria-labelledby="headingTwo" data-parent="#accordionSidebar">'
	                                    				+ '<table class="su_Tb_Pr">';
										}
										
                                    	for(let i = 0; i < list.length; i++){
                                    		if(list[i].deptCode == 'D3'){
	                                    		value += '<tr style="width: 100%;" class="ph_padding">'
                                                			+ '<td width="90%;">'
                                                				+ '<div class="su_ph_line" onclick="chooseCharge(' + list[i].memNo + ');">'
                                                    				+ '<span style="font-size: 20px;">-&nbsp;</span>'
                                                    				+ '<span class="fas fa-user"></span>'
                                                    				+ '<span>&nbsp; ' + list[i].memName + ' &nbsp; ' + list[i].jobName + '</span>'
                                                    			+ '</div></td></tr>';
                                    		}
                                    	}
                                    	
                                    	if(pCount > 0){
                                    		value += '</table></div></div></div>';
                                    	}
                                
										
	                                    if(pCount > 0){
	                                    	value += '</div></div>';
	                                    }
	                                    
	                        			$("#listArea").html(value);   
	                        			}, error: function(){
	                        			console.log("ajax 검색 실패");
	                        		}
	                        	});
	                        }
	                    	</script>
		
		                    
		                    <br><br><br><br><br>
		
		                    <!-- 삭제 모달창 -->
		                    <div class="modal" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		                        <div class="modal-dialog modal-dialog-centered cascading-modal modal-avatar" role="document">
		                            <!--Content-->
		                            <div class="modal-content modal_alert">
		                                
		                                <!--Body-->
		                                <div class="modal-body text-center modal_alert_child">
		                                    <div>
		                    
		                                        <h5 class="mt-1 mb-2">정말 삭제하시겠습니까?</h5>
		                                        <br>                                
		                                        <div class="text-center mt-4"> 
		                                            <button type="button" id="realDelete" class="btn su_btn_all su_btn_medium">확인</button>
		                                            <button type="button" id="next" class="btn su_btn_border su_btn_medium" data-dismiss="modal">취소</button>
		                                        </div>
		
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		
		                     <!-- ==================================== 삭제 완료 후 alert창 출력하기==================================================== -->
		                
		    
		                
		                </div>
		                
		                <!-- 댓글 영역 -->
		                <!-- 내가 작성한 댓글은 옆에 삭제 버튼 추가 -->
		                                <div class="su_sub_menu_div_left">
		                                    <div class="reply_header">
		                                        <h4> &ensp;댓글 <span>1</span></h4>
		                                    </div>
		
		                                    <hr class="hr_line">
		                                    
		                                    <div class="su_one_reply">
		                                        <div>
		                                            <img src="resources/defaultProfile.png" alt="">
		                                        </div>
		                                        <div class="su_reply_content">
		                                            <h5 class="font-weight-bold">김미영 팀장</h5>
		                                            <p>세미나 끝나고 회식 있습니다.
		다들 참석해주세요~</p>
		                                            <!-- 자기가 쓴 댓글에만 출력, 자기가 쓴 댓글엔 대댓글 작성 영역 표시 안함 -->
		                            <!-- <button type="button" class="btn btn-sm su_btn_border" style="float: right;">삭제</button> -->
		
		                            <div class="su_reReply">
		                                <div class="su_beforeReRe dis_bl">
		                                    <span class="fas fa-share">&ensp;</span>
		                                    
		                                    <a id="insertReReplyBtn">댓글</a>
		                                </div>
		
		                                <!-- 댓글 작성 영역 -->
		                                
		                                <div class="su_insert_reReply">
		                                    <div class="su_afterReRe dis_no">
		                                        <div class="su_reReply_input">
		                                            <span class="fas fa-share"> </span>
		                                            <!-- 로그인 한 사원 사진 -->
		                                            <img src="resources/defaultProfile.png" alt="">
		                                    
		                                            <input type="text" placeholder="댓글 입력" name="" id="reReContent">
		                                            <button type="button" class="btn btn-sm su_btn_border">작성</button>
		                                            
		                                            <span class="fas fa-xmark" id="replyX"> </span>
		                                        </div>
		                                    </div>
		                                </div>
		                    
		                            </div>
		
		                            </div>
		                        </div>
		                        
		                         <!-- 대댓글 작성 버튼 누르면 바뀜 -->
		                         <script>
		                            $(document).ready(function(){
		                                $("#insertReReplyBtn").click(function(){
		                                    $(".su_beforeReRe").hide();
		                                    $(".su_afterReRe").show();
		                                    $(".su_afterReRe input").focus();
		                                });
		
		                                $("#replyX").click(function(){
		                                    $(".su_beforeReRe").show();
		                                    $(".su_afterReRe").hide();
		                                    $("#reReContent").val("");
		                                });
		                            })
		                        </script>
		
		                        <br>
		                        
		                        <!-- 댓글 작성 영역 -->
		                        <div class="su_insert_reply">
		                                <!-- 로그인 한 사원 사진 -->
		                                    <img src="resources/defaultProfile.png" alt="">
		                                
		                                    <div class="su_reply_input">
		                                        <input type="text" placeholder="댓글 입력" name="">
		                                        &nbsp;
		                                        <button type="button" class="btn btn-sm su_btn_border">작성</button>
		                                    </div>
		                                
		                            </div>
		
		                            <br><br><br>
		
		                        </div>
		
		                    </div>
						</form>
	                </div>
	            </div>
	        </div>
	
	    </div>
	
	
	
	</div>    
	
	<jsp:include page="../common/footer.jsp" />

</body>
</html>