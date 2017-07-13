package io.github.yexiaoxiaogo.SpringBootHelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public Hello hello() {
		// TODO Auto-generated constructor stub
		return new Hello("helloworldyxx");
	}

}
