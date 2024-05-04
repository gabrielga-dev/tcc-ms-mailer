INSERT INTO email_template
    (name, description, version, content)
values ('NEW_BAND_QUOTE_REQUEST',
        'This email will be sent when a contractor requests a quote to a band.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h3>Olá! Tem um novo pedido de orçamento  na área!</h3>
    <p>
        Sua banda <span th:text="${bandName}"></span> está sendo chamada para tocar no evento <span th:text="${eventName}"></span>, que ocorrerá
        no dia <span th:text="${eventDate}"></span> às <span th:text="${eventTime}"></span> no endereço <span th:text="${eventAddress}"></span>
        em <span th:text="${city}"></span>, <span th:text="${state}"></span>.
    </p>
    <p>Ah! O responsável pelo evento lhe enviou a seguinte mensagem também:</p>
    <p>"<span th:text="${description}"></span>"</p>
    <p>Veja os pedidos de orçamentos da <span th:text="${bandName}"></span> <a th:href="${quoteRequestsSiteLink}">aqui</a>.</p>
</body>
</html>
')
