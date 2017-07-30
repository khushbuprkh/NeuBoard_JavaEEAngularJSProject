<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script>
 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveDepartment() {
            //alert("hello1");

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var Depname = document.getElementById("name").value;
            var Depdesc = document.getElementById("desc").value;
    

            var query = "action=register&name=" + Depname + "&desc=" + Depdesc

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    //alert(xmlHttp.responseText);
                    var json = JSON.parse(xmlHttp.responseText);
                    document.getElementById("success").innerHTML = json.successmsg;
                }
            };
            xmlHttp.open("POST", "addDepartment.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            return false;
        }
        
        function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
</script>

<section ng-controller="department">
	<h1>Add Department</h1>
<div class="col-sm-4">
<span id="success"></span>
<form:form role="form" commandName="department" onsubmit="return saveDepartment();" id="myForm">
<div class="form-group">
  <label for="name">Department Name:</label>
  <form:input type="text" path="departmentName" class="form-control" name="name" id="name"/>
</div>

<%-- <div class="form-group">
  <label for="sel1">Level:</label>
  <form:select path="levelList" class="form-control" id="sel1" >
    <option>Graduate</option>
    <option>Undergraduate</option>
  </form:select>
</div> --%>

<div class="form-group">
  <label for="desc">Description:</label>
  <form:textarea path="departmentDesc" class="form-control" rows="4" name="desc" id="desc"/>
</div>
<form:button type="submit" class="btn btn-default btn-success">Submit</form:button>
</form:form>
</div>
</section>
