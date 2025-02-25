package com;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.XiangmujinduEntity;
import com.service.XiangmujinduService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootSchemaApplicationTests {

	@Resource
	private XiangmujinduService xiangmujinduService;

	@Test
	public void test() {
		Wrapper<XiangmujinduEntity> wrapper = new EntityWrapper();
		wrapper.eq("gongsimingcheng", "装修公司名称8").eq("yezhuzhanghao","11");
		List<XiangmujinduEntity> list = xiangmujinduService.selectList(wrapper);
		System.out.println(list.size());
	}

}
