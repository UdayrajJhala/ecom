## simple ecommerce website using spring boot, postgres, JPA and react


before running:
- create ecom-backend/src/main/resources/application.properties
- add:
  ```
  spring.application.name=jobAppREST
  spring.datasource.url=your_database_url
  spring.datasource.username:your_database_username
  spring.datasource.password:your_database_password
  spring.datasource.driver-class-name:org.postgresql.Driver
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.datasource.hikari.auto-commit=false
  ```
