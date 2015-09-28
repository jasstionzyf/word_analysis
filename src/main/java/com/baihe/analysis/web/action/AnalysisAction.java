package com.baihe.analysis.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baihe.analysis.entity.Term;
import com.baihe.analysis.service.Constants;
import com.baihe.analysis.service.IWordsOperation;
import com.baihe.analysis.service.TermQuery;
import com.baihe.analysis.service.TermQueryInfo;
import com.baihe.analysis.service.TextAnalysis;
import com.baihe.analysis.service.impl.TextAnalysisImpl;
import com.baihe.analysis.service.impl.WordsOperation;
import com.baihe.analysis.zk.ZkOperation;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jasstion on 15/6/30.
 */
@Controller
@RequestMapping(value = "/inner/analysis")
public class AnalysisAction {

    private final static Logger LOGGER = LoggerFactory.getLogger(AnalysisAction.class);
    final static String reloadPath = "/dic";
    final static ZkOperation zkOp = null;

    @RequestMapping(value = "/checkTextIsValid")
    public void checkTextIsValid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int code = 200;
        String msg = "正常调用";
        Map data = Maps.newHashMap();
        String params = request.getParameter("params");
        TextAnalysis textProcess = new TextAnalysisImpl();

        try {
            if (params != null && !params.trim().isEmpty()) {
                Map<String, String> paraMap = JSON.parseObject(params, new TypeReference<Map<String, String>>() {
                });
                String text = paraMap.get("text");

                String textType = paraMap.get("textType");
                List<Term> dirtyWords = textProcess.extractDirtyWords(text);
                List<Term> finalTerms = Lists.newArrayList();
                String tmpTextType = null;
                for (Term dirtyWord : dirtyWords) {
                    tmpTextType = dirtyWord.getType().split("_")[1];
                    if (tmpTextType.contains(textType)) {
                        finalTerms.add(dirtyWord);
                    }
                }
                data.put("invalidWords", finalTerms);
                if (dirtyWords.size() == 0) {
                    data.put("isValid", true);
                } else {
                    data.put("isValid", false);

                }

            } else {
                code = -100;
                msg = "调用错误，请正确的传递参数.";
            }
        } catch (Exception e) {
            code = -100;
            msg = e.getMessage();
            LOGGER.info("调用文字合法性检测服务错误，具体异常信息是：" + msg + "");
        }
        printJsonTemplate(code, msg, data, request, response);

    }

    @RequestMapping(value = "/removeTerms")
    public void removeTerms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int code = 200;
        String msg = "正常调用";
        Map data = Maps.newHashMap();
        String params = request.getParameter("params");

        try {
            if (params != null && !params.trim().isEmpty()) {
                Map<String, String> paraMap = JSON.parseObject(params, new TypeReference<Map<String, String>>() {
                });
                String text = paraMap.get("text");
                //message:, nickname, selfintr

                String textType = paraMap.get("textType");
                Map<String, Object> queryMap = Maps.newHashMap();
                queryMap.put("text:=", text.trim());
                queryMap.put("type:=", textType.trim());
                Constants.mps.removeAll(queryMap, Term.class);

            } else {
                code = -100;
                msg = "调用错误，请正确的传递参数.";
            }
        } catch (Exception e) {
            code = -100;
            msg = e.getMessage();
            LOGGER.info("删除失败，具体异常信息是：" + msg + "");
        }
        printJsonTemplate(code, msg, data, request, response);

    }

    @RequestMapping(value = "/queryTerms")
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int code = 200;
        String msg = "正常调用";
        Map data = Maps.newHashMap();
        String params = request.getParameter("params");
        TextAnalysis textProcess = new TextAnalysisImpl();

        try {
            if (params != null && !params.trim().isEmpty()) {
                Map<String, String> paraMap = JSON.parseObject(params, new TypeReference<Map<String, String>>() {
                });
                String text = paraMap.get("text");

                String textType = paraMap.get("textType");
                String pageNum = paraMap.get("pageNum");
                String pageSize = paraMap.get("pageSize");

                TermQueryInfo termQueryInfo = new TermQueryInfo();
                termQueryInfo.setCount(Integer.parseInt(pageSize));
                termQueryInfo.setText(text);
                if (textType != null) {
                    textType = textType.trim();
                }
                termQueryInfo.setType(textType);
                termQueryInfo.setCpn(Integer.parseInt(pageNum));

                TermQuery termQuery = new TermQuery(termQueryInfo);
                termQuery.query();

                List<Term> terms = termQuery.getSearchResult();
                data.put("result", terms);
                data.put("cpn", termQuery.getQueryInfo().getCpn());
                data.put("pageSize", termQuery.getQueryInfo().getCount());
                data.put("pageCount", termQuery.getQueryInfo().getPageCount());
                data.put("totalCount", termQuery.getQueryInfo().getTotalcount());

            } else {
                code = -100;
                msg = "调用错误，请正确的传递参数.";
            }
        } catch (Exception e) {
            code = -100;
            msg = e.getMessage();
            LOGGER.info("查询terms异常，具体异常信息是：" + msg + "");
        }
        printJsonTemplate(code, msg, data, request, response);

    }

    @RequestMapping(value = "/reloadDictionary")
    public void reloadTerms(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int code = 200;
        String msg = "正常调用";
        Map data = Maps.newHashMap();
        String params = request.getParameter("params");
        try {
            if (true) {

                msg = "此接口暂时弃用，系统会自动重新加载词典";

            } else {
                code = -1;
                msg = "重载词典已经在运行，请稍后再执行！";
            }

        } catch (Exception e) {

            code = -100;
            msg = e.getMessage();
            LOGGER.info("重新加载词库出错，具体异常信息是：" + msg + "");
        } finally {
            zkOp.setData(reloadPath, "false".getBytes());

        }
        printJsonTemplate(code, msg, data, request, response);

    }

    private void printJsonTemplate(int code, String msg, Object data,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("traceID", request.getParameter("traceID"));
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", (data != null) ? data : new JSONObject());

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        out.flush();
        out.close();
    }
    private IWordsOperation wordsOperation = new WordsOperation();

    @RequestMapping(value = "/addTerms", method = RequestMethod.POST)
    public String addTerms(@RequestParam(value = "type", required = true) String corpusType, @RequestParam(value = "terms", required = true) String terms, Model model) {

        String message = null;
        if (corpusType == null || corpusType.trim().length() < 1 || terms == null || terms.trim().length() < 1) {
            message = "词典类型不能为空并且词不能为空!";
        } else {
            LOGGER.debug("新增类型:" + corpusType + "词典:" + terms + "");
            List<String> words = Lists.newArrayList(terms.split(","));
            for (String word : words) {
                Term term = new Term(corpusType, word);
                wordsOperation.addTerm(term);
            }

            message = "添加成功!";

        }
        model.addAttribute("message", message);
        return "addTerms";
    }

}
