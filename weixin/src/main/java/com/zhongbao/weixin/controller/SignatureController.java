package com.zhongbao.weixin.controller;

import com.zhongbao.weixin.utils.CheckUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class SignatureController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SignatureController.class);

    @RequestMapping(value = "/weixin",method = RequestMethod.GET)
    public void signatureConfirm(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter writer = response.getWriter();

        if(CheckUtils.checkSignature(signature,timestamp,nonce)){
            writer.print(echostr);
        }
    }
}
