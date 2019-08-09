package gaoxiao.lei;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 启用 zuul,自带熔断
public class ZuulApplication {
	public static String defaultPort = "10900";// 默认端口号

	public static void main(String[] args) {
		// 由于编译器的版本不同所以需要判断是不是最前面会默认有一个
		int i = 0;
		if (args.length == 2)
			i = 1;
		if (!"0".equals(args[i]))// 输入0表示端口号使用默认端口号,反之则不是
			defaultPort = args[i];
		new SpringApplicationBuilder(ZuulApplication.class).properties("server.port=" + defaultPort).run(args);
	}

}
