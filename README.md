# spotify-service
Java project using Spotify API



### Using Jasypt Encryptor
- Execute the following command to encrypt a value

      mvn jasypt:encrypt-value -Djasypt.encryptor.password=key -Djasypt.plugin.value="Password" -Djasypt.plugin.path="file:src/main/resources/application.yml"

- Write DEC() in the properties of application.yml and execute the following command (this command encrypt automatically your properties):

      mvn jasypt:encrypt -Djasypt.encryptor.password=key -Djasypt.plugin.path="file:src/main/resources/application.yml"