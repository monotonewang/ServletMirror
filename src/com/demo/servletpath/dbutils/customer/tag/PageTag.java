package com.demo.servletpath.dbutils.customer.tag;

import com.demo.servletpath.dbutils.customer.domain.PageBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by WangTest on 2016/12/19.
 */
public class PageTag extends SimpleTagSupport {
    private PageBean pb;

    public PageBean getPb() {
        return pb;
    }

    public void setPb(PageBean pb) {
        this.pb = pb;
    }

    @Override
    public void doTag() throws JspException, IOException {
//        StringBuffer stringBuffer = new StringBuffer();
//        int totalPage = pb.getTotalPage();
//        for (int i = 0; i < totalPage; i++) {
//            stringBuffer.append("<a href='/ServletMirror/ServletFindByPage?pageNum=" + (i + 1) + "&currentPage==" + pb.getCurrentPage() + "}'></a>");
//        }
//        System.out.print(stringBuffer);
//
////        this.getJspContext().getOut().write("aa");
//        this.getJspContext().getOut().write(stringBuffer.toString());

        StringBuffer buff = new StringBuffer();
        int totalPage = pb.getTotalPage();
        int pageNum = pb.getPageNum(); // 当前页码
        if (pageNum - 5 >= 0) {
            for (int i = pageNum - 5; i < pageNum + 4; i++) {
                if (i + 1 == pb.getPageNum()) {
                    buff.append("<a href='/ServletMirror/ServletFindByPage?pageNum="
                            + (i + 1) + "&currentPage=" + pb.getCurrentPage()
                            + "'><font color='green'>" + (i + 1)
                            + "</font></a>&nbsp;&nbsp;");
                } else {

                    buff.append("<a href=''/ServletMirror/ServletFindByPage?pageNum="
                            + (i + 1) + "&currentPage=" + pb.getCurrentPage()
                            + "'>" + (i + 1) + "</a>&nbsp;&nbsp;");
                }
            }

        } else if (pageNum - 5 < 0) {

            for (int i = 0; i < pageNum; i++) {

                if (i + 1 == pb.getPageNum()) {
                    buff.append("<a href='/ServletMirror/ServletFindByPage?pageNum="
                            + (i + 1) + "&currentPage=" + pb.getCurrentPage()
                            + "'><font color='green'>" + (i + 1)
                            + "</font></a>&nbsp;&nbsp;");
                } else {

                    buff.append("<a href=/ServletMirror/ServletFindByPage?pageNum="
                            + (i + 1) + "&currentPage=" + pb.getCurrentPage()
                            + "'>" + (i + 1) + "</a>&nbsp;&nbsp;");
                }
            }

            for (int i = pageNum; i < (pageNum + 4); i++) {

                if (i + 1 == pb.getPageNum()) {
                    buff.append("<a href='/ServletMirror/ServletFindByPage?pageNum="
                            + (i + 1) + "&currentPage=" + pb.getCurrentPage()
                            + "'><font color='green'>" + (i + 1)
                            + "</font></a>&nbsp;&nbsp;");
                } else {

                    buff.append("<a href='/ServletMirror/ServletFindByPage?pageNum="
                            + (i + 1) + "&currentPage=" + pb.getCurrentPage()
                            + "'>" + (i + 1) + "</a>&nbsp;&nbsp;");
                }
            }
        }

        this.

                getJspContext().

                getOut().

                write(buff.toString());
    }
}
