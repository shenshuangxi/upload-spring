package com.sundy.upload.spring.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Properties;

import com.sundy.upload.spring.contant.ContantConfig;


public class FileUtil {

	private static Properties props = new Properties();
	private static String md5FileProperties = getBase()+ContantConfig.fileSeparator+ContantConfig.md5File;
	static {
		try {
			File file = new File(md5FileProperties);
			if(!file.exists()){
				file.createNewFile();
			}
			InputStream is = new FileInputStream(file);
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void makeDir(String filePath){
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	public static Boolean exist(String filePath){
		File file = new File(filePath);
		if(!file.exists()){
			return false;
		}
		return true;
	}
	
	public static String getBase(){
		String base = ContantConfig.instance.storePath;
//		String separator = ContantConfig.fileSeparator;
//		if(separator.equals("/")){
//			base = ContantConfig.linuxDirPath;
//		}
		return base;
	}
	
	public static String getProperty(String md5){
		return props.getProperty(md5);
	}
	
	public static void addProperty(String md5,String fileName){
		String existMd5File = getProperty(md5);
		if(existMd5File!=null){
			existMd5File = existMd5File + " , " + fileName;
		}else{
			existMd5File = fileName;
		}
		props.setProperty(md5, existMd5File);
		try {
			props.store(new FileOutputStream(new File(md5FileProperties)), "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getFileMd5(String filePath) throws Exception{
		File file = new File(filePath);
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		ByteBuffer buf = ByteBuffer.allocate(1024*10);
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		try {
			while(raf.getChannel().read(buf)>0){
				buf.flip();
				md5.update(buf);
				buf.rewind();
			}
		} finally{
			raf.close();
		}
//		
//		FileInputStream fis = new FileInputStream(file);
//		byte[] bufs = new byte[1024*10];
//		int len = 0;
//		while((len=fis.read(bufs))>0){
//			md5.update(bufs, 0, len);
//		}
//		fis.close();
		
		String md5Str = MD5Util.byteHEX(md5.digest());
		return md5Str;
	}
	
	
	public static void main(String[] args) throws Exception{
		String filepath = getBase()+ContantConfig.fileSeparator+"AxonFramework.rar";
		System.out.println(getFileMd5(filepath));
		
//		GioneePasswordEncoder encoder = new GioneePasswordEncoder();
//		File file = new File(filepath);
//		ByteBuffer buf = ByteBuffer.allocate(16);
//		RandomAccessFile raf = new RandomAccessFile(file, "r");
//		try {
//			while(raf.getChannel().read(buf)>0){
//				buf.flip();
//				byte[] bytes = buf.array();
//				encoder.md5Update(bytes,bytes.length);
//				buf.rewind();
//			}
//		} finally{
//			raf.close();
//		}
//		String md5Str = encoder.getMD5();
//		System.out.println(md5Str);
		
		
//		System.out.println("175432a52eaf7ba67b288ef6148a2a08");
//		System.out.println("04427f4c324476f347fcf9e26fb3f8fd");
		System.out.println("6767d6144ddd0879cce99414da3a29a4");
	}
	
}
