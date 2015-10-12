<%-- 
    Document   : index
    Created on : Sep 29, 2015, 6:13:02 PM
    Author     : jasstion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" class="ui" href="/resources/dist/semantic.css">
        <script src="/resources/js/jquery.min.js"></script>
        <script src="/resources/dist/semantic.js"></script>
        <title>敏感词管理后台</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">




            var cpn = 1;
            var pageSize = 20;
            var pageCount = 0;
            var textType = '';
            function popupAdd() {
                $('.ui.form.basic.test.modal').modal({
                    blurring: true,
                    closable: false
                }).modal('show');
            }

            function hidAdd() {
                $('.ui.form.basic.test.modal')
                        .modal('hide')
                        ;
            }
            function search() {
                textType = $('#query_textType').val();
                //  alert(textType);
                text = $('#query_text').val();
                //  alert(text);
                paramsObj = new Object();
                paramsObj.textType = textType;
                paramsObj.text = text;
                paramsObj.pageSize = pageSize;
                paramsObj.pageNum = 1;
                paramsStr = JSON.stringify(paramsObj);
                //  alert(paramsStr);
                $.ajax({
                    url: "http://analysis.baihe.com/inner/analysis/queryTerms.json",
                    dataType: "json",
                    type: "GET",
                    data: "params=" + paramsStr,
                    success: function (data) {
                        processSearchResult(data);
                    }
                });


            }





            function processSearchResult(result) {
                $('#terms_trs').empty();
                code = result.code;
                if (code == 200) {
                    //alert("succeed!");
                    cpn = result.data.cpn;
                    // alert(cpn);
                    pageCount = result.data.pageCount;
//                    pageSize = result.data.pageSize;
                    terms = result.data.result;

                    for (index = 0; index < terms.length; index++) {
                        text = terms[index];
                        content = "<tr><td > " +
                                text.text +
                                "</td>" +
                                "<td > " +
                                $('#query_textType option:selected').text() +
                                "</td>"+
                                "<td> <div class = 'ui checked checkbox'>" +
                                "<input class='deleteCheck' type = 'checkbox' termid='" + text.id + "'/> <label> </label>" +
                                "</td>" +
                                "</tr>";
                        $('#terms_trs').append(content);
                    }
                }
                else {
                    alert("call error!");
                }


            }






            function previousPage() {

                textType = $('#query_textType').val();
                //  alert(textType);
                text = $('#query_text').val();
                //  alert(text);
                paramsObj = new Object();
                paramsObj.textType = textType;
                paramsObj.text = text;
                paramsObj.pageSize = pageSize;
                previousPageNum = 1;
                if (cpn > 1) {
                    previousPageNum = cpn - 1;

                }
                else {
                    previousPageNum = 1;
                    alert("已经是第一页！");
                }
                paramsObj.pageNum = previousPageNum;
                paramsStr = JSON.stringify(paramsObj);
                //  alert(paramsStr);
                $.ajax({
                    url: "http://analysis.baihe.com/inner/analysis/queryTerms.json",
                    dataType: "json",
                    type: "GET",
                    data: "params=" + paramsStr,
                    success: function (data) {
                        processSearchResult(data);
                    }



                });


            }
            function lastPage() {

                textType = $('#query_textType').val();
                //  alert(textType);
                text = $('#query_text').val();
                //  alert(text);
                paramsObj = new Object();
                paramsObj.textType = textType;
                paramsObj.text = text;
                paramsObj.pageSize = pageSize;
                lastPageNum = 0;
                if (cpn <= pageCount - 1) {
                    lastPageNum = cpn + 1;
                }
                else {
                    lastPageNum = pageCount;
                    alert("已经是最后一页！");
                }
                paramsObj.pageNum = lastPageNum;
                paramsStr = JSON.stringify(paramsObj);
                // alert(paramsStr);
                $.ajax({
                    url: "http://analysis.baihe.com/inner/analysis/queryTerms.json",
                    dataType: "json",
                    type: "GET",
                    data: "params=" + paramsStr,
                    success: function (data) {
                        processSearchResult(data);
                    }
                });

            }

            function deleteAll() {

                ids_ = '';
                $(".deleteCheck").each(function () {
                    if ($(this).is(':checked')) {
                        ids_ += $(this).attr('termid') + ",";

                    }




                });
                paramsObj = new Object();
                paramsObj.textType = textType;
                paramsObj.ids = ids_;
                paramsStr = JSON.stringify(paramsObj);
                $.ajax({
                    url: "http://analysis.baihe.com/inner/analysis/removeTerms.json",
                    dataType: "json",
                    type: "GET",
                    data: "params=" + paramsStr,
                    success: function (data) {
                        alert("删除成功!");
                        search();
                    }
                });
            }




            function save() {

                $.ajax({
                    url: "http://analysis.baihe.com/inner/analysis/addTerms.json",
                    dataType: "json",
                    type: "POST",
                    data: $('#save_form').serialize(),
                    success: function (data) {
                        alert('ok');
                        return false;
                    }

                });


                return false;



            }

        </script>



    </head>
    <body>
<h1 class="ui header centered blue">百合敏感词管理</h1>

        <div class="ui input">
            <input type="text" placeholder="Search..." id="query_text">
        </div>


        <select class="ui dropdown" id="query_textType">
            <option value="1">消息</option>
            <option value="2">昵称</option>
            <option value="3">自我介绍</option>
        </select>
        <button class="ui primary button" onclick="javascript:search();">搜索</button>
        <button class="ui primary button" onclick="javascript:popupAdd();">新增敏感词</button>

        <table class="ui single small compact line table red">
            <thead>
                <tr><th>敏感词</th>
                    <th>类型</th>
                    <th>删除</th>

                </tr></thead>
            <tbody id="terms_trs">




            </tbody>
            <tfoot>

                <tr>

                    <th colspan="3">
                        <button class="ui primary button"  onclick="javascript:deleteAll();">全部删除</button> 
            <div class="ui right floated pagination menu">
                <button class="ui  button"  onclick="javascript:previousPage();" >上一页</button>
                <button class="ui button"  onclick="javascript:lastPage();">下一页</button>


            </div>
        </th>
    </tr></tfoot>
</table>



<form class="ui form basic test modal" id="save_form">
    <div class="field">
        <label>增加敏感词</label>
        <input type="text" id="save_text" name="terms" placeholder="请输入敏感词">
    </div>
    <div class="field">
        <select id='save_text_type' name="type">
            <option value="1">消息</option>
            <option value="2">昵称</option>
            <option value="3">自我介绍</option>
        </select>
    </div>


    <button  class="ui button" type="submit" onclick="javascript:save();"    >保存</button>
    <button class="ui button" type="button" onclick="javascript:hidAdd();">返回</button>
</form>

</body>
</html>
