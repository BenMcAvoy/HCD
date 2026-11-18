# HCD

HCD is a Minecraft Fabric client-mod experiment. It uses client tick events and key bindings to prototype gameplay-altering modules, including flight and fall-damage toggles.

## Build

Use the Gradle wrapper from the repository root:

```sh
./gradlew build
```

On Windows, use `gradlew.bat build`. The Minecraft, mappings, Fabric Loader and Fabric API versions are set in `gradle.properties`.

## Status

This is an experimental client-side modding/reverse-engineering project, not a maintained public mod. Only use gameplay-altering code in private environments where you have permission.
