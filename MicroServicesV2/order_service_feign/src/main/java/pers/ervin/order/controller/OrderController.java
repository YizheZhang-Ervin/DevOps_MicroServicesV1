package pers.ervin.order.controller;

import pers.ervin.order.entity.Product;
import pers.ervin.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductFeignClient productFeignClient;

	/**
	 */
	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) throws Exception {

		if(id != 1) {
			int i = 1/0;
			throw  new Exception("太忙了");
		}

		return  productFeignClient.findById(id);
	}
}
