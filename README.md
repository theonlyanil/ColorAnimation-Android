ColorAnimation
=====

[![](https://jitpack.io/v/theonlyanil/ColorAnimation.svg)](https://jitpack.io/#theonlyanil/ColorAnimation)

ColorAnimation is a simple to use library for transforming colors of a ViewGroup with beautiful animations. 
This library saves up a lot of code of me as now I can do all color animations with just one line of code.

Download
--------

Gradle(project-level):

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()

        maven { url 'https://jitpack.io' }
    }
}
```

Gradle(app-level):

```gradle
dependencies {
  implementation 'com.github.theonlyanil:ColorAnimation:0.2.4'
}
```


Will update this space for Maven.

Usage
----

1. Transform to a color.
```java
  // Format: ColorAnimation.colour(Context, ViewGroup, Time(in millis), Color);
  ColorAnimation.colour(this, relativeLayout, 4000, R.color.colorAccent);
```

2. Infinite color animation (RGB)
```java
  // Format: ColorAnimation.rgb(Context, ViewGroup, Time(in millis));
  ColorAnimation.rgb(this, relativeLayout, 4000);
```

3. Stop the animation
```java
  ColorAnimation.stop();
```

Author
------
Anil Sardiwal - @TheOnlyAnil on Github and Twitter.
