# quintrix-spring
Repository for Java Spring application

In application.yml -> Added the following:

   naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
        implicit-strategy: org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl

One of the table refered to in the 'City' entity is listed as "CountryCode". JPA attempts to convert this to "Country_Code" without the above snippet in the application.yml file.