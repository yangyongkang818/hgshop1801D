package com.yyk.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@PropertySource("classpath:hgshop.properties")
@Component
public class HgFileUtils {
	
	// 上传的根路径
	@Value("${pic.savepath}")
	private String uploadPath;
	
	//路径的分割符号
	private String pathSpit="/";
	
	
	public String upload(MultipartFile file) {
		
		//获取当前的时间，根据时间计算存放的路径
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String subPath = sdf.format(new Date());
		
		//要存放的文件的路径
		File filePath = new File(uploadPath+pathSpit+subPath);
		//判断该路径是否存在，如果不存在则创建
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		
		
		//获取原始文件名
		String oldName = file.getOriginalFilename();
		//生成新的随机文件名		
		String newFileName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
		
		//新文件的绝对路径
		File dstFile = new File(uploadPath+pathSpit+subPath+pathSpit+newFileName);
		
		try {
			file.transferTo(dstFile);
			return subPath+pathSpit+newFileName;
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}

}
