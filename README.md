# 📌 Projeto Estoque em Java

## 📖 Visão Geral

Este projeto é um sistema web que permite o gerenciamento de upload de imagens e armazenamento de informações sobre tênis. Ele utiliza **Spring Boot** no backend e **React** no frontend, garantindo uma estrutura robusta e escalável.

## 🚀 Tecnologias Utilizadas

- **Backend:** Spring Boot
- **Frontend:** React wbe
- **Banco de Dados:** MySQL
- **Gerenciador de Pacotes:** NPM

## 🏗️ Arquitetura do Sistema

O sistema segue uma arquitetura **cliente-servidor**, onde:

- O **frontend** é responsável pela interface do usuário e interação.
- O **backend** gerencia a lógica de negócios, armazenamento de dados e processamento das imagens.

## 🔥 Funcionalidades

✅ **Upload de Imagens**: Os usuários podem enviar imagens através do frontend.
✅ **Validação de Arquivos**: Apenas arquivos válidos (JPG, PNG) são aceitos.
✅ **Exibição de Imagens**: O frontend pode recuperar e exibir imagens armazenadas no backend.
✅ **Armazenamento Escalável**: Possibilidade de armazenamento local ou em serviços de nuvem (AWS S3, Google Cloud Storage, etc.).

## 🛠️ Como Rodar o Projeto

### 🔧 Configurando o Backend (Spring Boot)

1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Acesse a pasta do backend:
   ```sh
   cd backend
   ```
3. Configure o arquivo **application.properties** com as credenciais do banco de dados.
4. Execute o projeto:
   ```sh
   mvn spring-boot:run
   ```

### 🖥️ Configurando o Frontend (React)

1. Acesse a pasta do frontend:
   ```sh
   cd frontend
   ```
2. Instale as dependências:
   ```sh
   npm install
   ```
3. Inicie a aplicação:
   ```sh
   npm start
   ```

## 🔗 Endpoints Principais

### 📤 Upload de Imagem

- **URL:** `POST /api/tennis/upload`
- **Descrição:** Envia uma imagem para armazenamento.



## 🛡️ Segurança e Performance

🔹 **Validação de Arquivos**: Apenas formatos permitidos são aceitos.


## 📌 Estrutura de Diretórios

```
backend/
├── src/main/java/com/ecommerce/tenis/
│   ├── controller/
│   │   └── TennisController.java
│   ├── service/
│   ├── model/
│   ├── repository/
│   └── application.properties
frontend/
├── src/
│   ├── components/
│   ├── pages/
│   ├── App.js
│   ├── index.js
└── package.json
```

## 🧪 Testes

- **Backend:** Testes unitários e de integração para garantir a comunicação correta entre os componentes.
- **Frontend:** Testes de interface para verificar a exibição correta das imagens.

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## 🤝 Contribuição
Front desenvolvido por: https://github.com/EduardoHenriqueDev


## 📬 Contato

Caso tenha dúvidas ou sugestões, entre em contato:
📧 Email: cauadev20@gmail.com
🌐 LinkedIn: https://www.linkedin.com/in/cauã-galvão-dev/
