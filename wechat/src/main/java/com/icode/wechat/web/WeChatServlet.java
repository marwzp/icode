
package com.icode.wechat.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icode.framework.utils.CheckUtil;
import com.icode.wechat.service.CoreService;
import com.icode.wechat.service.impl.CoreServiceImpl;

/**
 * Servlet implementation class WeChatServlet
 */
public class WeChatServlet extends HttpServlet {

	private static final long serialVersionUID = -7546569100136797302L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();

		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}

		out.close();
		out = null;

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 消息的接收、处理、响应
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		//创建核心业务对象
		CoreService coreService = new CoreServiceImpl();
		String respXml = coreService.processRequest(request);

		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respXml);
		out.close();
	}

}
