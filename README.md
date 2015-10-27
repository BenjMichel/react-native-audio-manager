# react-native-audio-player

Audio player library for react native Android

##Installation

```javascript
npm install react-native-audio-player --save
```

* In `android/settings.gradle`

```gradle
...
include ':RNAudioPlayer', ':app'
project(':RNAudioPlayer').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-audio-player/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
  ...
  compile project(':RNAudioPlayer')
}
```

* Register the module (in MainActivity.java)

```java
import com.tricy.RNAudioPlayer.*; // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ...

  @Override
  protected void onCreate(Bundle savedInstanceState){
    ...
    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplicatio)
      ...
      .addPackage(new MainReactPackage())
      .addPackage(new RNAudioPlayer())   //  <--- add here
      ...
  }
}
```

## Usage

Put audio resources in `[project_root]/android/app/src/main/res/raw`

### Example

```javascript

//require module
var AudioPlayer = require('react-native-audio-player');

//play sound
AudioPlayer.play('hello.mp3');

```
