package org.lee.data.preset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为方便开发和测试中使用，预置数据。
 * 
 * @author ruiyuLee@hotmail.com
 * 
 */
public class PresetData {
	public static final String[] arraysString = { "AAA", "BBB", "CCC", "DDD",
			"EEE", "FFF", "GGG", "HHH" };

	public static final String[] arraysUrls = {
			"http://c.hiphotos.baidu.com/image/h%3D768%3Bcrop%3D0%2C0%2C1366%2C768/sign=2cfb8416ca134954611eea626e75f12a/7dd98d1001e93901531bb1a97aec54e736d1960f.jpg",
			"http://a.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=8eb491d28694a4c20a23e32838c220b6/5d6034a85edf8db1932f0cb90823dd54574e74ed.jpg",
			"http://e.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=07f0ccccf9dcd100cd9cfc2244bd7c73/cf1b9d16fdfaaf51cfe9e77e8d5494eef11f7aec.jpg",
			"http://d.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=6673d625d0c8a786be2a4e0d513ff25e/9a504fc2d5628535a6b1a4fe91ef76c6a6ef639f.jpg",
			"http://g.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=07f3e8c56159252da317190702ad3858/e824b899a9014c08b00c227a0b7b02087bf4f43e.jpg",
			"http://d.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=fa8f737858ee3d6d22c683c875205641/42a98226cffc1e172130ecee4b90f603728de966.jpg",
			"http://c.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=bd0dbe31b58f8c54e3d3c12c0c1f1696/3b87e950352ac65c02641eacfaf2b21192138a8f.jpg",
			"http://c.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=ce649a257acb0a4685228f3a5d55cd47/377adab44aed2e734943fef38601a18b86d6fa43.jpg",
			"http://a.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=a1758cf4b151f819f1250749ec82718e/1ad5ad6eddc451da19ac0634b7fd5266d1163292.jpg",
			"http://c.hiphotos.baidu.com/image/h%3D768%3Bcrop%3D0%2C0%2C1366%2C768/sign=c3f6a1d65d6034a836e2ba87f3282a26/4a36acaf2edda3cc260a90f700e93901203f927e.jpg",
			"http://c.hiphotos.baidu.com/image/w%3D1366%3Bcrop%3D0%2C0%2C1366%2C768/sign=070adf5a03087bf47dec53eac4e56c4f/d01373f082025aafbe909edafaedab64034f1a04.jpg" };

	public static List<? extends Map<String, ?>> getArrayMap() {
		List<HashMap<String, String>> arrayMap = new ArrayList<HashMap<String, String>>();
		int length = arraysString.length;
		for (int i = 0; i < length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", arraysString[i]);
			arrayMap.add(map);
		}
		return arrayMap;
	}

}