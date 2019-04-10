![topic map](https://github.com/nasduck/RafikiPermissions/blob/dev/art/topic%20map.png?raw=true)

[![API](https://img.shields.io/badge/RafikiPermissions-v1.2.0-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)&ensp;
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)&ensp;
[![API](https://img.shields.io/badge/License-Apche2.0-brightgreen.svg?style=flat)](https://github.com/nasduck/AfikiPermissions/blob/master/LICENSE)

RafikiPermissions is to simplify Android runtime permission request. The name Rafiki comes from the baboon elder who manages permission in LION KING :D

* [Google developer - Dangerous Permissions](https://developer.android.com/guide/topics/permissions/overview#permission-groups)
* [官方危险权限列表-中文](https://developer.android.google.cn/guide/topics/permissions/overview#permission-groups)

## Setup

### **</u>[中文文档](https://github.com/nasduck/RafikiPermissions/blob/master/README-CN.md)</u>**

Adding jitpack repository in your project's `build.gradle` file:

```gradle
allprojects {
    repositories {
        maven { url 'https://www.jitpack.io' }
    }
}
```

Adding the following dependency to app `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.nasduck:RafikiPermissions:1.2.0'
}
```

## Usage

Here's a minimum example, in which you need to take a photo which requires `Manifest.permission.CAMERA`

#### 1、Declare the required permission

Declare camera permission in `AndroidManifest.xml`：

```xml
<uses-permission android:name="android.permission.CAMERA" />
```

#### 2、Uniformly process permission requests' results in the base activity class

```java
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	
        RafikiPermissions.getInstance(this).onResult(requestCode, permissions, grantResults);
    }
}
```

#### 3、Request permissions

```java
// Return true if the permission is granted
if (RafikiPermissions.getInstance(this)
        .setResultStrategy(new PermissionResultCustomStrategy(this)) // Set customized permission handling strategy, There are also another two preset strategies
        .requestCamera()) {
    // Permissions Already Granted
    ...
}
```

#### 4、Implement callbacks to the results

Implement interface `OnPermissionResultListener`:

```java
@Override   
public void onPermissionsResultGrant(int requestCode) {
    switch (requestCode) {
        case RafikiResultCode.RESULT_CODE_CAMERA:
            // Permissions Granted
    }
}

@Override   
public void onPermissionsResultDenied(int requestCode) {
    switch (requestCode) {
        case RafikiResultCode.RESULT_CODE_CAMERA:
            // Permissions Denied
    }
}
```

## Permission handling strategies

Three strategies are offered:

1. **PermissionResultNothingStrategy** By default. Whether permission granted or not, just do nothing.

Screenshot：   
![NothingStrategy](https://github.com/nasduck/RafikiPermissions/blob/dev/art/NothingStrategy_en.gif?raw=true)

2. **PermissionResultGuideStrategy** Show an additional dialog to guide users to app setting to grant permissions again if permission not granted.

Screenshot：   
![GuideStrategy](https://github.com/nasduck/RafikiPermissions/blob/dev/art/GuideStrategy_en.gif?raw=true)

3. **PermissionResultCustomStrategy** Customized strategy. Implement interface `OnPermissionResultListener` to customize permission handling

Screenshot：   
![CustomStrategy](https://github.com/nasduck/RafikiPermissions/blob/dev/art/CustomStrategy_en.gif?raw=true)

## Different ways to request permissions

##### Request one single permission

Provide `.requestXX()` method corresponding to each permission. For example, request for `Manifest.permission.CAMERA`, use `requestCamera()` to request camera permission directly.

##### Request multiple permissions

For more than one permissions，just use `.addXXX` method corresponding to different permission to add them one by one. Call  `request()` in the end. The parameter passed is the user-defined requestCode（By default, `RafikiResultCode.RAFIKI_PERMISSION_RESULT_CODE` if not passed), to recognized this request in the callbacks:

```java
if (RafikiPermissions.getInstance(this)
        .addReadExternalStorage()
        .addWriteExternalStorage()
        .setResultStrategy(new PermissionResultCustomStrategy(this))
        .request(RESULT_CODE)) {
    // Permissions Already Granted
    ...
}
```

or call `addPermissions()` to add a permission list directly

```java
List<String> permissions = new ArrayList();
permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        
if (RafikiPermissions.getInstance(this)
        .addPermissions(permissions)
        .setResultStrategy(new PermissionResultCustomStrategy(this))
        .request(RESULT_CODE)) {
    // Permissions Already Granted
    ...
}
```

## Contributer

* [Lihao Zhou](https://github.com/redrain39)
* [Chuan DONG](https://github.com/DONGChuan)
* [Si Cheng](1103990937@qq.com)(Art Designer)

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
