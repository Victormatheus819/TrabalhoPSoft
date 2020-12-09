# 1. Compilação do código

Para rodar a aplicação vá até o arquivo PsoftApplication e aperte o botão de play no lado superior direito do VSCode, depois vá até o seu navegador e digite na barra de busca localhost:8080/.
Para o projeto usamos no VSCode ( link de download: https://code.visualstudio.com/download ) usamos as seguintes extensões:
 
 :small_blue_diamond: Spring Boot Extension Pack

 :small_blue_diamond: Java Extension Pack

 :small_blue_diamond: Lombok Annotations Support for VS Code

## 1.2-Banco de dados
Para a parte de banco de dados usamos o postgreSQL ( link de download: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads )

Para criar o banco em sua máquina é preciso abrir o arquivo contido na pasta script do projeto no PgAdmin e rodá-lo. Para mais esclarecimentos leia os comentários presente no arquivo de script.

# 2. Estrutura do código
O projeto é inicialmente dividido em 2 pastas, a script, contendo o arquivo de criação de banco de dados, e a main, onde está o código da aplicação de fato.

A Pasta main é subdividida em duas pastas, a pasta resources possui os arquivos que definem a interface da aplicação (a subpasta static contém arquivos de estilo css e arquivos javascript e a subpasta templates contém os arquivos html), e a pasta java\com\psoft\app possui a lógica da aplicação. Essa pasta é subdividida em mais 5 pastas, controller, config, dao, model, service e ainda possui os seguintes arquivos Java: 
```
ObsevableLoja : Interface observable implementada na aplicação

ObserverLoja : Interface observer implementada na aplicação

PsoftApplication : Arquivo de inicialização da aplicação. 
```
A pasta controller possui os arquivos responsáveis pela mediação entre a interface e o banco de dados. A pasta config contém o arquivo SegurancaInterceptor, responsável por receber as requisições web e o arquivo AppConfig, que possui as configurações do spring.
Já a pasta dao, possui os arquivos que coordenam os comandos de inclusão, exclusão e alteração dos dados no banco de dados. A pasta model, possui os arquivos de modelagem do banco de dados. E por último, a pasta service possui os arquivos que define os eventos a serem chamados pela interface.
```
|.mvn/wrapper

|documentacao

|src

	|__main

		|____java

			|______com

				|________psoft

					|__________app

						|____________config

						|____________controller

						|____________dao

						|____________model

						|____________service

		|____resources

			|______static

				|________css

				|________ js

			|______ templates

	|__script
 ```

# 3. Documentação
A documentação está localizada na pasta **documentacao**, que se encontra na raiz do projeto, no formato pdf, .
