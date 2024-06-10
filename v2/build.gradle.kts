import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar

plugins {
    `java-library`
    alias(libs.plugins.maven.publish.base)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

base {
    archivesName = "youtube-v2"
}

dependencies {
    api(projects.common)
    compileOnly(libs.lavaplayer.v2)
    implementation(libs.rhino.engine)
    implementation(libs.nanojson)
    compileOnly(libs.slf4j)
    compileOnly(libs.annotations)

    testImplementation(libs.lavaplayer.v2)
}

mavenPublishing {
    configure(JavaLibrary(JavadocJar.Javadoc()))
}
