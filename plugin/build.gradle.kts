import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar

plugins {
  `java-library`
  // alias(libs.plugins.lavalink.gradle.plugin)
  alias(libs.plugins.maven.publish.base)
}

repositories {
  mavenCentral()
  maven { url = uri("https://jitpack.io") }
}

lavalinkPlugin {
  name = "youtube-plugin"
  path = "dev.lavalink.youtube.plugin"
  apiVersion = libs.versions.lavalink
  serverVersion = "4.0.4"
  configurePublishing = false
}

base {
  archivesName = "youtube-plugin"
}

dependencies {
  implementation(projects.common)
  implementation(projects.v2)
  compileOnly(libs.lavalink.server)
  compileOnly(libs.lavaplayer.ext.youtube.rotator)
  implementation(libs.rhino.engine)
  implementation(libs.nanojson)
  compileOnly(libs.slf4j)
  compileOnly(libs.annotations)
  implementation("com.github.Kamilake.lavalink-gradle-plugin:dev.arbjerg.lavalink.gradle-plugin.gradle.plugin:23cb22bdc2")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

mavenPublishing {
  coordinates("dev.lavalink.youtube", "youtube-plugin", version.toString())
  configure(JavaLibrary(JavadocJar.None(), sourcesJar = false))
}