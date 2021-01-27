package com.ylf.spring.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

/**
 * @author Administrator
 * @version 1.0
 * @date 2021/1/26 12:25
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value="/axiosFile",method=RequestMethod.POST)
    @ResponseBody
    public void axiosFile(HttpServletRequest request,
                          HttpServletResponse response,
                          Map<String,Object> map,
                          @RequestParam(value="file",required=false) MultipartFile uploadFile){
        /*创建新文件名   一个原则 新文件名不能重复*/
        String newFileName=UUID.randomUUID().toString().replaceAll("-", "")+uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        /*设置 新文件的上传路径*/
        /*	String newFilePath=request.getSession().getServletContext().getRealPath("/upload/")+newFileName;*/
        /*注意上传文件位置区别 建议上传至文件源码位置  不要上传tomcat部署位置*/
        String str=request.getSession().getServletContext()
                .getRealPath("/upload/");
        String newFilePath = str.substring(0,str.indexOf("target"))+"src\\main\\webapp\\upload\\" + newFileName;
        String newFilePath1=request.getSession().getServletContext()
                .getRealPath("/upload/")+newFileName;
        System.out.println(newFilePath);
        /*新文件 对象实例化*/
        File newFile=new File(newFilePath);
        File newFile1=new File(newFilePath1);
        /*利用Spring框架的复制文件方法  将原文件字符内容 复制给新的 实例化文件对象*/
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=null;
        JSONObject json=new JSONObject();
        try {
            out=response.getWriter();
            uploadFile.transferTo(newFile);
            uploadFile.transferTo(newFile1);
            System.out.println("上传文件成功！");
            json.put("msg", "上传文件成功！");
            json.put("newFilePath", "/upload/"+newFileName);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            json.put("msg","上传文件失败！！");
        }finally{
            if(out!=null){
                out.print(json.toJSONString());
                out.flush();
                out.close();
            }

        }
        /*注意同步跳转  与异步交互 回调数据的区别
         * 同步跳转  由request带参传值
         * 异步交互  返回json格式数据*/
        /*return new ModelAndView("success");*/
    }
}
