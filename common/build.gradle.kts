import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import org.gradle.api.JavaVersion

plugins {
    `java-library`
    alias(libs.plugins.maven.publish.base)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

base {
    archivesName = "youtube-common"
}

dependencies {
    compileOnly(libs.lavaplayer.v1)

    implementation(libs.rhino.engine)
    implementation(libs.nanojson)
    compileOnly(libs.slf4j)
    compileOnly(libs.annotations)

    testImplementation(libs.lavaplayer.v1)
}

mavenPublishing {
    configure(JavaLibrary(JavadocJar.Javadoc()))
}
