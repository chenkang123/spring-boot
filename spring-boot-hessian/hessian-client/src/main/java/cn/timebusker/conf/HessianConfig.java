package cn.timebusker.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.alibaba.api.ApiService;

/**
 * 
 * @author timebusker
 * 
 *         2017年4月7日
 * 
 *         读取额外的配置文件的配置信息
 */
@Configuration
public class HessianConfig {
	
	

	@Bean
    public HessianProxyFactoryBean helloClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl("http://localhost:8089/ApiService");
        factory.setServiceInterface(ApiService.class);
        return factory;
    }

}
