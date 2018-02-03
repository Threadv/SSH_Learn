package cn.llanc.HolleWord;

public class Product
{
	String fname;
	String fage;
	String fsex;
	public String getFname()
	{
		return fname;
	}
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	public String getFage()
	{
		return fage;
	}
	public void setFage(String fage)
	{
		this.fage = fage;
	}
	public String getFsex()
	{
		return fsex;
	}
	public void setFsex(String fsex)
	{
		this.fsex = fsex;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Product [fname=" + fname + ", fage=" + fage + ", fsex=" + fsex + ", getFname()=" + getFname()
				+ ", getFage()=" + getFage() + ", getFsex()=" + getFsex() +"]";
	}
	
	public String save() {
		System.out.println("Save"+this);
		return "details";
	}
	
	
}
