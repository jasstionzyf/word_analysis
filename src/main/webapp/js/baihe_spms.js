/**
 * 初始化列表
 */
function initTable() {
    //隔行变色
    $('table tr:nth-child(even)').addClass('bg');
    //鼠标划过
    $('table tr:gt(0)').hover(function(){
        $(this).addClass('moveBg');
    }, function(){
        $(this).removeClass('moveBg');
    });
    //单击
    $('table tr:gt(0)').click(function(){
        $(this).toggleClass('clickBg', '');
    });

    var selectAll = $('#selectAll');
    selectAll.click(function(){
        if (selectAll.attr('checked') == true) {
            $('.selectItem').each(function(){  //全选
                $(this).attr('checked','true');
            });
        } else {
            $('.selectItem').each(function(){  //反选
                $(this).removeAttr('checked');
            });
        }
    });
    //列表项有未选中项时取消全选
    $('.selectItem').each(function(){
        $(this).click(function(){
            if ($(this).attr('checked') != true) {
                if (selectAll.attr('checked') == true) {
                    selectAll.removeAttr('checked');
                }
            }
        });

    });
}

/**
 * 添加数据
 * formID  表单ID
 * actionURL 表单action地址
 */
function addData(formID, actionURL) {
	$('#' + formID + '').attr('action', actionURL).submit();
}

/**
 * 查看数据
 * formID  表单ID
 * actionURL 表单action地址
 */
function viewData(formID, actionURL) {
    var selectNum = $('.selectItem:checked').size();
    if (selectNum == 0) {
        alert('请选择 1 条数据进行查看！');
    } else if (selectNum > 1) {
        alert('你选中了 ' + selectNum + ' 条数据，每次只能查看 1 条数据，请只选择 1 条数据进行查看！');
    } else {
        $('#' + formID + '').attr('action', actionURL).submit();
    }
}

/**
 * 修改数据
 * formID  表单ID
 * actionURL 表单action地址
 */
function updateData(formID, actionURL) {
    var selectNum = $('.selectItem:checked').size();
    if (selectNum == 0) {
        alert('请选择 1 条数据进行更改！');
    } else if (selectNum > 1) {
        alert('你选中了 ' + selectNum + ' 条数据，每次只能更改 1 条数据，请只选择 1 条数据进行更改！');
    } else {
        $('#' + formID + '').attr('action', actionURL).submit();
    }
}

/**
 * 删除数据
 * formID  表单ID
 * actionURL 表单action地址
 */
function deleteData(formID, actionURL) {
    var selectNum = $('.selectItem:checked').size();
    if (selectNum == 0 ) {
        alert('请选择 1 条数据进行删除！');
    } else {
        if (confirm('确定要删除 ' + selectNum + ' 条数据吗？删除不可恢复！')) {
            $('#' + formID + '').attr('action', actionURL).submit();
        }
    }
}

/**
 * 翻页
 * @param flag
 * @param actionURL
 */
function page(flag, actionURL){
	if ( flag=='1' ) { // 首页
		$('#curPage').val(1);
	} else if ( flag=='2' ) { //上一页
		 var cur = $('#curPage').val();
		 $('#curPage').val(parseInt(cur)-1);
	} else if ( flag=='3' ) { //下一页
		 var cur = $('#curPage').val();
	 $('#curPage').val(parseInt(cur)+1);
	} else if ( flag=='4' ) { //尾页
		var cur = $('#totalPage').val();
		$('#curPage').val(cur);
	}
	$('#pageForm').attr('action', actionURL).submit();
}

/**
 * 队列消息操作
 * @param ID
 * @param actionURL
 */
function operQueue(ID, actionURL) {
	var operAction = actionURL + "?IDs=" + ID;
  	$('#operForm').attr('action', operAction).submit();
}

/**
 * 查询操作
 * @param actionURL
 */
function query(actionURL) {
	
	if ($.trim($('#userID').val()) == '') {
        alert('会员ID不能为空');
        return false;
    }
	if ($('#userID').val().length>10) {
		alert('会员ID超长');
		return false;
	}
	$('#queryForm').attr('action', actionURL).submit();
}

/**
 * 下载文件
 * formID  表单ID
 * actionURL 表单action地址
 */
function downloadFile(formID, actionURL) {
    var selectNum = $('.selectItem:checked').size();
    if (selectNum == 0 ) {
        alert('请选择要下载的文件！');
    } else if (selectNum > 1) {
    	alert('下载的文件不允许多选！');
    } else {
        if (confirm('确定要下载 ' + selectNum + ' 条文件吗？')) {
            $('#' + formID + '').attr('action', actionURL).submit();
        }
    }
}

/**
 * 返回列表
 */
function returnList(formID,actionURL) {

	$('#' + formID + '').attr('action', actionURL).submit();
}

function checkMobile(mobileValue){ 
	
    if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(mobileValue))){ 
    //    alert("不是完整的11位手机号或者正确的手机号前七位"); 
        return 0; 
    }
    
    return 1;
} 
