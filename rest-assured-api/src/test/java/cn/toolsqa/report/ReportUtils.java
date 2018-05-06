package cn.toolsqa.report;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import java.io.File;
import java.util.Date;

public class ReportUtils {
    private static final Logger logger = Logger.getLogger(ReportUtils.class);
    public ReportUtils() {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    /*********************************************************************************************
     * 写log和报告操作
     *********************************************************************************************/
    /**
     * 写日志和报告
     *
     * @param comm
     */
    public void log(String... comm) {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        if (comm.length == 0) {
            Reporter.log("[" + time + "] <br />");
            logger.info("");
        } else {
            Reporter.log("[" + time + "] " + comm[0] + "<br />");
            logger.info(comm[0]);
        }
    }

    /**
     * 写日志和报告
     *
     * @param comm
     * @comment 如果selenium.properties中【isPrintDebugMsg】值为0，则只打印looger，不打印report
     */
    public void debug(String... comm) {
        if (1 == 1) {
            log("[debug]" + comm[0]);
        } else {
            logger.info(comm[0]);
        }
    }

    /**
     * 写错误日志和报告
     *
     * @param comm
     */
    public void error(String comm) {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        Reporter.log("<span style=\"color:#FF0000\"><b>[" + time + "] [ERROR] " + comm + "</b></span><br />");
        logger.error(comm);
    }

    /**
     * 写警告日志和报告
     *
     * @param comm
     */
    public void warn(String comm) {
        String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        Reporter.log("<span style=\"color:#FF7F27\"><b>[" + time + "] [WARNING] " + comm + "</b></span><br />");
        logger.warn(comm);
    }

    /**
     * 写重要的日志和报告
     *
     * @param comm
     */
    public void highLight(String comm) {
        log("<span style='background-color:#FFE500;'>" + comm + "</span>");
    }

    /**
     * 写绿色高亮的的日志和报告
     *
     * @param comm
     */
    public void greenLight(String comm) {
        log("<span style='background-color:#CFFFBA;'>" + comm + "</span>");
    }

    /**
     * 参数高亮
     *
     * @param comm
     */
    public void paraLight(String comm) {
        if (1 == 1) {
            log("<span style='background-color:#E4FFD9;'>" + comm + "</span>");
        } else {
            logger.info(comm);
        }
    }

    /**
     * 给MCDB用的日志和报告
     *
     * @param comm
     */
    public void mcdbLight(String comm) {
        if (1 == 1) {
            log("<span style='background-color:#C1E7F7;'>[MCDB]" + comm + "</span>");
        } else {
            logger.info("[MCDB]" + comm);
        }
    }

    /**
     * 写醒目的标题
     *
     * @param comm
     */
    public void title(String comm) {
        String str;
        str = "<p style=\"color:#0068BD;margin-top:25px;margin-bottom:8px\"><b>";
        str = str + "**********************************************************************************************<br>";
        str = str + "* " + comm + "<br>";
        str = str + "**********************************************************************************************</b>";
        str = str + "</p>";
        Reporter.log(str);
    }

    /**
     * 用于截图的log写入
     *
     * @param comm
     * @param file
     */
    public void screenShotLog(String comm, File file) {
        int width = 350;
        String absolute = "file:" + file.getAbsolutePath();

        Reporter.log("<a target='_blank' href=\"" + absolute + "\">");
        Reporter.log("<img width=\"" + width + "\" src=\"" + absolute + "\" />    " + comm);
        Reporter.log("</a><br />");
    }
}
