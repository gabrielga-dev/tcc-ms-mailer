
UPDATE email_template
SET version = '0.2',
    content = '<!doctype html>
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
    <span th:text="${observation}"></span>
    </p>
</body>
</html>
'
WHERE id = 9;

