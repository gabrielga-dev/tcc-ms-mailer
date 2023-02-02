INSERT INTO email_template
    (name, description, version, content)
values ('PASSWORD_CHANGE_EMAIL_VALIDATION',
        'This email will be sent when a someone wants to change the password.',
        '0.1',
        '<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" href="style.css" />

    <style type="text/css">
        * { font-family: Arial, sans-serif; }
    </style>
</head>

<body>
    <h3>Olá, <span th:text="${personFirstName}"></span> <span th:text="${personLastName}"></span>!</h3>
    <p>Foi solicitado uma troca de senha!</p>
    <p>Para trocar a senha clique <a th:href="{validationLink}">aqui</a></p>
</body>
</html>
')