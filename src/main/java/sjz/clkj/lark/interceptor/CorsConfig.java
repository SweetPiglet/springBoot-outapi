package sjz.clkj.lark.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@WebFilter(filterName = "CorsFilter ")
@Configuration
public class CorsConfig implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    	logger.info("开始处理跨域！");
    	HttpServletRequest request = (HttpServletRequest)req;
    	HttpServletResponse response = (HttpServletResponse) res;
        response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");//允许的跨域请求方式
		/*每次异步请求都发起预检请求，也就是说，发送两次请求。第一次是浏览器使用OPTIONS方法发起一个预检请求，第二次才是真正的异步请求，第一次的预检请求获知服务器是否
		允许该跨域请求：如果允许，才发起第二次真实的请求；如果不允许，则拦截第二次请求。*/
		response.setHeader("Access-Control-Max-Age", "0");//每次异步请求都发起预检请求，也就是说，发送两次请求。
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With,"
				+ " If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires,"
				+ " Content-Type, X-E4M-With,userId,token,access_token");//跨域请求允许包含的头
		response.setHeader("Access-Control-Allow-Credentials", "true");	//是否支持跨域，是否允许请求带有验证信息
		response.setHeader("XDomainRequestAllowed", "1");
        chain.doFilter(req, res);
    }
}