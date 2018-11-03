
# react-native-react-native-textinput-multiline

### This library is just a temporary workaround for the TextInput multiline bug. It's not meant to be used for production.

This library is meant to be used to fix an Android Native bug that prevents the input from breaking line when set to multiline and a numeric keyboardType. On iOS it just provides the native TextInput from react-native, and on Android it extends the default react-native TextInput to provide the bug fix.

## Getting started

`$ npm install react-native-react-native-textinput-multiline --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-textinput-multiline`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-textinput-multiline` and add `RNReactNativeTextinputMultiline.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeTextinputMultiline.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeTextinputMultilinePackage;` to the imports at the top of the file
  - Add `new RNReactNativeTextinputMultilinePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-textinput-multiline'
  	project(':react-native-react-native-textinput-multiline').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-textinput-multiline/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-textinput-multiline')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeTextinputMultiline.sln` in `node_modules/react-native-react-native-textinput-multiline/windows/RNReactNativeTextinputMultiline.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Textinput.Multiline.RNReactNativeTextinputMultiline;` to the usings at the top of the file
  - Add `new RNReactNativeTextinputMultilinePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import TextInput from 'react-native-react-native-textinput-multiline';

render() {
	return (
		<TextInput
			keyboardType="numeric"
			multiline={true}/>
	)
}
```
  