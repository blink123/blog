package liujiawei.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import liujiawei.userdirmgr.UserDirMgr;

public class uploadPictureController {
	@RequestMapping(value="/uploadFile.do",method=RequestMethod.POST)
    public void uploadPictures(MultipartFile multipartFile){
		System.out.println("图片上传。。");
		System.out.println("原图地址"+multipartFile.getOriginalFilename());
		String userdir=UserDirMgr.getUserDir();
		try {
			multipartFile.transferTo(new File(userdir));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
