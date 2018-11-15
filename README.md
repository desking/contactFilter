# contactFilter
[![Build Status](https://travis-ci.org/desking/contactFilter.svg?branch=develop)](https://travis-ci.org/desking/contactFilter)

В проекте использовал базу MySQL.
Для запуска проекту нужно:

1.Поднять базу, для этого нужно использовать dump.sql

2.В application.properties:
   -в spring.datasource.url подставить свой url к базе
   -а также поменять spring.datasource.username и spring.datasource.password на свои

3.Запустить проект можно при помощи mvn spring-boot:run или java -jar <путь к билду>. Или же при помощи кнопочки "Play" в IDE :).

В проект также добавил рандомную генерацию 1 миллиона контактов, так как хотел протестить. Можно сгенереривоть при помощи вызова сервиса /hello/generateAndSaveContacts
