# Java REST сервис по CRUD операциям
## Via: Maven, Spring Boot, Securtiy, PostgreSQL, Liquibase, Docker, dbAdmin

1. **Как запустить?**
     - Клонируем репозиторий, переходим в рутовую папку, запускаем `docker-compose up`, если будете что то изменять - не забудьте добавить `--build`

> [!IMPORTANT]
> В самом конце я указал логины и пароли для каждого из сервисов, перед тем как проходить по ссылкам, убедитесь, что вы прошли auth :shipit:
       
2. **Я запустил, что дальше?**
     - Навигация по сервису:
       - [Список покупок за последнюю неделю](http://localhost:8181/weekly/purchase)
       - [Самый покупаемый товар за последний месяц](http://localhost:8181/monthly/good/best)
       - [Имя и фамилия человека, совершившего больше всего покупок за полгода](http://localhost:8181/halfyearly/buyer/best)
       - [Что чаще всего покупают люди в возрасте 18 лет](http://localhost:8181/good/eighteen/best)
     - Дополнительно:
       -  [PgAdmin](http://localhost:5050)
       -  [Прямая сслыка на бд](http://localhost:15432/shop_db)
       -  [Ссылка на xsd-request](https://github.com/DenisBak/shop/blob/main/request.xsd)

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
