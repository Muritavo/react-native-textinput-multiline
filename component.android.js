import { requireNativeComponent, TextInput, TouchableWithoutFeedback } from "react-native";
import React from "react";
import invariant from "invariant";

const Provider = React.createContext(false).Provider;
const AndroidTextInput = requireNativeComponent('RNReactNativeTextinputMultiline');

class TextInputMultilineFix extends TextInput {
    constructor(props) {
        super(props);
    }

    render() {
        const props = Object.assign({}, this.props);
        props.style = [this.props.style];
        /* $FlowFixMe(>=0.53.0 site=react_native_fb,react_native_oss) This comment
         * suppresses an error when upgrading Flow's support for React. To see the
         * error delete this comment and run Flow. */
        let children = this.props.children;
        let childCount = 0;
        React.Children.forEach(children, () => ++childCount);
        invariant(
            !(this.props.value && childCount),
            'Cannot specify both value and children.',
        );
        if (childCount > 1) {
            children = <Text>{children}</Text>;
        }

        if (props.selection && props.selection.end == null) {
            props.selection = {
                start: props.selection.start,
                end: props.selection.start,
            };
        }

        const textContainer = (
            <AndroidTextInput
                ref={this._setNativeRef}
                {...props}
                mostRecentEventCount={0}
                onFocus={this._onFocus}
                onBlur={this._onBlur}
                onChange={this._onChange}
                onSelectionChange={this._onSelectionChange}
                onTextInput={this._onTextInput}
                text={this._getText()}
                children={children}
                disableFullscreenUI={this.props.disableFullscreenUI}
                textBreakStrategy={this.props.textBreakStrategy}
                onScroll={this._onScroll}
            />
        );

        return (
            <Provider>
                <TouchableWithoutFeedback
                    onLayout={props.onLayout}
                    onPress={this._onPress}
                    accessible={this.props.accessible}
                    accessibilityLabel={this.props.accessibilityLabel}
                    accessibilityComponentType={this.props.accessibilityComponentType}
                    nativeID={this.props.nativeID}
                    testID={this.props.testID}>
                    {textContainer}
                </TouchableWithoutFeedback>
            </Provider>
        );
    }
}

export default TextInputMultilineFix;
