package com.ti.crowd_manager.controller;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Ti
 * @date 2019/1/25
 */
public class FileUploadControllerTest extends AbstractControllerTest {

    @Test
    public void upload() throws Exception {
        File file = new File("C:\\Users\\Ti\\Pictures\\Screenshots\\love.png");
        mockMvc.perform(
                MockMvcRequestBuilders
                        .fileUpload("/upload")
                        .file(new MockMultipartFile("file",new FileInputStream(file)))
        );
    }
}
