

			/*�������ȡ����*/
		    function load(){
		       document.getElementById("id").focus();
		    }
		    /*ʧȥ����������*/
			function check(obj,length){
	           obj.style.border="1px #000000 solid";
	           if(obj.value.length==0||obj.value==""){
	             if(obj.id=="id"){
	                var message= document.getElementById("idmessage");
	                message.innerHTML="<font color='red' size='-1'>���벻��Ϊ��</font>";
	                return false;
	             }else if(obj.id=="name"){
	                var message= document.getElementById("namemessage");
	                message.innerHTML="<font color='red' size='-1'>���ֲ���Ϊ��</font>";
	                return false;
	             }else if(obj.id=="password"){
	                var message= document.getElementById("passwordmessage");
	                message.innerHTML="<font color='red' size='-1'>���벻��Ϊ��</font>";
	                return false;
	             }
	           }
	           else if(obj.value.length<length){
	             if(obj.id=="id"){
	                var message= document.getElementById("idmessage");
	                message.innerHTML="<font color='red' size='-1'>�������Ϊ"+length+"λ</font>";
	                return false;
	             }else if(obj.id=="name"){
	                var message= document.getElementById("namemessage");
	                message.innerHTML="";
	                return true;
	             }else if(obj.id=="password"){
	                var message= document.getElementById("passwordmessage");
	                message.innerHTML="<font color='red' size='-1'>�������Ϊ"+length+"λ</font>";
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
	        /*���ע�������Ƿ�ƥ��*/
	        function repwdcheck(repwd){
	           repwd.style.border="1px #000000 solid";
	           var message= document.getElementById("repasswordmessage");
	           var pwd= document.getElementById("password");
	           if(repwd.value!=pwd.value){
	               message.innerHTML="<font color='red' size='-1'>���벻ƥ��</font>";
	               return false;	               
	           }else{
	               message.innerHTML="";
	               return true;
	           }	           
	        }
	        /*�����ſ�ʱ������Ƿ���Ժ��ƽ���*/
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
            /*��ý���ʱ���ı�߿���ɫ*/
	        function change(qwe){
			   qwe.style.border="1px red solid";     
			}
	        function validateForm(){
	        	//����Ture form�����ݲ��ύ
	        	//����False ���ݲ����ύ
	           if(window.confirm("ȷ����д����")){
	              var name=document.getElementById("username");
	              var password=document.getElementById("password");
	              var repassword=document.getElementById("repassword");	              
		          if(check(name,20)&&check(password,8)&&repwdcheck(repassword,8)){
		              return true;
		          }else{
		              alert("������������ϸ��ʵ�����ݣ�");
		              return false;
		          }		          
		       }else{
		          return false;
		       } 
	        }
	       