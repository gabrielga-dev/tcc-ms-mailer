INSERT INTO email_template
    (name, description, version, content)
values ('QUOTE_REQUEST_DECLINED',
        'This email will be sent when a quote request is declined.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h4>Olá! O recente pedido de orçamento para o evento <span th:text="${eventName}"></span>  para a(o) <span th:text="${businessTypeName}"></span> foi negado =[ <h4>
</body>
</html>
')
