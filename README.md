## CLI for Documents API

A simple command line interface for [Document Test API](https://github.com/europace/duck-coding-challenge), based on [Spring Shell](https://spring.io/projects/spring-shell)

### Building and running locally
1. Clone this repository
2. Configure base URI for Document Test API  
see `client.documentApiBaseUrl` in `application.properties`  
3. Create executable and run
   1. With [Docker](https://www.docker.com/products/docker-desktop/)
      2. Build Docker image  
      `docker build -t europace/document-cli .`
      3. Run the Docker image  
      `docker run -it europace/document-cli`
   2. With Gradle (requires Java 11)
      1. Build JAR  
      `./gradlew bootJar`
      2. Run  
      `java -jar build/libs/app.jar`

You should see the Spring Shell prompt after running  
`shell:>`

### Running unit tests
`./gradlew test`

### Features
#### General commands
General commands provided by Spring Shell work; such as `help`, `clear`, `exit`.

#### Showing document information
Command `show` can be used to retrieve and list documents from Document Test API.

Run `help show` for available options.
* Filter by category
  * `show -c cat_1`
* Sort by name
  * `show -s name`
* Filter by category and sort by size
  * `show -c cat_1 -s size`
* Filter by category, sort by size and show aggregates
  * `show -c cat_1 -s size -a`

#### Output format
* List of documents is shown tabular with total line length of 132 chars, clutters a bit on narrower terminal.
* Aggregates are shown at the end of the output.

![Sample Output](src/img/sample-shell-output.png?raw=true "Sample Output")