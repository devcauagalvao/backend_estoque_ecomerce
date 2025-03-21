# 📦 Projeto Estoque

## 📌 Visão Geral
O **Projeto Estoque** é um sistema web desenvolvido com **Spring Boot** no backend e **React** no frontend. Ele permite o **upload de imagens**, o **armazenamento de informações sobre tênis** e um **sistema de login seguro**. Cada usuário pode cadastrar seus próprios tênis e adicionar uma **foto de perfil**.

## 🚀 Tecnologias Utilizadas
- **Backend:** 🖥️ Java - Spring Boot
- **Frontend:** ⚛️ React
- **Banco de Dados:** 🐄 MySQL
- **Autenticação:** 🔑 JWT
- **Gerenciador de Pacotes:** 📦 Yarn

## 🎯 Funcionalidades
✅ **Sistema de Login**
- Registro e login de usuários 🔐
- Autenticação com **JWT** 🏏️
- Proteção de rotas privadas 🔒

✅ **Gestão de Tênis**
- Cadastro de tênis por usuário 👟
- Listagem de tênis do usuário 📝
- Exclusão de tênis do sistema 🔍

✅ **Upload e Exibição de Imagens**
- Upload de imagens através do backend 💄
- Validação de arquivos e formatos permitidos ✅
- Recuperação e exibição de imagens armazenadas 🌟
- Adição de **foto de perfil** para usuários 📷

## 🔗 Endpoints Principais
- **Registro:** 📩 `POST /api/auth/register`
- **Login:** 🔑 `POST /api/auth/login`
- **Cadastro de Tênis:** 👟 `POST /api/tennis`
- **Listagem de Tênis por Usuário:** 📝 `GET /api/tennis/usuario/{usuarioId}`
- **Exclusão de Tênis:** 🔍 `DELETE /api/tennis/{id}`
- **Upload de Imagens:** 💄 `POST /api/tennis/upload`
- **Exibição de Imagens:** 🎨 `GET /api/tennis/images/{imageName}`
- **Upload de Foto de Perfil:** 📷 `POST /api/usuarios/upload-foto`

## 💂️\200d♂️ Estrutura do Projeto

```
com
└── ecommerce
    └── tenis
        ├── config
        │   ├── SecurityConfig.java
        │   └── WebConfig.java
        ├── controller
        │   ├── AuthController.java
        │   ├── TennisController.java
        │   ├── UploadService.java
        │   └── UsuarioController.java
        ├── model
        │   ├── Tennis.java
        │   ├── Usuario.java
        │   └── Imagem.java
        ├── repository
        │   ├── TennisRepository.java
        │   ├── UsuarioRepository.java
        │   └── ImagemRepository.java
        ├── service
        │   ├── TennisService.java
        │   ├── UsuarioService.java
        │   ├── UploadService.java
        │   └── EcommerceTenisApplication.java
resources
├── static
├── templates
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
     yarn install
     yarn start
     ```

## 🔒 Considerações de Segurança
- **Proteção das APIs** com autenticação JWT 🏏️
- **Validação de arquivos** para evitar uploads maliciosos 🛡️
- **Armazenamento seguro** de senhas com hashing 🔑

👥 Colaboradores

Cauã Galvão Pereira Athayde - Desenvolvedor Backend

Eduardo - Desenvolvedor Frontend

## 📝 Licença
Este projeto está sob a licença **MIT** 🐜.


