package com.seveneleven.employeeService.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/eureka")
public class EurekaClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaClientController.class);

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("")
	public List<String> getAllEurekaClient(){
		
		LOGGER.info("Start");
		return discoveryClient.getServices();
	}
	
	@GetMapping("/{servicename}/{mapping}")
	public Object[] getAllEurekaClientByUrlName(@PathVariable String servicename, @PathVariable String mapping){
		
		LOGGER.info("Start");
		RestTemplate template = new RestTemplate();
		Map<String, String> response = new LinkedHashMap();
		
		List<ServiceInstance> instance = discoveryClient.getInstances(servicename);
		LOGGER.debug("instance {}:", instance);
		
		if(instance.isEmpty()) {
			throw new IllegalArgumentException("No Uri found");
		}
		
		ServiceInstance userServiceInstance = instance.get(0);
		LOGGER.debug("instance {}:", userServiceInstance);
		String uri = userServiceInstance.getUri().toString()+"/"+mapping;
		LOGGER.debug("URI {}", uri);
		ResponseEntity <Object[]> res = template.exchange(uri.toString(), HttpMethod.GET, null, Object[].class);
		
		return res.getBody();
	}
	
}
