# task2
# HTTP Logging Starter
# Описание 
HTTP Logging Starter предоставляет возможность логировать все входящие и исходящие HTTP запросы и ответы в вашем Spring Boot приложении. 
Логирование включает метод запроса, URL, заголовки запроса и ответа, код ответа и время обработки запроса.

# Применение 
1. Склонируйте репозиторий 
```
git@github.com:yakudzza/task2.git
```
2.Перейти в директорию проекта:
```
cd project
```
3.Собрать проект с помощью Maven:
```
mvn clean install
```
4. Добавьте зависимость в файл pom.xml вашего проекта:
```
<dependency>
    <groupId>com.example</groupId>
    <artifactId>http-logging-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
5. Установите свойство http.logging.enabled=true в файле application.properties вашего Spring Boot приложения (http.logging.enabled: Управляет включением или выключением логирования HTTP запросов и ответов (по умолчанию включено, если не указано иное).)
```
http.logging.enabled=true
```
