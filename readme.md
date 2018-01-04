####给ActiveAndroid库添加了加密功能
- 该库仅仅是结合了这两个库
- ActiveAndroid: https://github.com/pardom/ActiveAndroid
- 加密使用的是sqlcipher: https://www.zetetic.net/sqlcipher/sqlcipher-for-android/

- - -

####使用方法
- 添加仓库
```java
    allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

- 添加依赖
```xml
    compile 'com.github.yudapiandroid:SqlCipherAndActiveAndroid:1.0'
```


- 初始化
```java
    // 在application的onCreate
    ActiveAndroid.initialize(this,password);
```

- - -

**使用的方法和原来一样~~**

