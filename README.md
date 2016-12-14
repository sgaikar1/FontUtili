# font-utils


The goal of this library is to allow your app to support multiple FontFamilies (e.g. lato, roboto, etc.) with their own styles (e.g. normal, bold, italic) in an easily-configurable way.  


### Installation

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

dependencies {
    compile('com.github.sgaikar1:FontUtils:1.0')
}
```

### Usage

First, make sure your fonts are located in your *assets* folder (in a /fonts/ subdirectory to be organized). Let's assume you have a roboto normal/bold font called *robo.ttf* and *robo_bold.ttf*, respectively. Now you need to override the *R.array.fu__font_family_resources* string-array resource to include your fonts:

```
<string-array name="fu__font_family_resources">
    <item>roboto--normal=fonts/robo.ttf,bold=fonts/robo_bold.ttf</item>
</string-array>
```

The format here is:

```
<item>FONT_FAMILY_NAME--STYLE_1=FONT1_PATH,STYLE_2=FONT2_PATH</item>
```

With the supported styles being

* NORMAL
* BOLD
* ITALICS
* BOLD_ITALICS

Values in the resources are not case-sensitive, and their comparing integers are static in the Typeface class (e.g. Typeface.BOLD or Typeface.ITALICS).

Now, we need to ensure we have a default FontFamily correctly set by overring *R.string.fu__default_font_family*:

* In  XML
```
<string name="fu__default_font_family">roboto</string>
```

Next, we have 3 choices for how to use this font. We can either

###### Use the already-overridden classes for you

```
<com.guardanis.fontutils.TextView 
    xmlns:app="http://schemas.android.com/apk/res-auto"
    app:textFontFamily="roboto"
    android:textStyle="bold" />

```

These convenience helper classes include
* com.appnirman.fontutils.TextView
* com.appnirman.fontutils.Button
* com.appnirman.fontutils.EditText
* com.appnirman.fontutils.AutoCompleteTextView
* com.appnirman.fontutils.CheckBox
* com.appnirman.fontutils.TextInputEditText
* com.appnirman.fontutils.CheckedTextView
* com.appnirman.fontutils.RadioButton
* com.appnirman.fontutils.Switch
* com.appnirman.fontutils.ToggleButton
* com.appnirman.fontutils.MultiAutoCompleteTextView


Check them out if you want to implement them for other types of TextViews.

###### Use the FontUtils attribute in your own custom classes so they support your fonts by default

Call the following from your custom TextView (or TextView subclass)'s constructor.

* In Java
```
FontUtils.getInstance(getContext())
                .load(this, attrs, defStyle);

```
###### Manually call one of the FontUntils' helper methods to set the font programmatically

```
TextView view = (TextView) findViewById(R.id.some_id);
FontUtils.getInstance(getContext())
                .setTypeface(view, fontFamily, style);
```

### ToDos and Notes
* A NORMAL font is required for a typeface to be loaded. If the FontFamily is loaded without a normal font, it will throw a RuntimeException letting you know what went wrong.
* Trying to load any non-normal font style that doesn't exist will default to the normal style.
* For other widgets please refer to the sample app.

##Credits

 * [mattsilber](https://github.com/mattsilber/font-utils)
 
 
 ## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2016 Santosh Gaikar.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
