package cn.llanc.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter{
	
	private DateFormat dateFormat;
	public DateConverter() {
		if(dateFormat==null) {
			ServletContext servletContext=ServletActionContext.getServletContext();
			String dateConvert=servletContext.getInitParameter("dateConvert");
			dateFormat=new SimpleDateFormat("dateConvert");			
		}
	}
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		
		if(arg2==Date.class) {
			if(arg1!=null&&arg1.length>0) {
				String values=arg1[0];
				try {
					return dateFormat.parseObject(values);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//转换失败返回arg1
		return arg1;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Date) {
			Date date=(Date)arg1;
			return dateFormat.format(date);
		}
		//转换失败
		return null;
	}

}
