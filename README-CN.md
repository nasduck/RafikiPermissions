![topic map](https://github.com/nasduck/RafikiPermissions/blob/dev/art/topic%20map.png?raw=true)

[![API](https://img.shields.io/badge/RafikiPermissions-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)&ensp;
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)&ensp;//todo build
[![API](https://img.shields.io/badge/License-Apche2.0-brightgreen.svg?style=flat)](https://github.com/nasduck/AfikiPermissions/blob/master/LICENSE)

AfikiPermissions是为了简化Android危险权限动态申请操作，将权限申请判断和权限申请过程简化，将权限申请结果拆分成授予成功和授予失败两部分处理，使结果处理更富有逻辑性。

## 依赖
步骤一：在项目的build.gradle中添加jitpack
```
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```
步骤二：添加依赖项
```
dependencies {
    implementation 'com.github.nasduck:RafikiPermissions:1.1.2'
}
```

## 使用方式
#### [详细使用参考文档](https://github.com/nasduck/RafikiPermissions/wiki/%E8%AF%A6%E7%BB%86%E4%BD%BF%E7%94%A8%E5%8F%82%E8%80%83%E6%96%87%E6%A1%A3)
### 基本权限申请
一个简单的例子，假设我们需要实现拍照的功能，这时候要动态获取相机的权限**Manifest.permission.CAMERA**
#### 1、添加权限到AndroidManifest.xml
在AndroidManifest.xml中加入相应的权限代码：
```
<uses-permission android:name="android.permission.CAMERA" />
```

#### 2、在BaseActivity中进行返回结果的初始化
```
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 在onRequestPermissionsResult中加入这行代码，传入对应的值
        RafikiPermissions.getInstance(this).onResult(requestCode, permissions, grantResults);
    }
}
```

#### 3、在继承了BaseActivity的Activity中使用
```
// 对于权限是否授予进行判断，已授予返回true，未授予进行权限授予操作
if (RafikiPermissions.getInstance(this)
        .setResultStrategy(new PermissionResultCustomStrategy(this))    // 设置自定义的权限授予结果处理策略
        .requestCamera()) {                                             // 请求相机权限
    // 如果已经授予权限后，需要作的操作逻辑
}
```

#### 4、在回调中进行权限授予后的逻辑处理
```
@Override   
public void onPermissionsResultGrant(int requestCode) {
    switch (requestCode) {
        // 根据权限对应的requestCode进行权限操作的匹配，授予失败同理
        case RafikiResultCode.RESULT_CODE_CAMERA:
            // 权限授予成功后的操作
    }
}

@Override   
public void onPermissionsResultDenied(int requestCode) {
    switch (requestCode) {
        case RafikiResultCode.RESULT_CODE_CAMERA:
            // 权限授予失败后的操作
    }
}
```

### 权限申请策略
之前的例子中已经使用了PermissionResultCustomStrategy，是留给用户自己去实现的权限授予操作后的逻辑，在本库中已经封装了几种策略。
- PermissionResultNothingStrategy——授予权限后不做任何操作
- PermissionResultGuideStrategy——授予权限失败后引导用户去设置中作权限授予

## 联系我们


## LICENSE
> Copyright
>
> Licensed under the Apache License, Version 2.0 (the "License");    
> you may not use this file except in compliance with the License.   
> You may obtain a copy of the License at
>
> http://www.apache.org/licenses/LICENSE-2.
>
> Unless required by applicable law or agreed to in writing, software   
> distributed under the License is distributed on an "AS IS" BASIS,   
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   
> the License for the specific language governing permissions and   
> limitations under the License.
