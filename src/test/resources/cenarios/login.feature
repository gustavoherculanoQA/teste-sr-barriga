#language: pt
  Funcionalidade: Login no site do SrBarriga

    Cenario: Preencher Email e senha corretos
      Dado que estou no site do SrBarriga
      Quando preencher email "mic@local.dev" e senha "qwe123"
      E clicar em Entrar
      Entao o sistema mostra a notificacao de sucesso "Bem vindo, GUSTAVO !"

    Cenario: Preencher Email correto e senha errado
      Dado que estou no site do SrBarriga
      Quando preencher email "mic@local.dev" e senha "qwe1233"
      E clicar em Entrar
      Entao o sistema mostra a primeira notificacao de erro "Problemas com o login do usuário"

    Cenario: Preencher Email correto e senha VAZIOs
      Dado que estou no site do SrBarriga
      Quando preencher email "" e senha ""
      E clicar em Entrar
      Entao o sistema mostra a primeira notificacao de erro "Email é um campo obrigatório"
      E o sistema mostra a segunda notificacao de erro "Senha é um campo obrigatório"

    Cenario: Email vazio e senha preenchido
      Dado que estou no site do SrBarriga
      Quando preencher email "" e senha "qwe123"
      E clicar em Entrar
      Entao o sistema mostra a primeira notificacao de erro "Email é um campo obrigatório"

    Cenario: Email preenchido corretamente e senha VAZIA
      Dado que estou no site do SrBarriga
      Quando preencher email "mic@local.dev" e senha ""
      E clicar em Entrar
      Entao o sistema mostra a primeira notificacao de erro "Senha é um campo obrigatório"
