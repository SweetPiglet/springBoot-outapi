package sjz.clkj.lark.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @version: 1.1.0
 * @Description: 飞书调用第三方接口
 * @author: wsq
 * @date: 2020年6月5日下午5:01:28
 */

@FeignClient(name = "LarkSerive", url = "https://open.feishu.cn")
public interface LarkFeign {
	@RequestMapping(value = "/open-apis/auth/v3/app_access_token/internal/", method = RequestMethod.POST, consumes = "application/json")
	public Map<String, Object> querylarkToken(@RequestBody Map<String, Object> map);

}
