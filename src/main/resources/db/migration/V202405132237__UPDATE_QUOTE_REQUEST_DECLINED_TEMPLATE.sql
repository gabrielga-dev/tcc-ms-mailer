
UPDATE email_template
SET version = '0.2',
    content = '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h4>Olá! O recente pedido de orçamento para o evento <span th:text="${eventName}"></span>  para a(o) <span th:text="${businessTypeName}"></span> foi negado =[ </h4>
</body>
</html>
'
WHERE id = 8;
