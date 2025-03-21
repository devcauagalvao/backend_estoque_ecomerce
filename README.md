# 📦 Projeto Estoque

## 📌 Visão Geral
O **Projeto Estoque** é um sistema web desenvolvido com **Spring Boot** no backend e **React** no frontend. Ele permite o **upload de imagens** e o **armazenamento de informações sobre tênis**, além de possuir um **sistema de login seguro**.

## 🚀 Tecnologias Utilizadas
- **Backend:** 🖥️ Java - Spring Boot
- **Frontend:** ⚛️ React
- **Banco de Dados:** 🗄️ MySQL
- **Autenticação:** 🔑 JWT
- **Gerenciador de Pacotes:** 📦 NPM

## 🎯 Funcionalidades
✅ **Sistema de Login**
- Registro e login de usuários 🔐
- Autenticação com **JWT** 🏷️
- Proteção de rotas privadas 🔒

✅ **Upload e Exibição de Imagens**
- Upload de imagens através do backend 📤
- Validação de arquivos e formatos permitidos ✅
- Recuperação e exibição de imagens armazenadas 🖼️

## 🔗 Endpoints Principais
- **Registro:** 📩 `POST /api/auth/register`
- **Login:** 🔑 `POST /api/auth/login`
- **Upload de Imagens:** 📤 `POST /api/tennis/upload`
- **Exibição de Imagens:** 🖼️ `GET /api/tennis/images/{imageName}`

## 📂 Estrutura do Projeto

```
com
└── ecommerce
    └── tenis
        ├── controller
        │   └── TennisController.java
        ├── service
        ├── model
        ├── repository
        └── application.properties
```

## 🛠️ Instalação e Configuração
1. **Clone o repositório:**
   ```sh
   git clone https://github.com/seu-usuario/projeto-estoque.git
   ```
2. **Backend:**
   - Instale as dependências e execute o servidor:
     ```sh
     cd backend
     mvn spring-boot:run
     ```
3. **Frontend:**
   - Instale as dependências e inicie a aplicação:
     ```sh
     cd frontend
     npm install
     npm start
     ```

## 🔒 Considerações de Segurança
- **Proteção das APIs** com autenticação JWT 🏷️
- **Validação de arquivos** para evitar uploads maliciosos 🛡️
- **Armazenamento seguro** de senhas com hashing 🔑

👥 Colaboradores

Cauã Galvão Pereira Athayde - Desenvolvedor Backend

Eduardo - Desenvolvedor Frontend

## 📄 Licença
Este projeto está sob a licença **MIT** 📜.

