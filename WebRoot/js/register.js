

			/*加载完毕取焦点*/
		    function load(){
		       document.getElementById("id").focus();
		    }
		    /*失去焦点检查数据*/
			function check(obj,length){
	           obj.style.border="1px #000000 solid";
	           if(obj.value.length==0||obj.value==""){
	             if(obj.id=="id"){
	                var message= document.getElementById("idmessage");
	                message.innerHTML="<font color='red' size='-1'>密码不能为空</font>";
	                return false;
	             }else if(obj.id=="name"){
	                var message= document.getElementById("namemessage");
	                message.innerHTML="<font color='red' size='-1'>名字不能为空</font>";
	                return false;
	             }else if(obj.id=="password"){
	                var message= document.getElementById("passwordmessage");
	                message.innerHTML="<font color='red' size='-1'>密码不能为空</font>";
	                return false;
	             }
	           }
	           else if(obj.value.length<length){
	             if(obj.id=="id"){
	                var message= document.getElementById("idmessage");
	                message.innerHTML="<font color='red' size='-1'>密码必须为"+length+"位</font>";
	                return false;
	             }else if(obj.id=="name"){
	                var message= document.getElementById("namemessage");
	                message.innerHTML="";
	                return true;
	             }else if(obj.id=="password"){
	                var message= document.getElementById("passwordmessage");
	                message.innerHTML="<font color='red' size='-1'>密码必须为"+length+"位</font>";
	                return false;
	             }
	           }else{
	             if(obj.id=="id"){
	                var message= document.getElementById("idmessage");
	                message.innerHTML="";
	                return true;
	             }else if(obj.id=="name"){
	                var message= document.getElementById("namemessage");
	                message.innerHTML="";
	                return true;
	             }else if(obj.id=="password"){
	                var message= document.getElementById("passwordmessage");
	                message.innerHTML="";
	                return true;
	             }
	           }
	        }
	        /*检查注册密码是否匹配*/
	        function repwdcheck(repwd){
	           repwd.style.border="1px #000000 solid";
	           var message= document.getElementById("repasswordmessage");
	           var pwd= document.getElementById("password");
	           if(repwd.value!=pwd.value){
	               message.innerHTML="<font color='red' size='-1'>密码不匹配</font>";
	               return false;	               
	           }else{
	               message.innerHTML="";
	               return true;
	           }	           
	        }
	        /*按键放开时，检查是否可以后移焦点*/
	        function movefocus(qwe){	
			   if(qwe.value.length==8){
			      if(qwe.id=="id"){
			          document.getElementById("name").focus();
			      }else if(qwe.id=="password"){
			          document.getElementById("repassword").focus();
			      }
			   }else if(qwe.value.length==20){
			      if(qwe.id=="name"){
			          document.getElementById("password").focus();
			      }			   
			   }	
			}
            /*获得焦点时，改变边框颜色*/
	        function change(qwe){
			   qwe.style.border="1px red solid";     
			}
	        function validateForm(){
	        	//返回Ture form表单数据才提交
	        	//返回False 数据不会提交
	           if(window.confirm("确定填写无误")){
	              var name=document.getElementById("username");
	              var password=document.getElementById("password");
	              var repassword=document.getElementById("repassword");	              
		          if(check(name,20)&&check(password,8)&&repwdcheck(repassword,8)){
		              return true;
		          }else{
		              alert("输入有误，请仔细核实下数据！");
		              return false;
		          }		          
		       }else{
		          return false;
		       } 
	        }
	       