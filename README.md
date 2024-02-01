# Java REST сервис по CRUD операциям
## Via: Maven, Spring Boot, Securtiy, PostgreSQL, Liquibase, Docker, dbAdmin

1. **Как запустить?**
     - Клонируем репозиторий, переходим в рутовую папку, запускаем `docker-compose up`, если будете что то изменять - не забудьте добавить `--build`

> [!IMPORTANT]
> В самом конце я указал логины и пароли для каждого из сервисов, перед тем как проходить по ссылкам, убедитесь, что вы прошли auth :shipit:
       
2. **Я запустил, что дальше?**
     - Навигация по сервису:
       - [Домашняя страница, все покупки](http://localhost:8181/index.html)
       - [Список покупок за последнюю неделю](http://localhost:8181/purchases/weekly/info.html)
       - [Самый покупаемый товар за последний месяц](http://localhost:8181/goods/monthly/best/info.html)
       - [Создать покупку](http://localhost:8181/purchases/create/info.html)
       - [Имя и фамилия человека, совершившего больше всего покупок за полгода](http://localhost:8181/clients/halfyearly/best/info.html)
       - [Что чаще всего покупают люди в возрасте 18 лет](http://localhost:8181/goods/eighteen/best/info.html)
     - Дополнительно:
       -  [PgAdmin](http://localhost:5050)
       -  [Прямая сслыка на бд](http://localhost:15432/shop_db)
       -  [Ссылка на xsd-request](https://github.com/DenisBak/shop/blob/main/request.xsd)

3. **Проблемы?**
   - Если неполадки с liquibase локами, попробуй снести две таблицы с лог и лок

> [!CAUTION]
> ПАРОЛИ 🔐
> - Authorization
>   - admin:password
> - PgAdmin
>   - admin@admin.com:root
> - PostgreSQL
>   - root:root

### Обратная связь
- Я в [телеграмм](https://t.me/leshiycc)
