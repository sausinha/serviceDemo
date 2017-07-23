/**
 * 
 */
package com.service.demo.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.service.demo.constants.Constants;
import com.service.demo.data.beans.CustomerData;

/**
 * @author
 *
 */
@Component("serviceDataProvider")
public class ServiceDataProvider {

	private static final Logger logger = LoggerFactory.getLogger(ServiceDataProvider.class);

	private Map<String, Object> dataBean;
	private ResourceLoader resourceLoader;

	public ServiceDataProvider() {
		logger.info("ServiceDataProvider default construt called");
	}

	@Inject
	public ServiceDataProvider(ResourceLoader resourceLoader) {
		logger.info("ServiceDataProvider resource loader injected");
		this.resourceLoader = resourceLoader;
	}

	@PostConstruct
	public void init() {
		logger.info("ServiceDataProvider post consturct called");
		try {
			loadData();
		} catch (Exception excep) {
			logger.error("Exception while loading json backend data", excep);
		}
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("ServiceDataProvider pre destroy called");

	}

	public void loadData() {
		try {
			logger.info("before loading");
			Resource resource = resourceLoader.getResource("classpath:data.json");
			logger.info("after loading");
			File jsonDataFile = resource.getFile();

			ObjectMapper mapper = new ObjectMapper();
			CustomerData customerData = mapper.readValue(jsonDataFile, CustomerData.class);
			logger.info("Customer data read from data.json " + customerData);

			dataBean = new HashMap<>();
			dataBean.put(Constants.CUSTOMER_DATA_STR, customerData);

			System.out.println("***loadedddddddddddddd****");
		} catch (Exception excep) {
			logger.error("Exception while loading json backend data", excep);
		}
	}

	/**
	 * @return the dataBean
	 */
	public Map<String, Object> getDataBean() {
		return dataBean;
	}

	/**
	 * @param dataBean
	 *            the dataBean to set
	 */
	public void setDataBean(Map<String, Object> dataBean) {
		this.dataBean = dataBean;
	}

	/**
	 * getCustomerData
	 * 
	 * @return CustomerData
	 */
	public CustomerData getCustomerData() {
		return null != dataBean ? (CustomerData) dataBean.get(Constants.CUSTOMER_DATA_STR) : new CustomerData();
	}

}
