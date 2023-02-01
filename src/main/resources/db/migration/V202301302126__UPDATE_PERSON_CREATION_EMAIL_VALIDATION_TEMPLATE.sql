UPDATE email_template
SET version = '1.0',
    content = '<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" href="style.css" />

    <style type="text/css">
        * { font-family: Arial, sans-serif; }
    </style>
</head>

<body>
    <h3>Olá, {personFirstName} {personLastName}!</h3>
    <p>Bem vindo(a) à nossa plataforma de eventos, MyEvents!</p>
    <p>Para validar seu email, clique <a href="{validationLink}">aqui</a></p>
</body>
</html>
'
WHERE id = 2;