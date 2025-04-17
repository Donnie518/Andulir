package org.andulir.service;

import org.andulir.access.InterfaceDataAccess;
import org.andulir.config.AndulirProperty;
import org.andulir.generator.InterfaceDataGenerator;
import org.andulir.parser.InterfaceDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//封装启动所需的bean与方法
@Service
public class InitializerService {
    private static final Logger log = LoggerFactory.getLogger(InitializerService.class);

    @Autowired
    private AndulirProperty property;
    @Autowired
    private InterfaceDataParser interfaceDataParser;
    @Autowired
    private InterfaceDataGenerator interfaceDataGenerator;
    @Autowired
    private InterfaceDataAccess interfaceDataAccess;

    public void initialize() {
        try {
            boolean isNewFile = interfaceDataParser.initXML();
            if (isNewFile) {
                //扫描带有注解的方法，获取参数
                interfaceDataParser.conversionInterfaceInformation(property.getScanPackage());
                //生成随机数据
                interfaceDataGenerator.generateRandomData();
                //在方法中测试数据
                interfaceDataAccess.testMethod();
            }else {
                //直接测试现有文件中的数据
                interfaceDataAccess.testMethod();
            }
        } catch (Exception e) {
            log.error("Initialization failed", e);
            throw new RuntimeException("Failed to initialize application", e);
        }
    }
}
