![campus-formiga.jpg](doc/images/campus-formiga.jpg)

Olá! Este é o microsserviço "ms-mailer", ele compõe o TCC: "APLICAÇÃO DE UMA ARQUITETURA DE MICROSSERVIÇOS EM UM
SISTEMA WEB PARA CONECTAR PRODUTORES DE EVENTOS E PRESTADORES DE SERVIÇOS".

Sua principal função é receber as requisições de envios de e-mails por uma fila e executá-los. Além disso, ele comporta
o script docker necessário para subir o ambiente do projeto.

Tal script se encontra no arquivo [docker-compose.yml](docker/docker-compose.yml) e **ele deve ser executado através do
comando antes de se executar qualquer microsserviço**:

```
docker-compose up -d
```

**Observação:** existem casos que o container do localstack não executa os comandos automaticamente, fazendo necessário
executar os seguintes comandos dentro do respectivo container para gerar as filas:

```
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name my-events-email-request &&
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name my-events-update-musician-request &&
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name my-events-quote-request-band &&
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name my-events-quote-request-band-dlq &&
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name my-events-quote-request-accepted &&
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name my-events-quote-request-event-answer
```

Além disso, é preciso criar uma cópia do arquivo 
[application.properties.example](src/main/resources/application.properties.example), removendo o final ".example", e
alterando os placeholders "<YOUR_EMAIL_HERE>" e "<YOUR_PASSWORD_HERE>" pelo endereço de e-mail e senha de uso em 
aplicações terceiras, respectivamente.

Para executar o microsserviço, basta rodar o seguinte comando:
```
mvn spring-boot:run
```
ou simplesmente importando o projeto em sua IDE de preferência e executando através dela.