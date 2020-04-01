<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/4
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
<head>
    <title>编辑数据</title>
</head>
<body>
    <div style="width: 300px; margin: auto">
        <form action="/updateUser" method="post" onsubmit="return checkPost()">
            <div class="form-group">
                <input type="text" class="form-control" name="name" value="${user.name}">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="hp" value="${user.hp}">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="damage" value="${user.damage}">
            </div>
            <input type="hidden" name="id" value="${user.id}">
            <input type="submit" class="btn btn-primary" value="提交"></input>
        </form>
    </div>
</body>
<script>
    function checkPost() {
        if($("#name").val() == ""){
            alert("名字不能为空");
            $("#name").focus();
            return false;
        }
        if($("#hp").val() == ""){
            alert("血量不能为空");
            $("#hp").focus();
            return false;
        }
        if($("#damage").val() == ""){
            alert("伤害不能为空");
            $("#damage").focus();
            return false;
        }
        return true;
    }
</script>
</html>
