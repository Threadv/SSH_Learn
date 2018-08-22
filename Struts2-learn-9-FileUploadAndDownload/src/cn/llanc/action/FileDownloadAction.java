package cn.llanc.action;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;
	
	
	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public long getContentLength() {
		return contentLength;
	}


	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}


	public String getContentDisposition() {
		return contentDisposition;
	}


	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		contentType="text";
		contentDisposition="attachment;filename=新建文本文档.txt";
		ServletContext servletContext=ServletActionContext.getServletContext();
		String fileName=servletContext.getRealPath("/files/新建文本文档.txt");
		System.out.println(fileName);
		inputStream=new FileInputStream(fileName);
		contentLength=inputStream.available();
		return SUCCESS;
	}
	
	
}
