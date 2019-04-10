![topic map](https://github.com/nasduck/RafikiPermissions/blob/dev/art/topic%20map.png?raw=true)

[![API](https://img.shields.io/badge/RafikiPermissions-v1.2.0-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)&ensp;
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)&ensp;
[![API](https://img.shields.io/badge/License-Apche2.0-brightgreen.svg?style=flat)](https://github.com/nasduck/AfikiPermissions/blob/master/LICENSE)

RafikiPermissions 是为了简化 Android 危险权限动态申请操作，将权限申请判断和权限申请过程简化，将权限申请结果拆分成授予成功和授予失败两部分处理，使结果处理更富有逻辑性。组件名称 Rafiki 拉菲奇来源于狮子王里的狒狒长老，统管权限 :D

* [Google developer - Dangerous Permissions(英文需翻墙)](https://developer.android.com/guide/topics/permissions/overview#permission-groups)
* [官方危险权限列表-中文](https://developer.android.google.cn/guide/topics/permissions/overview#permission-groups)

## 依赖
步骤一：在项目的 `build.gradle` 中添加 `jitpack`

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```

步骤二：添加依赖项

```gradle
dependencies {
    implementation 'com.github.nasduck:RafikiPermissions:1.2.0'
}
```

## 基本使用

假设我们需要动态获取相机的权限 `Manifest.permission.CAMERA`

#### 1、添加权限

在 `AndroidManifest.xml` 中加入相应的权限：

```xml
<uses-permission android:name="android.permission.CAMERA" />
```

#### 2、在基类 Activity 中统一进行返回结果的处理

```java
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	
        // 在onRequestPermissionsResult中加入这行代码，传入对应的值
        RafikiPermissions.getInstance(this).onResult(requestCode, permissions, grantResults);
    }
}
```

#### 3、在继承了基类的 Activity 中请求权限

```java
// 对于权限是否授予进行判断，已授予返回true，未授予进行权限授予操作
if (RafikiPermissions.getInstance(this)
        .setResultStrategy(new PermissionResultCustomStrategy(this))    // 设置自定义的权限授予结果处理策略, 也有其他2种预定义策略
        .requestCamera()) {
    // 已经授予权限的逻辑操作
    ...
}
```

#### 4、实现授权结果的回调

实现接口 `OnPermissionResultListener`:

```java
@Override   
public void onPermissionsResultGrant(int requestCode) {
    switch (requestCode) {
        case RafikiResultCode.RESULT_CODE_CAMERA:
            // 权限授予成功
    }
}

@Override   
public void onPermissionsResultDenied(int requestCode) {
    switch (requestCode) {
        case RafikiResultCode.RESULT_CODE_CAMERA:
            // 权限授予失败后
    }
}
```

## 权限处理策略

提供三种权限处理策略

1. **PermissionResultNothingStrategy** 默认策略. 无论是否授予策略, 不做任何操作   
效果图：   
![NothingStrategy](https://github.com/nasduck/RafikiPermissions/blob/dev/art/NothingStrategy.gif?raw=true)
2. **PermissionResultGuideStrategy** 用户拒绝授予权限后, 弹出弹窗引导用户去应用设置中作权限授予   
效果图：   
![GuideStrategy](https://github.com/nasduck/RafikiPermissions/blob/dev/art/GuideStrategy.gif?raw=true)
3. **PermissionResultCustomStrategy** 自定义权限授予策略. 实现 `OnPermissionResultListener` 接口自定义授权回调处理逻辑   
效果图：   
![CustomStrategy](https://github.com/nasduck/RafikiPermissions/blob/dev/art/CustomStrategy.gif?raw=true)

## 请求权限不同的方式

##### 请求单个权限

封装了各个权限对应的 .requestXX() 方法. 比如上面例子中, 请求照相权限, 直接调用 `requestCamera()`

##### 请求多个权限

动态请求多个权限时，根据需要添加相应的权限，最后使用 `request()` 方法请求权限，参数传入自定义的 requestCode（不传则默认为`RafikiResultCode.RAFIKI_PERMISSION_RESULT_CODE`), 用以在回调中识别这次请求:

```java
if (RafikiPermissions.getInstance(this)
        .addReadExternalStorage()
        .addWriteExternalStorage()
        .setResultStrategy(new PermissionResultCustomStrategy(this)) // 设置自定义的权限授予结果处理策略
        .request(RESULT_CODE)) {
    // 已经授予权限的逻辑操作
}
```

或者使用 `addPermissions()` 设置一组权限

```java
List<String> permissions = new ArrayList();
permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        
if (RafikiPermissions.getInstance(this)
        .addPermissions(permissions)
        .setResultStrategy(new PermissionResultCustomStrategy(this))
        .request(RESULT_CODE)) {
    // 已经授予权限的逻辑操作
}
```

## 贡献

* [Lihao Zhou](https://github.com/redrain39)
* [Chuan DONG](https://github.com/DONGChuan)
* [Si Cheng](1103990937@qq.com)(设计师)

## LICENSE
```
   Copyright (2019) Chuan Dong, Lihao Zhou

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
