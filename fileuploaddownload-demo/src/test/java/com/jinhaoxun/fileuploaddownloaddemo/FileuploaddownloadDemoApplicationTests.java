package com.jinhaoxun.fileuploaddownloaddemo;

import com.jinhaoxun.fileuploaddownloaddemo.util.sftputil.SftpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;
import java.util.Vector;

@Slf4j
@SpringBootTest
class FileuploaddownloadDemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
    }

    @Test
    void upLoadFileTest() throws Exception {
        File file = new File("E:\\2.xlsx");
        InputStream inputStream = new FileInputStream(file);

        SftpUtil.uploadFile("root", "Ajinhaoxun123456", "47.101.135.160", 22, "/usr/local",
                "/testfile/", "test.xlsx", null, inputStream);
    }

    @Test
    void downLoadFileTest() throws Exception {
        SftpUtil.downloadFile("root", "Ajinhaoxun123456", "47.101.135.160", 22,null,
                "/usr/local/testfile/", "test.xlsx","D:\\test.xlsx");
    }

    @Test
    void deleteFileTest() throws Exception {
        SftpUtil.deleteFile("root", "Ajinhaoxun123456", "47.101.135.160", 22,null,
                "/usr/local/testfile/", "test.xlsx");
    }

    @Test
    void getFileListTest() throws Exception {
        Vector<?> fileList = SftpUtil.getFileList("root", "Ajinhaoxun123456", "47.101.135.160",
                22, null,"/usr/local/testfile/");
        log.info(fileList.toString());
    }

}
