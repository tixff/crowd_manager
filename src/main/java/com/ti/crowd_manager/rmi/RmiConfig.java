package com.ti.crowd_manager.rmi;

import com.ti.crowd_manager.service.AdvertiseService;
import com.ti.crowd_manager.service.ItemDetailService;
import com.ti.crowd_manager.service.ItemService;
import com.ti.crowd_manager.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @author Ti
 * @date 2018/12/10
 */

@Configuration
public class RmiConfig {

    @Bean
    RmiServiceExporter rmiAdvertiseExporter(AdvertiseService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("advertiseService");
        exporter.setServiceInterface(AdvertiseService.class);
        return exporter;
    }

    @Bean
    RmiServiceExporter rmiUserExporter(UserService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("userService");
        exporter.setServiceInterface(UserService.class);
        return exporter;
    }

    @Bean
    RmiServiceExporter rmiItemDetailExporter(ItemDetailService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("itemDetailService");
        exporter.setServiceInterface(ItemDetailService.class);
        return exporter;
    }

    @Bean
    RmiServiceExporter rmiItemExporter(ItemService service) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(service);
        exporter.setServiceName("itemService");
        exporter.setServiceInterface(ItemService.class);
        return exporter;
    }
}
