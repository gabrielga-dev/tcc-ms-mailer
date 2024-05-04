UPDATE email_template
SET version = '0.3',
    content = '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h4>Olá! O recente um pedido de orçamento para o evento <span th:text="${eventName}"></span> não pode ser enviado =[ </h4>
</body>
</html>
'
WHERE id = 7;
