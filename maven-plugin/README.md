<img src="https://images.cooltext.com/5195723.png" align="right">

## autogen-maven-plugin<br>![mvn-plugin][mvn-plugin] <a href="https://www.fastjax.org/"><img src="https://img.shields.io/badge/FastJAX--blue.svg"></a>
> Maven Plugin for general code-generation tools

### Introduction

The `autogen-maven-plugin` plugin is used for general code-generation tools.

### Goals Overview

* [`autogen:radixtree`](#autogenradixtree) constructs an Incremental Search Tree enum class.

### Usage

#### `autogen:radixtree`

The `autogen:radixtree` goal is bound to the `generate-sources` phase, and constructs a class with a statically defined Incremental Search Tree enum from a file with a sorted newline-delimited list of keywords.

##### Example 1

```xml
<plugin>
  <groupId>org.fastjax.autogen</groupId>
  <artifactId>autogen-maven-plugin</artifactId>
  <version>0.2.3-SNAPSHOT</version>
  <executions>
    <execution>
      <goals>
        <goal>radixtree</goal>
      </goals>
      <configuration>
        <file>src/test/resources/keywords.txt</file>
        <dir>generated-test-sources/radixtree</dir>
        <className>org.mycompany.Keywords</className>
      </configuration>
    </execution>
  </executions>
</plugin>
```

#### Configuration Parameters

| Name            | Type    | Use      | Description                                                                 |
|:----------------|:--------|:---------|:----------------------------------------------------------------------------|
| `/file`         | String  | Required | File containing sorted newline-delimited list of seed keywords.             |
| `/dir`          | String  | Required | Destination directory of generated enum.                                    |
| `/className`    | String  | Required | Name of class of generated enum.                                            |
| `/inheritsFrom` | String  | Optional | Name of class of the generated enum must inherit from. **Default:** `null`. |

### License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details.

<a href="http://cooltext.com" target="_top"><img src="https://cooltext.com/images/ct_pixel.gif" width="80" height="15" alt="Cool Text: Logo and Graphics Generator" border="0" /></a>

[mvn-plugin]: https://img.shields.io/badge/mvn-plugin-lightgrey.svg