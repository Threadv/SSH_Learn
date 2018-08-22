package cn.llanc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ServletContextSingleton;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	上传多个文件使用List<T>
	private File fileTest;
	private String fileTestContentType;
	private String fileTestFileName;
	
	
	public File getFileTest() {
		return fileTest;
	}


	public void setFileTest(File fileTest) {
		this.fileTest = fileTest;
	}


	public String getFileTestContentType() {
		return fileTestContentType;
	}


	public void setFileTestContentType(String fileTestContentType) {
		this.fileTestContentType = fileTestContentType;
	}


	public String getFileTestFileName() {
		return fileTestFileName;
	}


	public void setFileTestFileName(String fileTestFileName) {
		this.fileTestFileName = fileTestFileName;
	}
	
	
	public String execute() throws Exception{
		System.out.println(fileTest);
		System.out.println(fileTestContentType);
		System.out.println(fileTestFileName);
		ServletContext servletContext=ServletActionContext.getServletContext();
		String dir=servletContext.getRealPath("/files/"+fileTestFileName);
		System.out.println(dir);
		
		FileOutputStream out=new FileOutputStream(dir);
		FileInputStream in=new FileInputStream(fileTest);
		
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=in.read(buffer))!=-1) {
			out.write(buffer,0,len);
		}
		out.close();
		in.close();
		
		return SUCCESS;
	}
}
