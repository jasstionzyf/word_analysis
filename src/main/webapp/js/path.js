	/** js获取项目路径 */
	function getContextPath() {
	    var pathName = document.location.pathname;
	    var index = pathName.substr(1).indexOf("/");
	    var result = pathName.substr(0,index+1);
	   // var result ="";//如JS在扔到服务器上获取项目路径错误,将此文件这里要打开..上边三行要注释掉
	 	return result;
	 }
