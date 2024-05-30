INSERT INTO email_template
    (name, description, version, content)
values ('QUOTE_REQUEST_ANSWERED',
        'This email will be sent when a quote request is answered.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <p>
    Olá! O recente pedido de orçamento para o evento <span th:text="${eventName}"></span> para a(o)
    <span th:text="${businessTypeName}"></span>, <span th:text="${businessName}"></span>, foi respondido!
    </p>
    <p>
    O preço respondido é <span th:text="${price}"></span>.
    </p>
    <p>
    Obs.: <span th:text="${observation}"></span>
    </p>
</body>
</html>
')
