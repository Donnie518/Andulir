package org.andulir.generator;

import org.andulir.utils.XMLUtils;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

import static org.andulir.utils.TypeUtils.isBasicType;

@Component
@Slf4j
public class InterfaceDataGenerator {
    @Autowired
    private DataGenerator basicDataGenerator;
    @Autowired
    private DataGenerator listDataGenerator;
    @Autowired
    private DataGenerator requestDataGenerator;
    @Autowired
    private Document document;
    @Autowired
    private File file;

    public void generateRandomData() {
        Element rootElement = document.getRootElement();
        List<Element> controllerMappings = rootElement.elements("controllerMapping");
        for (Element controllerMapping : controllerMappings) {
            String controllerName = controllerMapping.attribute("name").getText();
            List<Element> methodMappings = controllerMapping.elements();
            for (Element methodMapping : methodMappings) {
                String name = methodMapping.attribute("name").getText();
                String status = methodMapping.attribute("status").getText();
                if ("0".equals(status)) {
                    return;
                }
                Element parameterMapping = methodMapping.element("parameterMapping");
                List<Element> typeMappings = parameterMapping.elements();
                for (Element typeMapping : typeMappings) {
                    String value = null;
                    String typeName = typeMapping.element("name").getText();

                    for (int i = 0; i < Integer.parseInt(status); i++) {
                        if (typeName.contains("java.util.List")) {
                            value = listDataGenerator.generateRandomData(typeName,typeMapping);
                        } else if (isBasicType(typeName)) {
                            value = basicDataGenerator.generateRandomData(typeName, typeMapping);
                        } else {
                            value = requestDataGenerator.generateRandomData(typeName,typeMapping);
                        }

                        if (value != null) {
                            XMLUtils.addBasicValue(typeMapping,value);
                            XMLUtils.writeXML(document,file);
                        }
                    }
                }
                log.info("ATest注解方法[{}]接口参数随机用例已生成。",name);
            }
        }
    }

}
