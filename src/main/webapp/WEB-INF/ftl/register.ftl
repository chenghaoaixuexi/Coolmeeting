<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
    <#include 'common/top.ftl'>
        <div class="page-body">
            <#include 'common/leftMenu.ftl'>

            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 员工注册
                </div>
                <form action="/doreg" method="post ">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%" >

                            <tr>
                                <td>姓名：</td>
                                <td><#--value属性为注册失败。回填历史数据设置-->
                                    <input name="employeename" type="text" id="employeename" maxlength="20" value="${emp.getEmployeename()}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input  name="username" type="text" id="accountname" maxlength="20" ${emp.getUsername()}/>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input  name="password" type="password" id="password" maxlength="20" placeholder="请输入6位以上的密码" value="${emp.getPassword()}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input  name= "conmfirm" type="password" id="confirm" maxlength="20" onchange="check()"/>
                                    <div id="confirmInfo" style="color: red"></div>
                                </td>

                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input  name="phone" type="text" id="phone" maxlength="20" value="${emp.getPhone()}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input name="email" type="text" id="email" maxlength="20" value="${emp.getEmail()}"/>
                                </td>
                            </tr>
							<td>所在部门：</td>
                                <td>
                                    <select name="departmentid">

                                        <#--在数据库中查询所有部门，此处进行便利-->
                                        <#if deps??>
                                        <#list deps as dept>
                                     	<option value="${dept.departmentid}">${dept.departmentname}</option>
                                        </#list>
                                        </#if>

                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="注册"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>

<#--检验两次输入密码是否一致-->
<script type="text/javascript">
        function check() {
        var password = document.getElementById('password')
        var confirm = document.getElementById('confirm')
        var confirmInfo = document.getElementById('confirmInfo')
        if (password.value != confirm.value) {
        confirmInfo.innerHTML = '两次输入密码不一致'
    } else {
        confirmInfo.innerHTML = '密码一致'
    }
    }

</script>