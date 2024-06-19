INSERT INTO email_template
    (name, description, version, content)
values ('QUOTE_HIRED',
        'This email will be sent when a quote is hired.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <p>
    Olá! O recente pedido de orçamento para o evento <span th:text="${eventName}"></span> para a(o)
    <span th:text="${businessTypeName}"></span>, <span th:text="${businessName}"></span>, foi contratado!
    </p>
</body>
</html>
')
