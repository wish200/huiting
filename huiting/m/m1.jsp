<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<% 
String audiourl = (String)request.getAttribute("audiourl");
String picurl = (String)request.getAttribute("picurl");
String name = (String)request.getAttribute("name");
String content = (String)request.getAttribute("content");
if(content==null){
	content = "";
}
System.out.println("1----"+audiourl+"-"+name);
System.out.println("1----"+picurl+"-"+content);
%>	
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>绘听</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta charset="utf-8">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/js/style.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/js/player.css" type="text/css">
    <script  type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.jplayer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jplayer.cleanskin.js"></script>

<style>

a{text-decoration:none;}
.share_btn{ width:98%; margin:0 1%; text-align:center; margin-bottom:15px;}
.share_btn a{ width:45%; padding:10px 0;display:inline-block;color:#333; background:#fff; border:#dedede solid 1px; border-radius:5px; text-align:center;box-shadow:rgba(0,0,0,0.2) 0 0 2px;}

.shade{ background:#000;opacity:0.8; height:100%; width:100%; position:fixed; display:none; top:0; left:0; z-index:9999; }
.simg{ position:relative; z-index:9999; top:5px; width:100%;}
.close{ position:fixed; font-size:28px; color:#fff; z-index:10000; display:block; width:100%; height:100%; left:0; top:0;}
</style>

			<script type="text/javascript">
                $(document).ready(function(){
                    $(document).find('.webPlayer').each(function() { $('#'+this.id).videoPlayer(); });
                });
            </script>
      <title>绘听</title>
      <link rel="shortcut icon" href="<%=request.getContextPath() %>/images/title.jpg" type="/x-icon" />
</head>

<body>
<div class="content">
	<h2>绘听故事 | 《<%=name %>》 </h2>
	<hr />
	<span class="marginb">
  		<strong>绘听baby</strong> 
		<p>绘听，给您和您的孩子一种新的亲子方式，让陪伴，成为一种习惯。人生，用绘色启蒙！成长，从聆听开始！</p>
        
	</span>
	
	
	<section data-bcless="darken" style="margin: 10px auto; border: 1px solid rgb(242, 212, 155); text-align: center; border-radius: 5px; box-shadow: rgb(255, 255, 255) 0px 1px 0px, rgb(197, 200, 204) 0px 2px 0px, rgb(255, 255, 255) 0px 3px 0px, rgb(197, 200, 204) 0px 4px 0px; box-sizing: border-box; padding: 0px;">
        <section style="height: 25px; border-bottom-width: 0px; border-bottom-style: solid; border-color: rgb(242, 212, 155); border-radius: 4px 4px 0px 0px; color: rgb(255, 255, 255); box-sizing: border-box; padding: 0px; margin: 0px; background-color: rgb(252, 180, 43);">
	        <section data-width="14px" style="display: inline-block; height: 14px; width: 14px; border-radius: 7px; margin-right: 100px; color: inherit; box-sizing: border-box; padding: 0px; background-color: rgb(173, 173, 173);">
	             <section data-width="14px" style="margin-top: 30px; height: 14px; width: 14px; border-radius: 7px; color: inherit; box-sizing: border-box; padding: 0px; background-color: rgb(222, 222, 222);">
	             </section>
	             <section data-width="8px" style="margin-top: -37px; margin-left: 2px; width: 8px; height: 30px; border: 1px solid rgb(202, 202, 202); border-radius: 3px; color: inherit; box-sizing: border-box; padding: 0px; background-color: rgb(255, 255, 255);">
	             </section>
	        </section>
            <section data-width="14px" style="display: inline-block; height: 14px; width: 14px; border-radius: 7px; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px; background-color: rgb(173, 173, 173);">
	            <section data-width="14px" style="margin-top: 30px; height: 14px; width: 14px; border-radius: 7px; color: inherit; box-sizing: border-box; padding: 0px; background-color: rgb(222, 222, 222);">
	            </section>
	            <section data-width="8px" style="margin-top: -37px; margin-left: 2px; width: 8px; height: 30px; border: 1px solid rgb(202, 202, 202); border-radius: 3px; color: inherit; box-sizing: border-box; padding: 0px; background-color: rgb(255, 255, 255);">
	            </section>
            </section>
        </section>
        <section class="135brush" style="margin: 40px 10px; color: inherit; box-sizing: border-box; padding: 0px;">
            <section data-id="7170" class="135editor" style="border: 0px none; color: inherit; padding: 0px; box-sizing: border-box; margin: 0px;">
                <section data-width="auto" style="border: 0px; width: auto; clear: both; padding-right: 0.5em; padding-bottom: 0.5em; color: inherit; box-sizing: border-box; margin: 0px;">
                	<img src="<%=picurl %>" style="width:110%" />
                	<!--<img src="./../../model/images/11.jpg" style="width:110%" />
                	-->
                	<div  id="demoAudio1" >
						  <div id="uniquePlayer-41" class="webPlayer  light audioPlayer">
						   <div id="uniqueContainer-42" class="videoPlayer"></div>
						    <div style="display:none;" class="playerData"> {
						                  "name": "",
						                  "autoplay":"true",
						                  "size": {
						                  "width": "100%"},
						                  "backgroundColor":"#F0FFF0",
						                  "media": {
						                  "mp3": "<%=audiourl %>"
						                  }
						                  } </div>
						  </div>
					</div>
                </section>
            	<section style="width: 0px; height: 0px; clear: both; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
                </section>
            </section>
            <!--<p>小朋友们晚上好，今天的绘听ABC为大家讲的故事叫做《花婆婆》，其实花婆婆原来并不叫花婆婆，在花婆婆还是小女孩的时候，她的名字叫艾丽斯，那么为什么她又叫花婆婆呢？我们一起来进入今天的故事吧！</p>
            -->
            <p><%=content %></p>
            <p style="color: inherit;">
            <img src="<%=request.getContextPath() %>/images/caihong.jpg" data-ratio="0.0546448087431694" data-w="366" style="color: inherit;"  />
            <img src="<%=request.getContextPath() %>/images/bird.jpg" style="width:100%" />
            <br style="color: inherit;"  /></p>
            <p>
              
             </p>
        </section>
     </section>




</div>
</body>
</html>