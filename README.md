# BeautySaloon
17. Система Расписания Салона Красоты. Нужно создать страницу, где
отображается расписание работы сотрудников салона, так чтобы можно было
записаться на прием. Записи клиентов должен видеть только
Администратор и Мастер, другие видят только занятое место. После
предоставления услуг Клиент оставляет отзыв. Предложение о написании
отзыва приходит на электронную Почту. Администратор может читать
отзывы о коллегах.
## Общие требования
Необходимо построить веб-приложение, поддерживающую следующую
функциональность:
1. На основе сущностей предметной области создать классы их
описывающие.
2. Классы и методы должны иметь отражающую их функциональность
названия и должны быть грамотно структурированы по пакетам
3. Информацию о предметной области хранить в БД, для доступа
использовать API JDBC с использованием пула соединений,
стандартного или разработанного самостоятельно. В качестве СУБД
рекомендуется MySQL.
4. Приложение должно поддерживать работу с кириллицей (быть
многоязычной), в том числе и при хранении информации в БД.
5. Код должен быть документирован.
6. Приложение должно быть покрыто Юнит-тестами
7. При разработке бизнес логики использовать сессии и фильтры, и
события в системе обрабатывать с помощью Log4j.
8. В приложении необходимо реализовать Pagination, Transaction в
зависимости от Вашего проекта
9. Используя сервлеты и JSP, реализовать функциональности,
предложенные в постановке конкретной задачи.
10 . В страницах JSP применять библиотеку JSTL
11 . Приложение должно корректно реагировать на ошибки и исключения
разного рода (Пользователь никогда не должен видеть stack-trace на
стороне front-end).
12 . В приложении должна быть реализована система Авторизации и
Аутентификации
## Требования к системе
* Java 8
* Apache Tomcat 8 
* Maven 4.0
* MySql 5.7.20
##Установка и запуск
* Загрузить или клонировать проект с GitHub
* Создать базу данных beauty_salon 
* В корневой папке проекта выполинть команду mvn clean install tomcat7:run
