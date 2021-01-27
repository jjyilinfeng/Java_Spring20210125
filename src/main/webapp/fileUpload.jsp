<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <div id="app"> 
     <form action="" 
     enctype="multipart/form-data"  method="post"  id="uploadForm">
     
     <label>请选择文件：<br>
     <input  type="file" name="file"></label>
     <br>
    <label>请输入用户名：<input type="text" name="userName"></label> 
     <input type="button"  @click="uploadGet"  value="点击我提交！">
     </form>
     <img  :src="imgPath"  v-show="imgPath!=''">
    </div>
    
  </body>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script type="text/javascript" src="./assets/js/axios.min.js"></script>
   <script type="text/javascript">
   var app=new Vue({
      el:"#app",
      data:{
      imgPath:'',
      
      },methods:{
      uploadGet:function(){
        var formData=new FormData(document.getElementById("uploadForm"));
         console.log(formData);
         axios.post('/upload/axiosFile',formData).then(function(response){
         var data=response.data;
           console.log(data);
           setTimeout(function (){
               app.imgPath=data.newFilePath;
           },1000);

         });
      
      }
      }
   
   });
   
   </script>
</html>
