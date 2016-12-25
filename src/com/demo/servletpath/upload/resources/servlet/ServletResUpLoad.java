package com.demo.servletpath.upload.resources.servlet;

import com.demo.servletpath.upload.resources.domain.Resource;
import com.demo.servletpath.upload.resources.service.ResourceService;
import com.demo.servletpath.upload.utils.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangTest on 2016/12/23.
 */
@WebServlet(name = "ServletResUpLoad")
public class ServletResUpLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = new HashMap<>();

        Resource resource = new Resource();

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);

        // 解决上传文件名称中文乱码
        upload.setHeaderEncoding("utf-8");
//        boolean flag = upload.isMultipartContent(request); // 用于判断是否是上传操作.
//        System.out.println(flag);
//        if (flag) {
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {//是上传组件
                    //得到上传文件名称
                    String name = fileItem.getName();
                    //得到上传文件名称
                    String fileName = FileUploadUtils.getRealName(name);
                    map.put("realName", new String[]{fileName});
                    //得到随机名称
                    String uuidFileName = FileUploadUtils.getUUIDFileName(fileName);
                    map.put("uuidName", new String[]{uuidFileName});//封装上传文件随机名称
                    //得到随机目录
                    String randomDirectory = FileUploadUtils.getRandomDirectory(fileName);
                    //获取磁盘上的路径
                    String uploadPath = this.getServletContext().getRealPath("/WEB-INF/fileupload");

                    //得到文件对象
                    File parentDirect = new File(uploadPath, randomDirectory);
                    if (!parentDirect.exists()) {
                        parentDirect.mkdirs();
                    }
                    map.put("savePath", new String[]{uploadPath + randomDirectory});
                    IOUtils.copy(fileItem.getInputStream(), new FileOutputStream(new File(parentDirect, uuidFileName)));
                    // 删除临时文件
                    fileItem.delete();
                } else {
                    map.put(fileItem.getFieldName(), new String[]{fileItem.getString("UTF-8")});
                }
            }
            BeanUtils.populate(resource, map);
            ResourceService rsourceService = new ResourceService();
            int res = rsourceService.save(resource);
            response.sendRedirect(request.getContextPath() + "/jsp/upload/resource/success.jsp");
        } catch (FileUploadException | InvocationTargetException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
