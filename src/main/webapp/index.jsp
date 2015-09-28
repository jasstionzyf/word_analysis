<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
            <div class="btnCont"><a href="/inner/analysis/reloadDictionary.json">重新加载词库</a></div>
            <br> 过滤例子：{"text":"赵宇飞升机一起海陆空军轰炸机毛泽东去吃饭高级餐厅一起去工作吧顺便大篮球","textType":"1"}</br>
            <br>查询例子：{"text":"接触","textType":"3"}</br>
            <br>删除例子：{"text":"赵宇飞","textType":"3"}</br>
            <br/>
                <ul>
                    <li>1表示消息</li>
                    <li>2表示昵称</li>
                    <li>3表示自我介绍</li>
                    
                    
                </ul>
            


            <h5>你可以安装一个浏览器插件，这样的话返回的json内容的显示就会被格式化，会更容易去看，对于chrome，插件为:JSONView</h5>
            <br/>

            <br/>
            <br/>

            <br/>
            <H1>API Test</H1>
            <form id="api1" action="/inner/analysis/checkTextIsValid.json" method="post">
                <table>
                    <tr>
                        <td>接口:</td>
                        <td>
                            <select id="action" name="action" style="width: 300px; height: 30px;">
                                <option value="/inner/analysis/checkTextIsValid.json">敏感词过滤：/inner/analysis/checkTextIsValid.json</option>


                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>traceID:</td>
                        <td><input type="text" style="width: 300px; height: 25px;" name="traceID" /> </td>
                    </tr>
                    <tr>
                        <td>systemID:</td>
                        <td><input type="text" style="width: 300px; height: 25px;" name="systemID" /> </td>
                    </tr>
                    <tr>
                        <td>params:</td>
                        <td><textarea rows="5" cols="5" name="params" style="width: 300px"></textarea></td>
                    </tr>
                    <tr>
                        <td>调用窗口打开方式:</td>
                        <td>
                            <label><input type="radio" name="target" value="_blank" checked="checked"/>新窗口</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input type="radio" name="target" value="_self"/>本窗口</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
                <br/>
                <input id="call" type="submit" value="过滤"/><br/>


            </form>
            <form id="api2" action="/inner/analysis/queryTerms.json" method="post">
                <table>
                    <tr>
                        <td>接口:</td>
                        <td>
                            <select id="action" name="action" style="width: 300px; height: 30px;">
                                <option value="/inner/analysis/queryTerms.json">敏感词模糊查询：/inner/analysis/queryTerms.json</option>


                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>traceID:</td>
                        <td><input type="text" style="width: 300px; height: 25px;" name="traceID" /> </td>
                    </tr>
                    <tr>
                        <td>systemID:</td>
                        <td><input type="text" style="width: 300px; height: 25px;" name="systemID" /> </td>
                    </tr>
                    <tr>
                        <td>params:</td>
                        <td><textarea rows="5" cols="5" name="params" style="width: 300px"></textarea></td>
                    </tr>
                    <tr>
                        <td>调用窗口打开方式:</td>
                        <td>
                            <label><input type="radio" name="target" value="_blank" checked="checked"/>新窗口</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input type="radio" name="target" value="_self"/>本窗口</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
                <br/>
                <input id="call" type="submit" value="查询"/><br/>


            </form>
            <form id="api3" action="/inner/analysis/removeTerms.json" method="post">
                <table>
                    <tr>
                        <td>接口:</td>
                        <td>
                            <select id="action" name="action" style="width: 300px; height: 30px;">
                                <option value="/inner/analysis/removeTerms.json">敏感词删除：/inner/analysis/removeTerms.json</option>


                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>traceID:</td>
                        <td><input type="text" style="width: 300px; height: 25px;" name="traceID" /> </td>
                    </tr>
                    <tr>
                        <td>systemID:</td>
                        <td><input type="text" style="width: 300px; height: 25px;" name="systemID" /> </td>
                    </tr>
                    <tr>
                        <td>params:</td>
                        <td><textarea rows="5" cols="5" name="params" style="width: 300px"></textarea></td>
                    </tr>
                    <tr>
                        <td>调用窗口打开方式:</td>
                        <td>
                            <label><input type="radio" name="target" value="_blank" checked="checked"/>新窗口</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <label><input type="radio" name="target" value="_self"/>本窗口</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
                <br/>
                <input id="call" type="submit" value="删除"/><br/>
            </form>
            <br/>
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
                <input type="submit" value="新增" />
            </form>

            <br/>





        </div>
    </body>
</html>



