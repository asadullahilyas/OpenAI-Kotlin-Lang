[![](https://jitpack.io/v/asadullahilyas/openai-kotlin-lang.svg)](https://jitpack.io/#asadullahilyas/openai-kotlin-lang)

# OpenAI - Kotlin

A community maintained open source library to access APIs of OpenAI.

Its usage is pretty much self-explanatory but I'm giving a coding example below to get things started.

## Project Level Gradle

### Groovy
``` Groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### Kotlin
```` Kotlin
allprojects {
    repositories {
        ...
        maven { url = URI.create("https://jitpack.io") }
    }
}
````

## App Level Gradle

### Groovy
```` Groovy
dependencies {
    implementation 'com.github.asadullahilyas:OpenAI-Kotlin-Lang:1.0.2'
}
````

### Kotlin
``` Kotlin
dependencies {
    implementation("com.github.asadullahilyas:OpenAI-Kotlin-Lang:1.0.2")
}
```

## Example
``` Kotlin
fun main() {
    val openAISecretKey: String = readOpenAISecretKeyFromFile()
    val openAI = OpenAI(
        configuration = Configuration(
            secretKey = openAISecretKey
        )
    )
    CoroutineScope(Dispatchers.IO).launch {
        val response = openAI.getModels()
        val models = response.data
        models.forEach { model ->
            println(model.id)
        }
    }
}
```

## Contact Me
If you have found any mistake or you can make an improvement, please create a pull request
or reach out to me on my [LinkedIn](https://www.linkedin.com/in/asadullahilyas/) page.