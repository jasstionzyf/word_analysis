<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>敏感词配置 | 应用管理 | 应用信息</title>
        <link href="/css/main.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="/js/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
        <script type="text/javascript" src="http://static2.baihe.com/js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="/js/baihe_spms.js"></script>
        <script type="text/javascript" src="/js/DatePicker/WdatePicker.js"></script>
        <script type="text/javascript" src="/js/fancybox/jquery.fancybox-1.3.4.js"></script>

        <script src="http://static4.baihe.com/3rd-lib/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>



    </head>
    <body>
        <div class="baihe_main">
            <h1>${message}</h1>

            <form id="actionForm" action ="/inner/analysis/addTerms.action" method="post" >
                <table>
                    <tr>
                        <th><span class="input_must">*</span>词典类型:</th>
                        <td class="input_text">
                            <select class="input_text" name="type">
                                <option value="1">消息</option>
                                <option value="2">昵称</option>
                                <option value="3">自我介绍</option>
                            </select>

                        </td> 
                    </tr>
                    <tr>
                        <th><span class="input_must">*</span>词典内容（词之间以英文逗号隔开）::</th>
                        <td> <textarea   rows="5" cols="5" style="width: 300px"  name="terms"></textarea></td>
                    </tr>




                </table>
                <br/>
                <input type="submit" value="提交" />
            </form>


            <br/>

            <div class="btnCont"><a href="/inner/analysis/reloadDictionary.json">重新加载词库</a></div>
        </div>
    </body>
</html>
