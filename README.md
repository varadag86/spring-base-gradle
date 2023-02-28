# Springboot - Gradle - Boilerplate

The springboot base gradle project is a simple gradle project with boilerplates included. This code base involves standard code elements while building a springboot microserivices and best practices suggested. It will not include `database` configurations or a `integration` code such as connectors for `kafka` or with cloud services.

### What it has?
1. The application has basic spring boot with gradle as build tool.
2. OAS - 3.0 with swagger UI page.
3. Reference swagger documentation demonstrated with a `healthInfo` api.
4. Junit5 and jacoco configuration for execution of unit test and generation of code coverage report.
5. Sample API test to demonstrate how to do a simple sanity API test.

### Including CheckStyles
Check styles are a set of Java lint configurations which enables developers to maintain sanity in the code. The check styles are driven by a set of configurations within the config directory at the root of the project. The `<rootDir>/config/checkstyle.xml` files includes the guildelines to verify the code. These guidelines can be tweaked to adujust the behaviour of linting.

The gradle tasks for checkstyles are included within the `build.gradle` file. It starts with adding the checkstyle plugin itself.

**Step 1:** Add the check style plugin to the gradle project.
```groovy
plugins {
    id 'java'
    id 'checkstyle'
    id 'jacoco'
    id 'org.springframework.boot' version '2.7.10-SNAPSHOT'
    id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}
```

**Step 2:** Add the below set of check style configuration.
```groovy
checkstyle {
	configFile = file("${rootDir}/config/checkstyle/checkstyle.xml")
}

checkstyleMain {
	source ='src/main/java'
}

checkstyleTest {
	source ='src/test/java'
}

tasks.withType(Checkstyle) {
	minHeapSize = "200m"
	maxHeapSize = "1g"
	reports {
		xml.required = false
		html.enabled = true
		html.required = true
		html.destination rootProject.file("build/reports/checkstyle.html")
		html.stylesheet resources.text.fromFile('config/xsl/checkstyle-custom.xsl')
	}
}
```


### What more to come?
1. Cross-cutting concerns for the application such as exception handling, logging etc.
2. Actuator configuration for application health monitoring.