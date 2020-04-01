<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<head>
    <title>展示数据</title>
</head>
<div style="width: 600px; margin: auto; text-align: center">
    <table class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>hp</td>
            <td>damage</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="u" varStatus="st">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.hp}</td>
                <td>${u.damage}</td>
                <td><a href="/editUser?id=${u.id}">编辑</a></td>
                <td><a href="/deleteUser?id=${u.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <div>
        <a href="?start=1">首页</a>
        <a href="?start=${page.pageNum - 1}">上一页</a>
        <a href="?start=${page.pageNum + 1}">下一页</a>
        <a href="?start=${page.pages}">尾页</a>
    </div>
    <br/>
    <form action="/addUser" method="post" onsubmit="return checkPost()">
        <div class="form-group">
            <input type="text" class="form-control" id="name" name="name" placeholder="name">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="hp" name="hp" placeholder="hp">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="damage" name="damage" placeholder="damage">
        </div>
        <input type="submit" class="btn btn-primary" value="提交">
    </form>
</div>
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