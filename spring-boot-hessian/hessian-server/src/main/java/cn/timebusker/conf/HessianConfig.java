package cn.timebusker.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

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
	
	@Autowired
	private ApiService apiService;
	

	@Bean(name = "apiServiceExporter")
	public HessianServiceExporter accountService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(apiService);
		exporter.setServiceInterface(ApiService.class);
		return exporter;
	}

}
