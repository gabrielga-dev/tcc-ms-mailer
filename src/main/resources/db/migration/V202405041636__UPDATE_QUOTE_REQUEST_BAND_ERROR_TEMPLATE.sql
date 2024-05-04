UPDATE email_template
SET name = 'BAND_QUOTE_REQUEST_ERROR',
    version = '0.2',
    content = '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h4>Olá! O recente um pedido de orçamento para o evento <span th:text="${eventName}"></span> não pode ser enviado =[ <h3>
</body>
</html>
'
WHERE id = 7;
