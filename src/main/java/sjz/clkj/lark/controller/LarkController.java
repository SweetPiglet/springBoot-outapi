package sjz.clkj.lark.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sjz.clkj.lark.feign.LarkFeign;
import sjz.clkj.lark.util.R;

/**
 * 
 * @version: 1.1.0
 * @Description: 前端控制层
 * @author: wsq
 * @date: 2020年6月5日下午5:05:22
 */
@RestController
public class LarkController {
@Resource
private LarkFeign larkFeign;
@PostMapping("/getLarkToken")
public R getLarkToken(@RequestBody Map<String,Object> map) {
	return R.ok().put("larkToken", larkFeign.querylarkToken(map));
}
}
