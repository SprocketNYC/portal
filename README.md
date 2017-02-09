Portal AngularJS quick test (with TypeScript)
======

The TypeScript version is now the default welcome page at [indexts.html](../typescript/war/indexts.html). The original JavaScript version can still be accessed from [indexjs.html](../typescript/war/indexjs.html)

###Dependencies and Syntax Highlighting

Currently, npm needs to be installed and on your PATH.

`npm install` or `gradle npmInstall`

A [Gradle plugin](https://github.com/craigburke/client-dependencies-gradle) can be used instead of npm once an [issue](https://github.com/craigburke/client-dependencies-gradle/issues/72) with downloading [type definitions](https://www.npmjs.com/~types) is fixed.

Downloading regular client packages to `node_modules` at the root of the project also helps with syntax highlighting in some IDEs. 

###Compile TypeScript to bundled ES5 JavaScript

```gradle tsCompile```or `tsc` if typescript is installed as a global npm package.

Compiler options can be changed in [tsconfig.json](../typescript/tsconfig.json).  Source maps are included by default and can be debugged in Chrome.

#####Dependencies in the Browser

All third party JavaScript libraries can be resolved via CDNs and configured in [war/config.js](../typescript/war/config.js).

Dependency resolution in the browser is handled via [SystemJS](https://github.com/systemjs/systemjs).

###Package for Deployment

```gradle war``` to download dependencies, compile TypeScript and package.

