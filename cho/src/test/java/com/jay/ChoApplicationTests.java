package com.jay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ChoApplicationTests {

	@Test
	public void setTest() {
		Map<String, String> map = new HashMap<>();

		map.put("key1", "value1");
		map.put("key3", "value3");
		map.put("key2", "value2");

		// key값만 가져오기
		Set<String> set = map.keySet();

		Iterator<String> ite = set.iterator();

		List<String> keyList = new ArrayList<>();

		while (ite.hasNext()) {
			String key = ite.next();
			keyList.add(key);
		}

		// key만 리스트로 뽑아내기
		log.info("###keyList");
		log.info(keyList.toString());

		// map에 특정 키값이 있는지 조회하기
		log.info("###containsKey");
		System.out.println(map.containsKey("key1"));
		log.info(String.valueOf(map.containsKey("key1")));

		// map에 특정 value값이 있는지 조회하기
		log.info("###containsValue");
		log.info(String.valueOf(map.containsValue("value3243")));
	}

	@Test
	void threadTestMethod() {
		log.info("야호");
	}
}
