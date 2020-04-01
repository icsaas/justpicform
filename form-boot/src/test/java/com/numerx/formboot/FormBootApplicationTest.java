package com.numerx.formboot;

import com.numerx.formboot.testform.mapper.TestMapper;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormBootApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(FormBootApplicationTest.class);
    @Autowired
    private TestMapper testMapper;

//	@Test
//	public void test_curd() throws Exception{
//		final int row1 = testMapper.insert(1,"露娜",2500,4500);
//		if(row1 == 1){
//			log.info("[添加第一个结果] - [{}]","成功");
//		}
//		final int row2 = testMapper.insert(2,"貂蝉",1200,5600);
//		if(row2 == 1){
//			log.info("[添加第二个结果] - [{}]","成功");
//		}
//		final Test Test = testMapper.returnById(2);
//		log.info("根据用户id查询 - [{}]",Test);
//
//		final int row3 = testMapper.update("狄仁杰",1);
//		if(row3 == 1){
//			log.info("[更新英雄名] - [{}]","成功");
//		}
//
//		final int row4 = testMapper.delete(11);
//		if(row4 == 1){
//			log.info("[删除英雄] - [{}]","成功");
//		}
//
//		final List<Test> Tests = testMapper.returnResult();
//		log.info("查询hero表的所有数据 - [{}]",Tests);
//	}

}