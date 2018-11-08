
# react-native-textinput-multiline

### This library is just a temporary workaround for the TextInput multiline bug. It's not meant to be used for production as it relies on native React Native implementation and that could change between versions.

This library is meant to be used to fix an Android Native bug that prevents the input from breaking line when set to multiline and a numeric keyboardType. On iOS it just provides the native TextInput from react-native, and on Android it extends the default React Native TextInput to provide the bug fix.

## Getting started

`$ npm install react-native-textinput-multiline --save`

### Mostly automatic installation

`$ react-native link react-native-textinput-multiline`

### Manual installation

#### iOS

There is no need for iOS installations as it exposes the native React Native TextInput on that platform.

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.muritavo.RNReactNativeTextinputMultilinePackage;` to the imports at the top of the file
  - Add `new RNReactNativeTextinputMultilinePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-textinput-multiline'
  	project(':react-native-textinput-multiline').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-textinput-multiline/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-textinput-multiline')
  	```


## Usage
```javascript
import TextInput from 'react-native-textinput-multiline';

render() {
	return (
		<TextInput
			keyboardType="numeric"
			multiline={true}/>
	)
}
```
  