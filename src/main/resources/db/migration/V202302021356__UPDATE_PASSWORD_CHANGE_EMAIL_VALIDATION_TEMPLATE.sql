UPDATE email_template
SET version = '1.0',
    content = '<!doctype html>
<html lang="en">
<head>
</head>
<body>
    <h3>Olá, <span th:text="${personFirstName}"></span> <span th:text="${personLastName}"></span>!</h3>
    <p>Foi solicitado uma troca de senha!</p>
    <p>Para trocar a senha clique <a th:href="{validationLink}">aqui</a></p>
</body>
</html>'
WHERE id = 3;