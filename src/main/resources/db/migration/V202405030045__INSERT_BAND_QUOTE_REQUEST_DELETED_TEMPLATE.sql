INSERT INTO email_template
    (name, description, version, content)
values ('NEW_BAND_QUOTE_REQUEST',
        'This email will be sent when an saving of a quote request fails.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h4>Olá! O recente pedido de orçamento para o evento <span th:text="${eventName}"></span> não pode ser enviado =[ <h3>
    <p>Acesse os pedidos de orçamentos respectiva banda <a th:href="${quoteRequestsSiteLink}">aqui</a>.</p>
</body>
</html>
')
